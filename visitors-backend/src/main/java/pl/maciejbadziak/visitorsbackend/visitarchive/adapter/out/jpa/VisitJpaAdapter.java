package pl.maciejbadziak.visitorsbackend.visitarchive.adapter.out.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visitarchive.domain.Visit;
import pl.maciejbadziak.visitorsbackend.visitarchive.port.SaveVisitPort;

@Component
@RequiredArgsConstructor
public class VisitJpaAdapter implements SaveVisitPort {

    private final VisitRepository repository;

    private final VisitOutAssembler assembler;

    private final VisitEntityAssembler entityAssembler;

    @Override
    public Visit save(Visit visit) {
        VisitEntity entity = entityAssembler.assemble(visit);
        return assembler.assemble(repository.save(entity));
    }
}
