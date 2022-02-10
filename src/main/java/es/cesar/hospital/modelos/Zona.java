package es.cesar.hospital.modelos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "zona")
public class Zona {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "especializacion", nullable = false)
    private String especializacion;

    @OneToMany
    @JoinColumn(name = "planta", nullable = false)
    private List<Planta> planta;

    @ManyToOne
    @Column(name = "habitacion", nullable = false)
    private Habitacion habitacion;

    @ManyToOne
    @Column(name = "personal", nullable = false)
    private Personal personal;
    
}
