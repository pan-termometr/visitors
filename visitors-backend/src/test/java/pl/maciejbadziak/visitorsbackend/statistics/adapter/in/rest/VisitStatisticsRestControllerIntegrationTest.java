package pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import pl.maciejbadziak.visitorsbackend.IntegrationTest;
import pl.maciejbadziak.visitorsbackend.visit.adapter.out.jpa.VisitRepository;

import static java.util.List.of;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitEntityTestData.*;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitEntityTestData.visitEntity230102_2;

@AutoConfigureMockMvc
class VisitStatisticsRestControllerIntegrationTest extends IntegrationTest {

    private static final String ENDPOINT_URL = "/statistics";

    @Autowired
    private transient MockMvc mvc;

    @Autowired
    private transient VisitRepository visitRepository;

    @BeforeEach
    public void init() {
        visitRepository.deleteAll();
    }

    @Test
    void shouldReturnVisitStatistics() throws Exception {
        // given
        visitRepository.saveAll(of(visitEntity230102(), visitEntity230102_2(), visitEntity230103()));

        // when
        final ResultActions result = mvc.perform(get(ENDPOINT_URL)
                .contentType(APPLICATION_JSON));

        // then
        result.andExpect(status().is2xxSuccessful())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].date", is("2023-01-02")))
                .andExpect(jsonPath("$[0].count", is(2)))
                .andExpect(jsonPath("$[1].date", is("2023-01-03")))
                .andExpect(jsonPath("$[1].count", is(1)));
    }
}
