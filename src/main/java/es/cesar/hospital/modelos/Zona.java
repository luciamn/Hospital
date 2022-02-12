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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "planta", nullable = false)
    private List<Planta> planta;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "habitacion", nullable = false)
    private Habitacion habitacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personal", nullable = false)
    private Personal personal;
    
}
