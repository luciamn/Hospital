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

    @Column(name = "email", nullable = false)
    private String email;

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

    @ManyToMany(fetch =FetchType.EAGER )
    @Column(name = "cita")
    private List<Cita> cita;

    @OneToMany
    @JoinColumn(name = "zona")
    private List<Zona> zona_asignada;

    //Constructores


    public Personal(String nombre, String apellidos, String contrasena, String email, String dni, String telefono, Turno turno, TipoPersonal tipoPersonal, List<Cita> cita, List<Zona> zona_asignada) {
        this.nombre = this.nombre;
        this.apellidos = this.apellidos;
        this.contrasena = this.contrasena;
        this.email = this.email;
        this.dni = this.dni;
        this.telefono = this.telefono;
        this.turno = this.turno;
        this.tipoPersonal = this.tipoPersonal;
        this.cita = this.cita;
        this.zona_asignada = this.zona_asignada;
    }

    public Personal(String nombre, String apellidos, String contrasena, String email, String telefono, Turno turno, TipoPersonal tipoPersonal, Cita cita, Zona zona_asignada) {

    }

    public Personal() {

    }
}
