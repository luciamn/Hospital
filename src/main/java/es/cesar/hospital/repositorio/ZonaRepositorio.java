package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.modelo.Zona;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ZonaRepositorio extends JpaRepository<Zona, Long> {
}
