package es.cesar.hospital.modelos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "turno")
public class Turno {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal", nullable = false)
    private Personal personal;
    
}
