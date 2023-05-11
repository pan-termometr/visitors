package pl.maciejbadziak.visitorsbackend.visitarchive.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.visitorsbackend.visitarchive.domain.Visit;
import pl.maciejbadziak.visitorsbackend.visitarchive.port.SaveVisitPort;

@Component
@RequiredArgsConstructor
public class SaveVisitUseCase {

    private final SaveVisitPort saveVisitPort;

    public Visit save(final Visit visit) {
        return saveVisitPort.save(visit);
    }
}
