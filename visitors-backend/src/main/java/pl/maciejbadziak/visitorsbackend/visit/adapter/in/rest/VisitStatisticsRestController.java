package pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest.resources.VisitStatisticsResource;
import pl.maciejbadziak.visitorsbackend.visit.usecase.RetrieveVisitStatisticsUseCase;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/visits")
public class VisitStatisticsRestController {

    private final RetrieveVisitStatisticsUseCase retrieveVisitStatisticsUseCase;

    private final VisitStatisticsResourceAssembler resourceAssembler;

    @GetMapping(
            path = "/statistics",
            produces = APPLICATION_JSON_VALUE)
    public List<VisitStatisticsResource> getVisitStatistics() {
        return resourceAssembler.assembleVisitResources(retrieveVisitStatisticsUseCase.retrieve());
    }
}
