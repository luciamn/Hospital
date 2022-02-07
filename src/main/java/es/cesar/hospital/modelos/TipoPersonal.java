package es.cesar.hospital.modelos;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tipoPersonal")
public class TipoPersonal {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @OneToMany
    private List<Personal> personal;
}
