package es.cesar.hospital.modelos;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "personal", uniqueConstraints ={
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "dni"),
        @UniqueConstraint(columnNames = "telefono")
})
public class Personal {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "turno",
            joinColumns = @JoinColumn(name = "personal_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Turno_id", referencedColumnName = "id")
    )
    private Turno turno;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipo_personal", unique = true, nullable = true)
    private TipoPersonal tipoPersonal;

    @ManyToMany(fetch =FetchType.EAGER)
    @Column(name = "cita")
    private List<Cita> cita;

    @OneToMany
    @JoinColumn(name = "zona")
    private List<Zona> zona_asignada;

    //Constructores


    public Personal(String nombre, String apellidos, String contrasena, String email, String dni, String telefono, String turno, String tipoPersonal,  List<Cita> cita, List<Zona> zona_asignada) {
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

    public Personal(String nombre, String apellidos, String contrasena, String email, String telefono, String turno, String tipoPersonal,  Cita cita, Zona zona_asignada) {

    }

    public Personal() {

    }
}
