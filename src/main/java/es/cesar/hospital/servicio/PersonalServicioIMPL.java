package es.cesar.hospital.servicio;


import es.cesar.hospital.dto.PersonalRegistroDTO;
import es.cesar.hospital.modelos.Personal;
import es.cesar.hospital.repositorio.PersonalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalServicioIMPL  implements PersonalServicio{

    @Autowired
    private PersonalRepositorio personalRepositorio;

    @Override
    public Personal guardarPersonal(PersonalRegistroDTO registroDTO){
        Personal personal = new Personal(
                registroDTO.getNombre(),
                registroDTO.getApellidos(),
                registroDTO.getContrasena(),
                registroDTO.getEmail(),
                registroDTO.getTelefono(),
                registroDTO.getTurno(),
                registroDTO.getTipoPersonal(),
                registroDTO.getCita(),
                registroDTO.getZona_asignada()
        );

        return personalRepositorio.save(personal);

    }
}
