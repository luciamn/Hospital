package es.cesar.hospital.servicio;

import es.cesar.hospital.dto.PersonalRegistroDTO;
import es.cesar.hospital.modelos.Personal;

public interface PersonalServicio {

    public Personal guardarPersonal(PersonalRegistroDTO registroDTO);
}
