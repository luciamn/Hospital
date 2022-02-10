package es.cesar.hospital.modelos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tipo_cita")
public class TipoCita {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    
    @JoinColumn(name = "tipo_cita", nullable = false)
    private String tipo_cita;
    
    @ManyToOne
    @JoinColumn(name = "cita", nullable = false)
    private Cita cita;

}
