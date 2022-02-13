package es.cesar.hospital.servicio;

import es.cesar.hospital.dto.PacienteRegistroDTO;
import es.cesar.hospital.modelos.Paciente;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface PacienteServicio extends UserDetailsService {
    public Paciente guardarPaciente(PacienteRegistroDTO registroDTO);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
