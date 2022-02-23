package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.Conductor;
import es.cesar.hospital.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepositorio extends JpaRepository<Conductor, Long> {
}
