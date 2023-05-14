package pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest.resource.VisitStatisticsResource;
import pl.maciejbadziak.visitorsbackend.statistics.domain.DailyVisitStatistics;

import java.util.Comparator;
import java.util.List;

import static java.util.Collections.emptyList;

@Component
public class VisitStatisticsResourceAssembler {

    public List<VisitStatisticsResource> assemble(final List<DailyVisitStatistics> dailyVisitStatistics) {
        if(dailyVisitStatistics == null) {
            return emptyList();
        }
        return dailyVisitStatistics.stream()
                .map(this::assemble)
                .sorted(Comparator.comparing(VisitStatisticsResource::getDate))
                .toList();
    }

    private VisitStatisticsResource assemble(final DailyVisitStatistics dailyVisitStatistics) {
        return VisitStatisticsResource.builder()
                .date(dailyVisitStatistics.getDate().toString())
                .count(dailyVisitStatistics.getNumberOfVisits())
                .build();
    }
}
