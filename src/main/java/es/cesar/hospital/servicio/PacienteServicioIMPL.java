package es.cesar.hospital.servicio;

import es.cesar.hospital.dto.PacienteRegistroDTO;
import es.cesar.hospital.modelos.Paciente;
import es.cesar.hospital.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServicioIMPL implements PacienteServicio{

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Override
    public Paciente guardarPaciente(PacienteRegistroDTO registroDTO){
        return null;
    }
}
