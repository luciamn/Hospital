package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.Personal;
import es.cesar.hospital.modelo.TipoCita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCitaRepositorio extends JpaRepository<TipoCita, Long> {
}
