package es.cesar.hospital.modelos;


import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "planta")
public class Planta {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "piso", nullable = false)
    private String Piso;

    @OneToMany
    @Column(name = "zona", nullable = false)
    private List<Zona> zona;
    
}
