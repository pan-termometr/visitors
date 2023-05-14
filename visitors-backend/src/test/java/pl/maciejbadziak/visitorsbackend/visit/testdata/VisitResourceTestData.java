package pl.maciejbadziak.visitorsbackend.visit.testdata;

import pl.maciejbadziak.visitorsbackend.visit.adapter.in.rest.resource.VisitResource;

public class VisitResourceTestData {

    public static VisitResource visitResource230101() {
        return VisitResource.builder()
                .date("2023-01-01")
                .ip("127.0.0.1")
                .build();
    }

    public static VisitResource visitResourceWithMissingDate() {
        return VisitResource.builder()
                .ip("127.0.0.1")
                .build();
    }

    public static VisitResource visitResourceWithMissingIp() {
        return VisitResource.builder()
                .date("2023-01-01")
                .build();
    }
}
