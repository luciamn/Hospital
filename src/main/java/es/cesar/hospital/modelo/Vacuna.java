package es.cesar.hospital.modelo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "vacuna")
public class Vacuna {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_vacuna", nullable = false)
    private TipoVacuna tipo_vacuna;
}
