package pl.maciejbadziak.visitorsbackend.visit.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;
import pl.maciejbadziak.visitorsbackend.visit.port.SaveVisitPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitTestData.visit230101;

@ExtendWith(MockitoExtension.class)
class SaveVisitUseCaseTest {

    @Mock
    private transient SaveVisitPort saveVisitPortMock;

    @InjectMocks
    private transient SaveVisitUseCase saveVisitUseCase;

    @Test
    void shouldSaveVisit() {
        // given
        final Visit visit = visit230101();

        when(saveVisitPortMock.save(visit)).thenReturn(visit);

        // when
        final Visit result = saveVisitUseCase.save(visit);

        // then
        assertThat(result).isEqualTo(visit);
    }
}
