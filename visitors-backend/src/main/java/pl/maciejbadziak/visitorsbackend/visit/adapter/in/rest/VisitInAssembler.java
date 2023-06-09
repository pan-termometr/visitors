package pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest.resource.VisitResource;
import pl.maciejbadziak.visitorsbackend.visit.domain.Ip;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

import static java.time.LocalDate.parse;

@Component
public class VisitInAssembler {

    public Visit assemble(final VisitResource visitResource) {
        return Visit.builder()
                .date(parse(visitResource.getDate()))
                .ip(Ip.of(visitResource.getIp()))
                .build();
    }
}
