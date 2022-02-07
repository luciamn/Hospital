package es.cesar.hospital.modelos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ambulancia")
public class Ambulancia {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "matricula", nullable = false)
    private String matricula;

    @Column(name = "clase", nullable = false)
    private String clase;


    @OneToOne
    @JoinColumn(name = "conductor", nullable = false)
    private Conductor conductor;

}
