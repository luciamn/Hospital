package es.cesar.hospital.dao;

import es.cesar.hospital.modelos.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PacienteDAO extends JpaRepository<Paciente, long> {
    public Paciente findByUsername(String username);
}
