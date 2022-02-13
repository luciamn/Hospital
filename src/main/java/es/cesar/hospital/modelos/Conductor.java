package es.cesar.hospital.modelos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

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
