package es.cesar.hospital.modelos;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "paciente")
public class Paciente {
    
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

    @Column(name = "identificador", nullable = false)
    private Long identificador;

    @OneToOne
    @JoinColumn(name = "habitacion", nullable = false)
    private Habitacion habitacion;
    
    @OneToMany
    @Column(name = "cita", nullable = false)
    private List<Cita> cita;
    
}
