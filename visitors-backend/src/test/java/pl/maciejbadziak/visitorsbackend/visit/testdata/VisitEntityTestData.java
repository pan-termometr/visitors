package pl.maciejbadziak.visitorsbackend.visit.testdata;

import pl.maciejbadziak.visitorsbackend.visit.adapter.out.jpa.VisitEntity;

import static java.time.LocalDate.of;

public class VisitEntityTestData {

    public static VisitEntity visitEntity230101() {
        return VisitEntity.builder()
                .id(1L)
                .date(of(2023, 1, 1))
                .ip("127.0.0.1")
                .build();
    }

    public static VisitEntity visitEntity230102() {
        return VisitEntity.builder()
                .id(2L)
                .date(of(2023, 1, 2))
                .ip("127.0.0.1")
                .build();
    }

    public static VisitEntity visitEntity230102_2() {
        return VisitEntity.builder()
                .id(3L)
                .date(of(2023, 1, 2))
                .ip("127.0.0.3")
                .build();
    }

    public static VisitEntity visitEntity230103() {
        return VisitEntity.builder()
                .id(4L)
                .date(of(2023, 1, 3))
                .ip("127.0.0.3")
                .build();
    }
}
