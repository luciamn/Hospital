package es.cesar.hospital.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicControllerPaciente {

    @GetMapping("/indexPaciente")
    public String indexPaciente(){
        return "logoutPaciente";
    }
}
