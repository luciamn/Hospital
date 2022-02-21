package es.cesar.hospital.repositorio;


import es.cesar.hospital.modelo.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepositorio extends JpaRepository<Personal, Long> {
    public Personal findBydni(String email);
}
