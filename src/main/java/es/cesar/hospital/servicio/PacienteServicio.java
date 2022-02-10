package es.cesar.hospital.servicio;

import es.cesar.hospital.dto.PacienteRegistroDTO;
import es.cesar.hospital.modelos.Paciente;

public interface PacienteServicio {
    public Paciente guardarPaciente(PacienteRegistroDTO registroDTO);

}
