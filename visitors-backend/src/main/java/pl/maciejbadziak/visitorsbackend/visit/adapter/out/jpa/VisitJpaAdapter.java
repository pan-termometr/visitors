package pl.maciejbadziak.visitorsbackend.visit.adapter.out.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;
import pl.maciejbadziak.visitorsbackend.visit.port.RetrieveAllVisitsPort;
import pl.maciejbadziak.visitorsbackend.visit.port.SaveVisitPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VisitJpaAdapter implements SaveVisitPort, RetrieveAllVisitsPort {

    private final VisitRepository repository;

    private final VisitOutAssembler assembler;

    private final VisitEntityAssembler entityAssembler;

    @Override
    public Visit save(Visit visit) {
        final VisitEntity entity = entityAssembler.assemble(visit);
        return assembler.assemble(repository.save(entity));
    }

    @Override
    public List<Visit> retrieve() {
        return assembler.assemble(repository.findAll());
    }
}
