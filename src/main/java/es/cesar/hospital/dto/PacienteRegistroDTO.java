package es.cesar.hospital.dto;

import es.cesar.hospital.modelos.Cita;
import es.cesar.hospital.modelos.Habitacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRegistroDTO {

    private Long id;
    private String nombre;
    private String apellidos;
    private String contrasena;
    private String email;
    private String dni;
    private String telefono;
    private Habitacion habitacion;
    private Cita cita;

    //Constructores
    public PacienteRegistroDTO(String nombre, String apellidos, String contrasena, String email, String dni, String telefono) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
    }

    public PacienteRegistroDTO(String email) {
        this.email = email;
    }

}
