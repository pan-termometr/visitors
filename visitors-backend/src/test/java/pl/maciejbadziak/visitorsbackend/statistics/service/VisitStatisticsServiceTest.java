package pl.maciejbadziak.visitorsbackend.statistics.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.maciejbadziak.visitorsbackend.statistics.domain.DailyVisitStatistics;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitTestData.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { VisitStatisticsService.class })
class VisitStatisticsServiceTest {

    @Autowired
    private transient VisitStatisticsService visitStatisticsService;

    @Test
    void shouldReturnSortedByDateDailyVisitStatistics() {
        // given
        final List<Visit> visits = List.of(visit230102(), visit230101(), visit230101_2());

        // when
        final List<DailyVisitStatistics> result = visitStatisticsService.getDailyVisitStatistics(visits);

        // then
        assertThat(result).extracting(
                DailyVisitStatistics::getDate,
                DailyVisitStatistics::getNumberOfVisits
        ).containsExactly(
                tuple(
                        visits.get(1).getDate(),
                        2L
                ),
                tuple(
                        visits.get(0).getDate(),
                        1L
                )
        );
    }
}
