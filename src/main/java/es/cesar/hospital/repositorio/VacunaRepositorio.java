package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.modelo.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacunaRepositorio extends JpaRepository<Vacuna, Long> {
}
