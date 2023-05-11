package pl.maciejbadziak.visitorsbackend.visitarchive.adapter.out.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Visit")
@Getter
@Table(name = "visits")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "visit_date", nullable=false)
    private LocalDate date;

    @Column(name = "ip", nullable=false)
    @Length(max = 15)
    private String ip;
}
