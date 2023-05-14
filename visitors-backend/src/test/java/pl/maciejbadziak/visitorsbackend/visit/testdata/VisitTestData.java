package pl.maciejbadziak.visitorsbackend.visit.testdata;

import pl.maciejbadziak.visitorsbackend.visit.domain.Ip;
import pl.maciejbadziak.visitorsbackend.visit.domain.Visit;

import static java.time.LocalDate.of;

public class VisitTestData {

    public static Visit visit230101() {
        return Visit.builder()
                .date(of(2023, 1, 1))
                .ip(Ip.of("127.0.0.1"))
                .build();
    }

    public static Visit visit230101_2() {
        return Visit.builder()
                .date(of(2023, 1, 1))
                .ip(Ip.of("127.0.0.2"))
                .build();
    }

    public static Visit visit230102() {
        return Visit.builder()
                .date(of(2023, 1, 2))
                .ip(Ip.of("127.0.0.1"))
                .build();
    }
}
