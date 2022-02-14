package es.cesar.hospital.impl;

import es.cesar.hospital.dao.PacienteDAO;
import es.cesar.hospital.modelos.Paciente;
import es.cesar.hospital.servicios.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServicioIMPL extends PacienteServicio {

    @Autowired
    private PacienteDAO pacienteDAO;

    @Override
    public Paciente findByUsername(String username){
        return pacienteDAO.findByUsername(username);
    }
}
