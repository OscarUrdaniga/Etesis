package pucp.sw2.proyecto.etesis0891.controladores;


import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
/**
 *
 * @author vea
 */

@Controller
@SessionAttributes("personaDTO")
public class LoginController {

    @Autowired
    private PersonaDAO personaDAO;
    
    @RequestMapping(value = {"/login.do", "/"}, method = RequestMethod.GET)
    public String showLogin(HttpSession session, Model model) {
        PersonaDTO personaDTO = (PersonaDTO) session.getAttribute("personaDTO");
        if (personaDTO != null) {
            if (personaDTO.getRol().equalsIgnoreCase("ADMIN")) {
                return "/administracion/index";
            } else if (personaDTO.getRol().equalsIgnoreCase("ASESOR")) {
         
                return "/asesor/1_index";
            } else {
                if (personaDTO.getEstado() != 0) {
                    model.addAttribute("personaDTO", personaDTO);
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
    
}
