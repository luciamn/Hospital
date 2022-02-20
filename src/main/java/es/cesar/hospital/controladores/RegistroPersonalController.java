package es.cesar.hospital.controladores;
import es.cesar.hospital.modelos.Personal;
import es.cesar.hospital.servicio.PersonalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;

@Controller
public class RegistroPersonalController {

    @Autowired
    private PersonalServicio personalServicio;

    @GetMapping("/auth/loginPersonal")
    public String login(Model model){
        model.addAttribute("personal", new Personal());
        return "loginPersonal";
    }

    @GetMapping("/auth/registroPersonal")
    public String registroForm(Model model){
        model.addAttribute("personal", new Personal());
        return "registroPersonal";
    }



    @PostMapping("/auth/registroPersonal")
    public String registro(@Validated @ModelAttribute Personal personal , BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/auth/registroPersonal";
        } else {
            model.addAttribute("personal", personalServicio.registar(personal));
        }
        return "redirect:/auth/loginPersonal";
    }

}
