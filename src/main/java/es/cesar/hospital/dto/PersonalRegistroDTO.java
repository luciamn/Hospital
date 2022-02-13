package es.cesar.hospital.dto;

import es.cesar.hospital.modelos.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalRegistroDTO {

    private Long id;
    private String nombre;
    private String apellidos;
    private String contrasena;
    private String email;
    private String dni;
    private String telefono;
    private Habitacion habitacion;
    private Turno turno;
    private TipoPersonal tipoPersonal;
    private Zona zona_asignada;
    private Cita cita;


    //Constructor


    public PersonalRegistroDTO(String nombre, String apellidos, String contrasena, String email, String dni, String telefono, Habitacion habitacion, Turno turno, TipoPersonal tipoPersonal, Zona zona_asignada, Cita cita) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.habitacion = habitacion;
        this.turno = turno;
        this.tipoPersonal = tipoPersonal;
        this.zona_asignada = zona_asignada;
        this.cita = cita;
    }

    //solo email


    public PersonalRegistroDTO(String email) {
        super();
        this.email = email;
    }
}
