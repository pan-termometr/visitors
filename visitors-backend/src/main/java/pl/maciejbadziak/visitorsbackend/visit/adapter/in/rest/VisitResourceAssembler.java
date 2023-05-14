package pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest.resource.VisitResource;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

@Component
public class VisitResourceAssembler {

    public VisitResource assemble(final Visit visit) {
        if(visit == null) {
            return null;
        }
        return VisitResource.builder()
                .date(visit.getDate().toString())
                .ip(visit.getIp().getValue())
                .build();
    }
}
