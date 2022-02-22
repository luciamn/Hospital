package es.cesar.hospital.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tipo_cita")
public class TipoCita {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "tipo_cita", nullable = false)
    private String tipo_cita;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Cita cita;

}
