package es.cesar.hospital.controladores;


import es.cesar.hospital.dto.PersonalRegistroDTO;
import es.cesar.hospital.servicio.PersonalServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registroPersonal")
public class RegistroPersonalControlador {

    private PersonalServicio personalServicio;

    public RegistroPersonalControlador(PersonalServicio personalServicio) {
        this.personalServicio = personalServicio;
    }

    @ModelAttribute("personal")
    public PersonalRegistroDTO retornarNuevoPersonalRegistroDTO(){
        return new PersonalRegistroDTO();
    }
    @GetMapping
    public String mostrarFormulario(){
        return "registroPersonal";}

    @PostMapping
    public String registrarCuentaPersonal(@ModelAttribute("personal") PersonalRegistroDTO registroDTO){
        personalServicio.guardarPersonal(registroDTO);
        return "redirect:/registro?exito";
    }
}
