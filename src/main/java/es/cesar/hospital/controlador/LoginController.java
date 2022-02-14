package es.cesar.hospital.controlador;

import es.cesar.hospital.modelos.Paciente;
import es.cesar.hospital.servicios.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private PacienteServicio pacienteServicio;

    @GetMapping("/auth/registro")
    public String registroForm(Model model){
        model.addAttribute("usuario", new Paciente());
        return "registro";
    }

    @PostMapping("/auth/registro")
    public String registro(@Validated @ModelAttribute Paciente paciente , BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/auth/registro";
        } else {
            model.addAttribute("paciente", pacienteServicio.registrar(paciente));
        }
        return "redirect:/auth/login";
    }
}
