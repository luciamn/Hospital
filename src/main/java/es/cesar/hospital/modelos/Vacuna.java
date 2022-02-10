package es.cesar.hospital.modelos;

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

    @OneToMany
    @Column(name = "tipo_vacuna", nullable = false)
    private List<TipoVacuna> tipo_vacuna;
}
