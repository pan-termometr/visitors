package pl.maciejbadziak.visitorsbackend.visit.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;
import pl.maciejbadziak.visitorsbackend.visit.port.SaveVisitPort;

@Component
@RequiredArgsConstructor
public class SaveVisitUseCase {

    private final SaveVisitPort saveVisitPort;

    public Visit save(final Visit visit) {
        return saveVisitPort.save(visit);
    }
}
