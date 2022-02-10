package es.cesar.hospital.modelos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vacuna")
public class TipoVacuna {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne
    private Vacuna vacuna;
}
