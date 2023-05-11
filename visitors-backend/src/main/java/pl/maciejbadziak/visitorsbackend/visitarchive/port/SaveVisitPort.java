package pl.maciejbadziak.visitorsbackend.visitarchive.port;

import pl.maciejbadziak.visitorsbackend.visitarchive.domain.Visit;

public interface SaveVisitPort {

    Visit save(final Visit visit);
}
