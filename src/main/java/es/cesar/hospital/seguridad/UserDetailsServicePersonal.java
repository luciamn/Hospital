package es.cesar.hospital.seguridad;

import es.cesar.hospital.modelo.Personal;
import es.cesar.hospital.servicio.PersonalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServicePersonal implements UserDetailsService {

    @Autowired
    private PersonalServicio personalServicio;

    @Override
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        Personal personal = personalServicio.findBydni(dni);
        User.UserBuilder builder = null;
        if (personal != null){
            builder = User.withUsername(dni);
            builder.disabled(false);
            builder.password(personal.getContrasena());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));

        }else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return builder.build();

    }

}
