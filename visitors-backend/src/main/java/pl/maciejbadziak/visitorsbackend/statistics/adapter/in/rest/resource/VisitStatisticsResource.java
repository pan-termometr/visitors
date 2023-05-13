package pl.maciejbadziak.visitorsbackend.statistics.adapter.in.rest.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@JsonInclude(NON_EMPTY)
public class VisitStatisticsResource {

    @NotNull
    private final LocalDate date;

    @NotNull
    private final Long numberOfVisits;
}