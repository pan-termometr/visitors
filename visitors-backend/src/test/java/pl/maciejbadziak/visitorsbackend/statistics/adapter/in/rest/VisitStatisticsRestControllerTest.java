package pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest.resource.VisitStatisticsResource;
import pl.maciejbadziak.visitorsbackend.statistics.domain.DailyVisitStatistics;
import pl.maciejbadziak.visitorsbackend.statistics.usecase.RetrieveVisitStatisticsUseCase;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.when;
import static pl.maciejbadziak.visitorsbackend.statistics.testdata.DailyVisitStatisticsTestData.dailyStats230101;
import static pl.maciejbadziak.visitorsbackend.statistics.testdata.DailyVisitStatisticsTestData.dailyStats230102;
import static pl.maciejbadziak.visitorsbackend.statistics.testdata.VisitStatisticsResourceTestData.visitStats230101;
import static pl.maciejbadziak.visitorsbackend.statistics.testdata.VisitStatisticsResourceTestData.visitStats230102;

@ExtendWith(MockitoExtension.class)
class VisitStatisticsRestControllerTest {

    @Mock
    private transient RetrieveVisitStatisticsUseCase retrieveVisitStatisticsUseCaseMock;

    @Mock
    private transient VisitStatisticsResourceAssembler resourceAssembler;

    @InjectMocks
    private transient VisitStatisticsRestController visitStatisticsRestController;

    @Test
    void shouldReturnVisitStatistics() {
        // given
        final List<DailyVisitStatistics> dailyVisitStatistics = of(dailyStats230101(), dailyStats230102());
        final List<VisitStatisticsResource> visitStatisticsResources = of(visitStats230101(), visitStats230102());

        when(retrieveVisitStatisticsUseCaseMock.retrieve()).thenReturn(dailyVisitStatistics);
        when(resourceAssembler.assemble(dailyVisitStatistics)).thenReturn(visitStatisticsResources);

        // when
        final List<VisitStatisticsResource> result = visitStatisticsRestController.getVisitStatistics();

        // then
        assertThat(result).extracting(
                VisitStatisticsResource::getDate,
                VisitStatisticsResource::getCount
        ).containsExactly(
                tuple(
                        dailyVisitStatistics.get(0).getDate().toString(),
                        dailyVisitStatistics.get(0).getNumberOfVisits()
                ),
                tuple(
                        dailyVisitStatistics.get(1).getDate().toString(),
                        dailyVisitStatistics.get(1).getNumberOfVisits()
                )
        );
    }
}
