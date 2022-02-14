package es.cesar.hospital.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioPersonalController {

    @GetMapping("/")
    public String inicio(){
        return "inicioPersonal";
    }
}
