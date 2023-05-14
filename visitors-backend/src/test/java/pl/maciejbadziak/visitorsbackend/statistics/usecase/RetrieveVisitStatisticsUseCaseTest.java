package pl.maciejbadziak.visitorsbackend.statistics.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.visitorsbackend.statistics.domain.DailyVisitStatistics;
import pl.maciejbadziak.visitorsbackend.statistics.service.VisitStatisticsService;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;
import pl.maciejbadziak.visitorsbackend.visit.port.RetrieveAllVisitsPort;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.when;
import static pl.maciejbadziak.visitorsbackend.statistics.testdata.DailyVisitStatisticsTestData.*;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitTestData.*;

@ExtendWith(MockitoExtension.class)
class RetrieveVisitStatisticsUseCaseTest {

    @Mock
    private transient RetrieveAllVisitsPort retrieveAllVisitsPort;

    @Mock
    private transient VisitStatisticsService visitStatisticsServiceMock;

    @InjectMocks
    private transient RetrieveVisitStatisticsUseCase retrieveVisitStatisticsUseCase;

    @Test
    void shouldRetrieveVisitStatistics() {
        // given
        final List<Visit> visits = of(visit230101(), visit230101_2(), visit230102());
        final List<DailyVisitStatistics> dailyVisitStatistics = of(dailyStats230101(), dailyStats230102());

        when(retrieveAllVisitsPort.retrieve()).thenReturn(visits);
        when(visitStatisticsServiceMock.getDailyVisitStatistics(visits)).thenReturn(dailyVisitStatistics);

        // when
        final List<DailyVisitStatistics> result = retrieveVisitStatisticsUseCase.retrieve();

        // then
        assertThat(result).extracting(
                DailyVisitStatistics::getDate,
                DailyVisitStatistics::getNumberOfVisits
        ).containsExactly(
                tuple(
                        visits.get(0).getDate(),
                        2L
                ),
                tuple(
                        visits.get(2).getDate(),
                        1L
                )
        );
    }
}
