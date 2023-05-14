package pl.maciejbadziak.visitorsbackend.statistics.testdata;

import pl.maciejbadziak.visitorsbackend.statistics.domain.DailyVisitStatistics;

import static java.time.LocalDate.of;

public class DailyVisitStatisticsTestData {

    public static DailyVisitStatistics dailyStats230101() {
        return DailyVisitStatistics.builder()
                .date(of(2023, 1, 1))
                .numberOfVisits(2L)
                .build();
    }

    public static DailyVisitStatistics dailyStats230102() {
        return DailyVisitStatistics.builder()
                .date(of(2023, 1, 2))
                .numberOfVisits(1L)
                .build();
    }
}
