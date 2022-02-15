package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelos.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepositorio extends JpaRepository<Paciente, Long> {
    public Paciente findByEmail(String email);
}
