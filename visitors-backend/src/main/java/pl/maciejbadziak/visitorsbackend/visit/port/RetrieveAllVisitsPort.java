package pl.maciejbadziak.visitorsbackend.visit.port;

import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

import java.util.List;

public interface RetrieveAllVisitsPort {

    List<Visit> retrieve();
}
