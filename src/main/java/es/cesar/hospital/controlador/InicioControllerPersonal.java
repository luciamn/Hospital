package es.cesar.hospital.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControllerPersonal {

    @GetMapping("/")
    public String index(){
        return "loginPersonal";
    }
}
