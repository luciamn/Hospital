package es.cesar.hospital.modelos;


import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "cita")
public class Cita {
    
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "descripcion_patalogica", nullable = false)
    private String descripcion_patalogica;

    @OneToOne
    private Personal personal;
    
    @OneToOne
    private TipoCita tipoCita;
    
    @OneToMany
    private List<Paciente> paciente;

}
