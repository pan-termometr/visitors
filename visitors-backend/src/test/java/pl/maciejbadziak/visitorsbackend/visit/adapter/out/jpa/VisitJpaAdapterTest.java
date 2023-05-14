package pl.maciejbadziak.visitorsbackend.visit.adapter.out.jpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitEntityTestData.visitEntity230101;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitEntityTestData.visitEntity230102;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitTestData.visit230101;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitTestData.visit230102;

@ExtendWith(MockitoExtension.class)
class VisitJpaAdapterTest {

    @Mock
    private transient VisitRepository visitRepositoryMock;

    @Mock
    private transient VisitOutAssembler visitOutAssemblerMock;

    @Mock
    private transient VisitEntityAssembler visitEntityAssemblerMock;

    @InjectMocks
    private transient VisitJpaAdapter visitJpaAdapter;

    @Test
    void shouldSaveVisit() {
        // given
        final VisitEntity visitEntity = visitEntity230101();
        final Visit visit = visit230101();

        when(visitEntityAssemblerMock.assemble(visit)).thenReturn(visitEntity);
        when(visitRepositoryMock.save(visitEntity)).thenReturn(visitEntity);
        when(visitOutAssemblerMock.assemble(visitEntity)).thenReturn(visit);

        // when
        final Visit result = visitJpaAdapter.save(visit);

        // then
        assertThat(result).isEqualTo(visit);
        verify(visitEntityAssemblerMock).assemble(visit);
        verify(visitRepositoryMock).save(visitEntity);
        verify(visitOutAssemblerMock).assemble(visitEntity);
    }

    @Test
    void shouldRetrieveAllVisits() {
        // given
        final List<VisitEntity> visitEntities = of(visitEntity230101(), visitEntity230102());
        final List<Visit> visits = of(visit230101(), visit230102());

        when(visitRepositoryMock.findAll()).thenReturn(visitEntities);
        when(visitOutAssemblerMock.assemble(visitEntities)).thenReturn(visits);

        // when
        final List<Visit> result = visitJpaAdapter.retrieve();

        // then
        assertThat(result).extracting(
                Visit::getDate,
                visit -> visit.getIp().getValue()
        ).containsExactly(
                tuple(
                        visitEntities.get(0).getDate(),
                        visitEntities.get(0).getIp()
                ),
                tuple(
                        visitEntities.get(1).getDate(),
                        visitEntities.get(1).getIp()
                )
        );
    }
}
