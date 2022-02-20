package es.cesar.hospital.controladores;

import es.cesar.hospital.modelos.Personal;
import es.cesar.hospital.repositorio.PersonalRepositorio;
import es.cesar.hospital.servicio.PersonalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/private")
public class PrivateController {

    @Autowired
    private PersonalServicio personalServicio;


    @GetMapping("/indexPersonal")
    public String index(Authentication auth, HttpSession session){
        String dni = auth.getName();

        if (session.getAttribute("personal") == null){
            Personal personal = personalServicio.findBydni(dni);
            personal.setContrasena(null);
            session.setAttribute("personal", personal);
        }
        return "indexPersonal";
    }

}
