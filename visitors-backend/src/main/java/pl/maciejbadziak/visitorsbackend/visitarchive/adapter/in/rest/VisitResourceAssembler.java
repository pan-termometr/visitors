package pl.maciejbadziak.visitorsbackend.visitarchive.adapter.in.rest;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visitarchive.adapter.in.rest.resources.VisitResource;
import pl.maciejbadziak.visitorsbackend.visitarchive.domain.Visit;

@Component
public class VisitResourceAssembler {

    public VisitResource assemble(final Visit visit) {
        if(visit == null) {
            return null;
        }
        return VisitResource.builder()
                .date(visit.getDate())
                .ip(visit.getIp().getValue())
                .build();
    }
}
