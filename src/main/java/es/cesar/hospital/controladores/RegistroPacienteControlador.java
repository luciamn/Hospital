package es.cesar.hospital.controladores;

import es.cesar.hospital.dto.PacienteRegistroDTO;
import es.cesar.hospital.servicio.PacienteServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registroPaciente")
public class RegistroPacienteControlador {

    private PacienteServicio pacienteServicio;

    public RegistroPacienteControlador (PacienteServicio pacienteServicio){
        super();
        this.pacienteServicio = pacienteServicio;
    }

    @ModelAttribute("paciente")
    public PacienteRegistroDTO retornarNuevoPacienteRegistroDTO(){
        return new PacienteRegistroDTO();
    }

    @GetMapping
    public String mostrarFomularioDeRegistro(){
        return "registroPaciente";
    }

    @PostMapping
    public String registrarCuentaDePaciente(@ModelAttribute("paciente") PacienteRegistroDTO registroDTO){
        pacienteServicio.guardarPaciente(registroDTO);
        return "redirect:/registroPaciente?exito";
    }
}
