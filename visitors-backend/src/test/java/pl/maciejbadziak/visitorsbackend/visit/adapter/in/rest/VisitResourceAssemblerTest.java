package pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest.resource.VisitResource;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitTestData.visit230101;

class VisitResourceAssemblerTest {

    @Test
    void shouldAssembleVisitResource() {
        // given
        final Visit visit = visit230101();

        // when
        final VisitResource result = new VisitResourceAssembler().assemble(visit);

        // then
        assertThat(result).extracting(
                VisitResource::getDate,
                VisitResource::getIp
        ).containsExactly(
                visit.getDate().toString(),
                visit.getIp().getValue()
        );
    }

    @Test
    void shouldReturnNullForNullableVisit() {
        // given
        // when
        final VisitResource result = new VisitResourceAssembler().assemble(null);

        // then
        assertThat(result).isNull();
    }
}
