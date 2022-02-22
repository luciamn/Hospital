package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.Ambulancia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbulaciaRepositorio extends JpaRepository<Ambulancia, Long> {
}
