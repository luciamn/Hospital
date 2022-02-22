package es.cesar.hospital.modelo;


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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico", nullable = false)
    private Personal personal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente", nullable = false)
    private Paciente paciente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_cita", nullable = false)
    private TipoCita tipoCita;

}
