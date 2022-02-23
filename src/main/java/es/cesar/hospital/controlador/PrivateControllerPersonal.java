package es.cesar.hospital.controlador;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.modelo.Personal;
import es.cesar.hospital.servicio.PacienteServicio;
import es.cesar.hospital.servicio.PersonalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/private")
public class PrivateControllerPersonal {

    @Autowired
    private PersonalServicio personalServicio;

    @GetMapping("/indexPersonal")
    public String index(Authentication auth, HttpSession session){
        String dni = auth.getName() ;

        if (session.getAttribute("personal") == null){
            Personal personal = personalServicio.findBydni(dni);
            personal.setContrasena(null);
            session.setAttribute("usuario", personal);
        }
        return "indexPersonal";
    }
}
