package pl.maciejbadziak.visitorsbackend.visit.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;
import pl.maciejbadziak.visitorsbackend.visit.domain.DailyVisitStatistics;
import pl.maciejbadziak.visitorsbackend.visit.port.RetrieveAllVisitsPort;
import pl.maciejbadziak.visitorsbackend.visit.service.VisitStatisticsService;

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
