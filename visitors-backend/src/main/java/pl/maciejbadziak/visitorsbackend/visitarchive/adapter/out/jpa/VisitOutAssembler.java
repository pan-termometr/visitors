package pl.maciejbadziak.visitorsbackend.visitarchive.adapter.out.jpa;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visitarchive.domain.Ip;
import pl.maciejbadziak.visitorsbackend.visitarchive.domain.Visit;

@Component
public class VisitOutAssembler {

    public Visit assemble(final VisitEntity visitEntity) {
        return Visit.builder()
                .date(visitEntity.getDate())
                .ip(Ip.of(visitEntity.getIp()))
                .build();
    }
}
