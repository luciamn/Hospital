package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.modelo.Planta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantaRepositorio extends JpaRepository<Planta, Long> {
}
