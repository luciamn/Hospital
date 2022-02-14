package es.cesar.hospital.impl;

import es.cesar.hospital.dao.PacienteDao;
import es.cesar.hospital.modelos.Paciente;
import es.cesar.hospital.servicios.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


public class PacienteServicioIMPL implements PacienteServicio {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private PacienteDao pacienteDAO;

    @Override
    public Paciente findByUserName(String username) {
        return  pacienteDAO.findByUserName(username);
    }

    @Override
    public Paciente registrar(Paciente p) {
        p.setContrasena(passwordEncoder.encode(p.getContrasena()));
        return pacienteDAO.save(p);
    }
}
