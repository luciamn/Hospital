package es.cesar.hospital.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tipo_Cita")
public class TipoCita {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "tipo_cita", nullable = false)
    private String tipo_cita;

    @OneToMany
    @JoinColumn(name = "cita", nullable = false)
    private List<Cita> cita;

    public TipoCita(String tipo_cita) {
        this.tipo_cita = tipo_cita;
    }


}
