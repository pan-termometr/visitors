package pl.maciejbadziak.visitorsbackend.statistics.testdata;

import pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest.resource.VisitStatisticsResource;

public class VisitStatisticsResourceTestData {

    public static VisitStatisticsResource visitStats230101() {
        return VisitStatisticsResource.builder()
                .date("2023-01-01")
                .count(2L)
                .build();
    }

    public static VisitStatisticsResource visitStats230102() {
        return VisitStatisticsResource.builder()
                .date("2023-01-02")
                .count(1L)
                .build();
    }
}
