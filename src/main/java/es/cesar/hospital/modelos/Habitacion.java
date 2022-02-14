package es.cesar.hospital.modelos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="habitacion")
public class Habitacion {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name="ocupado", nullable = false)
    private boolean ocupado;

    @OneToMany
    @JoinColumn(name="zona", nullable = false)
    private List<Zona> zona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente")
    private Paciente paciente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
