package pl.maciejbadziak.visitorsbackend.visit.adapter.out.jpa;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;
import pl.maciejbadziak.visitorsbackend.visit.testdata.VisitTestData;

import static org.assertj.core.api.Assertions.assertThat;

class VisitEntityAssemblerTest {

    @Test
    void shouldAssembleVisitEntity() {
        // given
        final Visit visit = VisitTestData.visit230101();

        // when
        final VisitEntity result = new VisitEntityAssembler().assemble(visit);

        // then
        assertThat(result).extracting(
                VisitEntity::getDate,
                VisitEntity::getIp
        ).containsExactly(
                visit.getDate(),
                visit.getIp().getValue()
        );
    }
}
