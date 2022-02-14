package es.cesar.hospital.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroController {

    @GetMapping("/login")
    public String iniciarSesion(){
        return "loginPersonal";
    }

    @GetMapping("/")
    public String paginaInicio(){
        return "index";
    }


}
