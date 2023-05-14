package pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import pl.maciejbadziak.visitorsbackend.IntegrationTest;
import pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest.resource.VisitResource;
import pl.maciejbadziak.visitorsbackend.visit.adapter.out.jpa.VisitEntity;
import pl.maciejbadziak.visitorsbackend.visit.adapter.out.jpa.VisitRepository;

import static java.time.LocalDate.parse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitResourceTestData.*;

@AutoConfigureMockMvc
class VisitRestControllerIntegrationTest extends IntegrationTest {

    private static final String ENDPOINT_URL = "/visits/save";

    private static final String INVALID_REQUEST_ERROR_MESSAGE = "Invalid request content.";

    @Autowired
    private transient MockMvc mvc;

    @Autowired
    private transient VisitRepository visitRepository;

    @BeforeEach
    public void init() {
        visitRepository.deleteAll();
    }

    @Test
    void shouldSaveVisitInDatabase() throws Exception {
        // given
        final VisitResource visitResource = visitResource230101();
        final String requestBody = asJsonString(visitResource);

        // when
        final ResultActions result = mvc.perform(post(ENDPOINT_URL)
                .contentType(APPLICATION_JSON)
                .content(requestBody));

        // then
        final VisitEntity visitEntity = visitRepository.getReferenceById(1L);
        result.andExpect(status().is2xxSuccessful())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$.date", is(visitResource.getDate())))
                .andExpect(jsonPath("$.ip", is(visitResource.getIp())));
        assertThat(visitEntity)
                .extracting(
                        VisitEntity::getId,
                        VisitEntity::getDate,
                        VisitEntity::getIp
        ).containsExactly(
                1L,
                parse(visitResource.getDate()),
                visitResource.getIp()
                );
    }

    @ParameterizedTest
    @MethodSource("invalidRequests")
    void shouldReturnAnErrorWithRequestWithMissingDate(
            final VisitResource visitResource
    ) throws Exception {
        // given
        final String requestBody = asJsonString(visitResource);

        // when
        final ResultActions result = mvc.perform(post(ENDPOINT_URL)
                .contentType(APPLICATION_JSON)
                .content(requestBody));

        // then
        result.andExpect(status().is4xxClientError())
                .andExpect(status().is(BAD_REQUEST.value()))
                .andExpect(status().reason(INVALID_REQUEST_ERROR_MESSAGE));
    }

    private static String asJsonString(final VisitResource visitResource) {
        try {
            return new ObjectMapper().writeValueAsString(visitResource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object[][] invalidRequests() {
        return new Object[][] {
                { visitResourceWithMissingDate() },
                { visitResourceWithMissingIp() },
        };
    }
}
