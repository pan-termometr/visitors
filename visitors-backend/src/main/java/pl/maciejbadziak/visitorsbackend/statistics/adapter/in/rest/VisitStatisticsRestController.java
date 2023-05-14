package pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest.resource.VisitStatisticsResource;
import pl.maciejbadziak.visitorsbackend.statistics.usecase.RetrieveVisitStatisticsUseCase;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistics")
@CrossOrigin(origins = "http://localhost:4200")
public class VisitStatisticsRestController {

    private final RetrieveVisitStatisticsUseCase retrieveVisitStatisticsUseCase;

    private final VisitStatisticsResourceAssembler resourceAssembler;

    @GetMapping(
            produces = APPLICATION_JSON_VALUE)
    public List<VisitStatisticsResource> getVisitStatistics() {
        return resourceAssembler.assemble(retrieveVisitStatisticsUseCase.retrieve());
    }
}
