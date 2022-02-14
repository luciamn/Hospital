package es.cesar.hospital.servicios;

import es.cesar.hospital.modelos.Paciente;

public interface PacienteServicio {

    public Paciente findByUserName(String username);

    public Paciente registrar(Paciente p);
}
