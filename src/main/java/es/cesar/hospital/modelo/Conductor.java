package es.cesar.hospital.modelo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "conductor")
public class Conductor extends Personal{

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambulancia", nullable = false)
    private List<Ambulancia> ambulancia;

}
