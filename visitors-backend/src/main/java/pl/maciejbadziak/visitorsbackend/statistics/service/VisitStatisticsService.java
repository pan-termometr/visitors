package pl.maciejbadziak.visitorsbackend.statistics.service;

import org.springframework.stereotype.Service;
import pl.maciejbadziak.visitorsbackend.statistics.domain.DailyVisitStatistics;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;

@Service
public class VisitStatisticsService {

    public List<DailyVisitStatistics> getDailyVisitStatistics(final List<Visit> visits) {
        return visits.stream()
                .collect(Collectors.groupingBy(Visit::getDate, counting()))
                .entrySet()
                .stream()
                .map(entry -> DailyVisitStatistics
                        .builder()
                        .date(entry.getKey())
                        .numberOfVisits(entry.getValue())
                        .build())
                .sorted(comparing(DailyVisitStatistics::getDate))
                .toList();
    }
}
