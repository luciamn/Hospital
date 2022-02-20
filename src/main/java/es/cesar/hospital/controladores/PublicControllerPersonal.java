package es.cesar.hospital.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicControllerPersonal {

    @GetMapping("/indexPersonal")
    public String index(){
        return "logoutPersonal";
    }
}
