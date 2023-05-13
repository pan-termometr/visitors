package pl.maciejbadziak.visitorsbackend.statistics.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DailyVisitStatistics {

    LocalDate date;

    Long numberOfVisits;
}
