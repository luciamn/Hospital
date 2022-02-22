package es.cesar.hospital.servicio;

import es.cesar.hospital.repositorio.PersonalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import es.cesar.hospital.modelo.Personal;
import es.cesar.hospital.repositorio.PersonalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonalServicio {

    @Autowired
    private PersonalRepositorio personalRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Personal findBydni(String dni){
     return personalRepositorio.findBydni(dni);
    }
    public Personal registar(Personal p){
        p.setContrasena(passwordEncoder.encode(p.getContrasena()));
        return personalRepositorio.save(p);
    }
}
