package es.cesar.hospital.servicio;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PacienteServicio {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Qualifier("passwordEncoderPaciente")
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Paciente findByEmail(String email){
        return pacienteRepositorio.findByEmail(email);
    };

    public Paciente registrar(Paciente p){
        p.setContrasena(passwordEncoder.encode(p.getContrasena()));
        return  pacienteRepositorio.save(p);
    }

}
