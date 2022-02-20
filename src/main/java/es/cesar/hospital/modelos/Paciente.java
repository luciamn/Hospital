package es.cesar.hospital.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "paciente", uniqueConstraints ={
                                                @UniqueConstraint(columnNames = "email"),
                                                @UniqueConstraint(columnNames = "dni"),
                                                @UniqueConstraint(columnNames = "telefono")
})
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany
    @Column(name = "habitacion")
    private List<Habitacion> habitacion;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "cita",
               joinColumns = @JoinColumn(name = "paciente_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "cita_id", referencedColumnName = "id")
    )
    private Cita cita;

    //Constructores

    public Paciente(String nombre, String apellidos, String contrasena, String email, String dni, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
    }

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellidos, String contrasena, String email, String dni, String telefono, List<Habitacion> habitacion, Cita cita) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.habitacion = habitacion;
        this.cita = cita;
    }
}
