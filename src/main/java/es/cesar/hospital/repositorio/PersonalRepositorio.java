package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelos.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepositorio extends JpaRepository<Personal, Long> {
    public Personal findBydni(String dni);
}