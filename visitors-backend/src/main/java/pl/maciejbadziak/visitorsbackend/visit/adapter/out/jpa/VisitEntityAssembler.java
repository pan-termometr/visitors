package pl.maciejbadziak.visitorsbackend.visit.adapter.out.jpa;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

@Component
public class VisitEntityAssembler {

    public VisitEntity assemble(final Visit visit) {
        return VisitEntity.builder()
                .ip(visit.getIp().getValue())
                .date(visit.getDate())
                .build();
    }
}
