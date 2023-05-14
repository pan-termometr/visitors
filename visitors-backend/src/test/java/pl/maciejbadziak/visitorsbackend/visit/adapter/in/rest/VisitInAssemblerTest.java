package pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest.resource.VisitResource;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

import static java.time.LocalDate.parse;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitResourceTestData.visitResource230101;

class VisitInAssemblerTest {

    @Test
    void shouldAssembleVisit() {
        // given
        final VisitResource visitResource = visitResource230101();

        // when
        final Visit result = new VisitInAssembler().assemble(visitResource);

        // then
        assertThat(result).extracting(
                Visit::getDate,
                visit -> visit.getIp().getValue()
        ).containsExactly(
                parse(visitResource.getDate()),
                visitResource.getIp()
        );
    }
}
