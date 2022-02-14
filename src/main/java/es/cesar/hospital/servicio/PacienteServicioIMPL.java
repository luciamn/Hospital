package es.cesar.hospital.servicio;

import es.cesar.hospital.dto.PacienteRegistroDTO;
import es.cesar.hospital.modelos.Habitacion;
import es.cesar.hospital.modelos.Paciente;
import es.cesar.hospital.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class PacienteServicioIMPL implements PacienteServicio{

    @Autowired  
    private PacienteRepositorio pacienteRepositorio;

    @Override
    public Paciente guardarPaciente(PacienteRegistroDTO registroDTO){
        Paciente paciente = new Paciente(
                registroDTO.getNombre(),
                registroDTO.getApellidos(),
                registroDTO.getContrasena(),
                registroDTO.getEmail(),
                registroDTO.getDni(),
                registroDTO.getTelefono()
        );

        return pacienteRepositorio.save(paciente);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Paciente paciente =  pacienteRepositorio.findByEmail(username);
        if (paciente == null){
            throw new UsernameNotFoundException("Usuario o contrasena erroneo");
        }
        return null;
    }

}
