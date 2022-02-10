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

    @OneToMany
    @Column(name = "medico", nullable = false)
    private List<Personal> personal;
    
    @OneToMany
    @Column(name = "tipo_cita", nullable = false)
    private List<TipoCita> tipoCita;
    
    @OneToMany
    @Column(name = "paciente", nullable = false)
    private List<Paciente> paciente;

}
