package es.cesar.hospital.seguridad;

import es.cesar.hospital.dao.PacienteDao;
import es.cesar.hospital.modelos.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceIMPL implements UserDetailsService {

    @Autowired
    private PacienteDao pacienteDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Paciente paciente = pacienteDAO.findByUserName(username);
        User.UserBuilder builder = null;

        if(paciente != null){
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(paciente.getContrasena());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        }else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return builder.build();
    }
}
