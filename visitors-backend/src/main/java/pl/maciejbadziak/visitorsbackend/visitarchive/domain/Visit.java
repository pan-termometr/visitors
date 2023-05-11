package pl.maciejbadziak.visitorsbackend.visitarchive.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Visit {

    LocalDate date;
    Ip ip;
}
