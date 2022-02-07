package es.cesar.hospital.modelos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="habitacion")
public class Habitacion {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name="ocupado", nullable = false)
    private boolean ocupado;

    @OneToOne
    @JoinColumn(name="zona", nullable = false)
    private Zona zona;

    @OneToMany
    @Column(name = "paciente", nullable = false)
    private List<Paciente> paciente;
    
}
