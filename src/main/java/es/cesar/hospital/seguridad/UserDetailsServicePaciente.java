package es.cesar.hospital.seguridad;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.servicio.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServicePaciente implements UserDetailsService {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Paciente paciente = pacienteServicio.findByEmail(email);
        User.UserBuilder builder = null;

        if(paciente != null){
            builder = User.withUsername(email);
            builder.disabled(false);
            builder.password(paciente.getContrasena());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        }else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return builder.build();
    }
}
