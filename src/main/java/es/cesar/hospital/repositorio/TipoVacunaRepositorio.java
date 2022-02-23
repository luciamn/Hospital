package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.TipoCita;
import es.cesar.hospital.modelo.TipoVacuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoVacunaRepositorio extends JpaRepository<TipoVacuna, Long> {
}
