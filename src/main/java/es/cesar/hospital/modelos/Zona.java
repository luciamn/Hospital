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

    @ManyToOne
    @JoinColumn(name = "planta", nullable = false)
    private Planta planta;

    @OneToMany
    @Column(name = "habitacion", nullable = false)
    private List<Habitacion> habitacion;

    @OneToMany
    @Column(name = "personal", nullable = false)
    private List<Personal> personal;
    
}
