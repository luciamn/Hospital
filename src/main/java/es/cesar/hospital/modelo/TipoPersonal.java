package es.cesar.hospital.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_Personal")
public class TipoPersonal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    public TipoPersonal(String tipo) {
        this.tipo = tipo;
    }
}
