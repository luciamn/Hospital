package es.cesar.hospital.modelos;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "personal")
public class Personal {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @OneToOne
    @JoinColumn(name = "turno", nullable = false)
    private Turno turno;

    @OneToOne
    @JoinColumn(name = "tipo_personal", nullable = false)
    private TipoPersonal tipoPersonal;

    @ManyToMany
    @JoinColumn(name = "cita", nullable = false)
    private List<Cita> cita;

    @OneToMany
    @JoinColumn(name = "zona", nullable = false)
    private List<Cita> zona_asignada;
}
