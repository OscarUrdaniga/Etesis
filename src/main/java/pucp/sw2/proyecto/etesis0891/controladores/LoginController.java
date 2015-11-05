package pucp.sw2.proyecto.etesis0891.controladores;

import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pucp.sw2.proyecto.etesis0891.DTO.*;
import pucp.sw2.proyecto.etesis0891.dao.*;

/**
 *
 * @author vea
 */

@Controller
@SessionAttributes("personaDTO")
public class LoginController {

    @Autowired
    private personaDao personaDao;

    @RequestMapping(value = "logueo")
    public String logueo() {
        return "vista_inicio_login";
    }

    @RequestMapping(value = {"/login.do", "/"}, method = RequestMethod.GET)
    public String showLogin(HttpSession session, Model model) {
        Persona persona = (Persona) session.getAttribute("personaDTO");
        if (persona != null) {
            if (persona.getRol().getNombre().equalsIgnoreCase("ADMIN")) {
                return "/administracion/index";
            } else if (persona.getRol().getNombre().equalsIgnoreCase("ASESOR")) {

                return "/asesor/1_index";
            } else {
                if (persona.getEstado().equalsIgnoreCase("Activo")) {
                    model.addAttribute("personaDTO", persona);
                    return "/alumno/index_alumno";
                } else {
                    return "/alumno/index_bloqueo";
                }
            }
        } else {
            return "inicial/login";
        }
    }

    @RequestMapping(value = {"/accessdenied.do"}, method = RequestMethod.GET)
    public String denied() {
        return "/denied";
    }

    @RequestMapping("/inicial/inicio")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/inicial/login")
    public String loguear(Model model) {
        return "redirect:/login.do";
    }

    @RequestMapping("/inicial/recuperarpassword")
    public String recuperarContrasena(Model model) {
        Persona p = new Persona();
        String codigo = p.getCodigo();
        model.addAttribute("codigo", codigo);
        return "inicial/recuperarpassword";
    }

    @RequestMapping("/inicial/recuperar")
    public String recuperar(@ModelAttribute("CodigoDTO") @Valid Persona persona, BindingResult result, Model model) {
        Persona p = new Persona();
        String codigo = p.getCodigo();
        if (result.hasErrors()) {
            // No pasó validación. Retornamos al formulario y mostramos los errores
            model.addAttribute("CodigoDTO", codigo);
            return "/inicial/recuperarpassword";
        } else {
            boolean validar = personaDao.personaRegistrada(persona.getCodigo());
            if (validar) {
                Persona persona2 = personaDao.obtenerPersona(persona.getCodigo());
                mailDao mail = new mailDao();
                String contrasenia = UUID.randomUUID().toString();
                System.out.println("password: " + p.getPassword());
                personaDao.cambiarPassword(p.getCodigo(), p.getPassword());
                mail.send(persona.getCorreo(), "Etesis: Nueva Contraseña", "Hola " + persona.getNombre() + ", esta es tu nueva contraseña para acceder a tu cuenta, te recomendamos cambiarla por una que recuerdes con mayor facilidad: " + contrasenia);
                return "redirect:/inicial/login";
            } else {
                model.addAttribute("error", 2);
                model.addAttribute("CodigoDTO", codigo);
                return "/inicial/recuperarpassword";
            }
        }
    }

}
