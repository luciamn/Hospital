package es.cesar.hospital.modelo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "personal")
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipo_personal")
    private TipoPersonal tipoPersonal;

    @OneToMany
    @JoinColumn(name = "zona")
    private List<Zona> zona_asignada;

    @OneToMany
    @JoinColumn(name = "cita")
    private List<Cita> citas;

    //Constructores


    public Personal(String nombre, String apellidos, String contrasena, String email, String dni, String telefono, TipoPersonal tipoPersonal, List<Zona> zona_asignada) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.tipoPersonal = tipoPersonal;
        this.zona_asignada = zona_asignada;
    }

    public Personal(String nombre, String apellidos, String contrasena, String email, String telefono, String turno, String tipoPersonal,  Cita cita, Zona zona_asignada) {

    }

    public Personal() {

    }
}
