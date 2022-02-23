package es.cesar.hospital.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "conductor")
public class Conductor extends Personal{



    @OneToMany
    @Column(name = "ambulanciaConducida", nullable = true)
    private List<Ambulancia> ambulancia;

    public Conductor(String nombre, String apellidos, String contrasena, String email, String dni, String telefono, TipoPersonal tipoPersonal, List<Zona> zona_asignada, List<Ambulancia> ambulancia) {
        super(nombre, apellidos, contrasena, email, dni, telefono, tipoPersonal, zona_asignada);
        this.ambulancia = null;
    }
}
