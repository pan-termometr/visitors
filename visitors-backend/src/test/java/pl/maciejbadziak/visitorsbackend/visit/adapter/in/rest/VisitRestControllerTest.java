package pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest.resource.VisitResource;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;
import pl.maciejbadziak.visitorsbackend.visit.usecase.SaveVisitUseCase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitResourceTestData.visitResource230101;
import static pl.maciejbadziak.visitorsbackend.visit.testdata.VisitTestData.visit230101;

@ExtendWith(MockitoExtension.class)
class VisitRestControllerTest {

    @Mock
    private transient SaveVisitUseCase saveVisitUseCaseMock;

    @Mock
    private transient VisitInAssembler visitInAssemblerMock;

    @Mock
    private transient VisitResourceAssembler visitResourceAssemblerMock;

    @InjectMocks
    private transient VisitRestController visitRestController;

    @Test
    void shouldThrowAnExceptionWhenRequestWithoutDate() {
        // given
        final VisitResource visitResource = visitResource230101();
        final Visit visit = visit230101();

        when(visitInAssemblerMock.assemble(visitResource)).thenReturn(visit);
        when(saveVisitUseCaseMock.save(visit)).thenReturn(visit);
        when(visitResourceAssemblerMock.assemble(visit)).thenReturn(visitResource);

        // when
        final VisitResource result = visitRestController.saveVisit(visitResource);

        // then
        assertThat(result).isEqualTo(visitResource);
        verify(visitInAssemblerMock).assemble(visitResource);
        verify(saveVisitUseCaseMock).save(visit);
        verify(visitResourceAssemblerMock).assemble(visit);
    }
}
