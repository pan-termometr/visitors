package pl.maciejbadziak.visitorsbackend.visit.domain;

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
