package es.cesar.hospital.dao;

import es.cesar.hospital.modelos.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteDao extends JpaRepository<Paciente, Long> {
    public Paciente findByUserName(String username);
}
