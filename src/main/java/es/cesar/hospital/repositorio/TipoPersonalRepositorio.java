package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.TipoPersonal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPersonalRepositorio extends JpaRepository<TipoPersonal, Long> {
}
