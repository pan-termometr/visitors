package pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest.resource.VisitStatisticsResource;
import pl.maciejbadziak.visitorsbackend.statistics.domain.DailyVisitStatistics;

import java.util.Collections;
import java.util.List;

@Component
public class VisitStatisticsResourceAssembler {

    public List<VisitStatisticsResource> assembleVisitResources(final List<DailyVisitStatistics> dailyVisitStatistics) {
        if(dailyVisitStatistics == null) {
            return Collections.emptyList();
        }
        return dailyVisitStatistics.stream()
                .map(this::assembleVisitResource)
                .toList();
    }

    private VisitStatisticsResource assembleVisitResource(final DailyVisitStatistics dailyVisitStatistics) {
        return VisitStatisticsResource.builder()
                .date(dailyVisitStatistics.getDate())
                .numberOfVisits(dailyVisitStatistics.getNumberOfVisits())
                .build();
    }
}
