package pl.maciejbadziak.visitorsbackend.visit.port;

import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

public interface SaveVisitPort {

    Visit save(final Visit visit);
}
