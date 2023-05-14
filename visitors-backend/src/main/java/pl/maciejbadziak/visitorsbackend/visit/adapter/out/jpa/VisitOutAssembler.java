package pl.maciejbadziak.visitorsbackend.visit.adapter.out.jpa;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visit.domain.Ip;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

import java.util.List;

@Component
public class VisitOutAssembler {

    public List<Visit> assemble(final List<VisitEntity> visitEntities) {
        return visitEntities.stream()
                .map(this::assemble)
                .toList();
    }

    public Visit assemble(final VisitEntity visitEntity) {
        return Visit.builder()
                .date(visitEntity.getDate())
                .ip(Ip.of(visitEntity.getIp()))
                .build();
    }
}
