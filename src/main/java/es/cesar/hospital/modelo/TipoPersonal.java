package es.cesar.hospital.modelo;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tipoPersonal")
public class TipoPersonal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @ManyToOne(fetch = FetchType.EAGER)
    private Personal personal;
}
