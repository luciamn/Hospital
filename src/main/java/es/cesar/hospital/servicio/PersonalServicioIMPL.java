package es.cesar.hospital.servicio;


import es.cesar.hospital.dto.PersonalRegistroDTO;
import es.cesar.hospital.modelos.Personal;
import es.cesar.hospital.modelos.TipoPersonal;
import es.cesar.hospital.repositorio.PersonalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PersonalServicioIMPL  implements PersonalServicio{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    private PersonalRepositorio personalRepositorio;

    @Override
    public Personal guardarPersonal(PersonalRegistroDTO registroDTO){
        Personal personal = new Personal(
                registroDTO.getNombre(),
                registroDTO.getApellidos(),
                passwordEncoder.encode(registroDTO.getContrasena()),
                registroDTO.getEmail(),
                registroDTO.getTelefono(),
                registroDTO.getTurno(),
                registroDTO.getTipoPersonal(),
                registroDTO.getCita(),
                registroDTO.getZona_asignada()
        );

        return personalRepositorio.save(personal);

    }

    @Override
    //revisar este metodo, esta mal.
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personal personal = personalRepositorio.findByEmail(username);
        if (personal == null){
            throw  new UsernameNotFoundException("Usuario o contraseña invalidos");
        }

        return new User(personal.getEmail(), personal.getContrasena(), personal.getTipoPersonal());
    }

    private Collection <? extends GrantedAuthority> maperarAutoridades(Collection<TipoPersonal> tipoPersonal){
        return tipoPersonal.stream().map(role -> new SimpleGrantedAuthority(role.getTipo())).collect(Collectors.toList());
    }
}
