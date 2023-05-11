package pl.maciejbadziak.visitorsbackend.visitarchive.adapter.in.rest;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visitarchive.adapter.in.rest.resources.VisitResource;
import pl.maciejbadziak.visitorsbackend.visitarchive.domain.Ip;
import pl.maciejbadziak.visitorsbackend.visitarchive.domain.Visit;

@Component
public class VisitInAssembler {

    public Visit assemble(final VisitResource visitResource) {
        return Visit.builder()
                .date(visitResource.getDate())
                .ip(Ip.of(visitResource.getIp()))
                .build();
    }
}
