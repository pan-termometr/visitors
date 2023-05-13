package pl.maciejbadziak.visitorsbackend.statistics.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;
import pl.maciejbadziak.visitorsbackend.statistics.domain.DailyVisitStatistics;
import pl.maciejbadziak.visitorsbackend.visit.port.RetrieveAllVisitsPort;
import pl.maciejbadziak.visitorsbackend.statistics.service.VisitStatisticsService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RetrieveVisitStatisticsUseCase {

    private final RetrieveAllVisitsPort retrieveAllVisitsPort;

    private final VisitStatisticsService visitStatisticsService;

    public List<DailyVisitStatistics> retrieve() {
        final List<Visit> allVisits = retrieveAllVisitsPort.retrieve();
        return visitStatisticsService.getDailyVisitStatistics(allVisits);
    }
}
