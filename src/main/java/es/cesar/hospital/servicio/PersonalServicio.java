package es.cesar.hospital.servicio;

import es.cesar.hospital.dto.PersonalRegistroDTO;
import es.cesar.hospital.modelos.Personal;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PersonalServicio extends UserDetailsService {

    public Personal guardarPersonal(PersonalRegistroDTO registroDTO);
}
