package pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest.resource.VisitStatisticsResource;
import pl.maciejbadziak.visitorsbackend.statistics.domain.DailyVisitStatistics;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static pl.maciejbadziak.visitorsbackend.statistics.testdata.DailyVisitStatisticsTestData.dailyStats230101;
import static pl.maciejbadziak.visitorsbackend.statistics.testdata.DailyVisitStatisticsTestData.dailyStats230102;

class VisitStatisticsResourceAssemblerTest {

    @Test
    void shouldAssembleVisits() {
        // given
        final List<DailyVisitStatistics> dailyVisitStatistics = of(dailyStats230101(), dailyStats230102());

        // when
        final List<VisitStatisticsResource> result = new VisitStatisticsResourceAssembler().assemble(dailyVisitStatistics);

        // then
        assertThat(result).extracting(
                VisitStatisticsResource::getDate,
                VisitStatisticsResource::getCount
        ).containsExactly(
                tuple(
                        dailyVisitStatistics.get(0).getDate().toString(),
                        dailyVisitStatistics.get(0).getNumberOfVisits()
                ),
                tuple(
                        dailyVisitStatistics.get(1).getDate().toString(),
                        dailyVisitStatistics.get(1).getNumberOfVisits()

                )
        );
    }

    @Test
    void shouldReturnEmptyListForNullableDailyVisitStatistics() {
        // given
        // when
        final List<VisitStatisticsResource> result = new VisitStatisticsResourceAssembler().assemble(null);

        // then
        assertThat(result).isEmpty();
    }
}
