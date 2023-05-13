package pl.maciejbadziak.visitorsbackend.visit.adapter.out.jpa;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visit.domain.Ip;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

import java.util.List;

@Component
public class VisitOutAssembler {

    public List<Visit> assembleVisits(final List<VisitEntity> visitEntities) {
        return visitEntities.stream()
                .map(this::assembleVisit)
                .toList();
    }

    public Visit assembleVisit(final VisitEntity visitEntity) {
        return Visit.builder()
                .date(visitEntity.getDate())
                .ip(Ip.of(visitEntity.getIp()))
                .build();
    }
}
