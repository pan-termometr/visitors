package pl.maciejbadziak.visitorsbackend.visit.adapter.out.jpa;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitEntityTestData.visitEntity230101;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitEntityTestData.visitEntity230102;

class VisitOutAssemblerTest {

    @Test
    void shouldAssembleVisit() {
        // given
        final VisitEntity visitEntity = visitEntity230101();

        // when
        final Visit result = new VisitOutAssembler().assemble(visitEntity);

        // then
        assertThat(result).extracting(
                Visit::getDate,
                visit -> visit.getIp().getValue()
        ).containsExactly(
                visitEntity.getDate(),
                visitEntity.getIp()
        );
    }

    @Test
    void shouldAssembleVisits() {
        // given
        final List<VisitEntity> visitEntities = of(visitEntity230101(), visitEntity230102());

        // when
        final List<Visit> result = new VisitOutAssembler().assemble(visitEntities);

        // then
        assertThat(result).hasSameSizeAs(visitEntities);
    }
}
