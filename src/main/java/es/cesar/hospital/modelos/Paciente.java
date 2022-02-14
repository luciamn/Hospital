package es.cesar.hospital.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class Paciente implements Serializable{
    
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


    private static final Long serialVersionUID = 1L;
}
