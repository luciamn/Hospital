package es.cesar.hospital.modelos;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "conductor")
public class Conductor extends Personal{

    @OneToMany
    @Column(name = "ambulancia", nullable = false)
    private List<Ambulancia> ambulancia;

}
