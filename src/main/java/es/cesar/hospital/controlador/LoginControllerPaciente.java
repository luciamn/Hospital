package es.cesar.hospital.controlador;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.servicio.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginControllerPaciente {

    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping("/auth/registroPaciente")
    public String registroForm(Model model){
        model.addAttribute("paciente", new Paciente());
        return "registroPaciente";
    }

    @PostMapping("/auth/registroPaciente")
    public String registro(@Validated @ModelAttribute Paciente paciente , BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/auth/registroPaciente";
        } else {
            model.addAttribute("paciente", pacienteServicio.registrar(paciente));
        }
        return "redirect:/auth/loginPaciente";
    }

    @GetMapping("/auth/loginPaciente")
    public String login(Model model){
        model.addAttribute("paciente", new Paciente());
        return "loginPaciente";
    }

}
