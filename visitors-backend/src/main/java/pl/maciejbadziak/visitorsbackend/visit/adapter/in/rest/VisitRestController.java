package pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest.resources.VisitResource;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;
import pl.maciejbadziak.visitorsbackend.visit.usecase.SaveVisitUseCase;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/visits")
public class VisitRestController {

    private final SaveVisitUseCase saveVisitUseCase;

    private final VisitInAssembler visitInAssembler;

    private final VisitResourceAssembler visitResourceAssembler;

    @PostMapping(
            path = "/save",
            produces = APPLICATION_JSON_VALUE)
    public VisitResource saveVisit(@RequestBody @Valid VisitResource visitResource) {
        final Visit visit = visitInAssembler.assemble(visitResource);
        return visitResourceAssembler.assemble(saveVisitUseCase.save(visit));
    }
}
