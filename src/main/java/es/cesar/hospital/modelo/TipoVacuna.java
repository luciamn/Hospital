package es.cesar.hospital.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_Vacuna")
public class TipoVacuna {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany
    @JoinColumn(name = "vacuna", nullable = false)
    public List<Vacuna> vacuna;

    public TipoVacuna(String nombre) {
        this.nombre = nombre;
    }
}
