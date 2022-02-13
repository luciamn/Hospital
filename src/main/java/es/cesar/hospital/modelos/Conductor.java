package es.cesar.hospital.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "conductor")
public class Conductor extends Paciente{

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambulancia", nullable = false)
    private List<Ambulancia> ambulancia;

}
