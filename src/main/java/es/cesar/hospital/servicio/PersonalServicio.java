package es.cesar.hospital.servicio;

import es.cesar.hospital.modelos.Personal;
import es.cesar.hospital.repositorio.PersonalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonalServicio {

    @Autowired
    private PersonalRepositorio personalRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Personal findByEmail(String email){
        return personalRepositorio.findByEmail(email);
    }
    public Personal registar(Personal p){
        p.setContrasena(passwordEncoder.encode(p.getContrasena()));
        return personalRepositorio.save(p);
    }
}
