package pucp.sw2.proyecto.etesis0891.controladores;

import static java.lang.Math.round;
import java.util.List;
import pucp.sw2.proyecto.etesis0891.model.dao.*;
import pucp.sw2.proyecto.etesis0891.model.bean.*;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pucp.sw2.proyecto.etesis0891.model.dto.UsuarioDTO;

@Controller
@SessionAttributes("personaBean")
public class LoginController {

    private final int CANTIDAD_PERSONAS_POR_PAGINA = 10;

    @Autowired
    private PersonaDAO personaDAO;

    @Autowired
    private UsuarioDAO usuarioDAO;

    @RequestMapping(value = {"/login.do", "/"}, method = RequestMethod.GET)
    public String showLogin(HttpSession session) {
        PersonaBean personaBean = (PersonaBean) session.getAttribute("personaBean");
        if (personaBean != null) {
            if (personaBean.getRol().getNombre().equalsIgnoreCase("ADMIN")) {
                return "/admin/vista_usuarios";
            } else if (personaBean.getRol().getNombre().equalsIgnoreCase("ASESOR")) {
                return "/asesor/vista_alumnos";
            } else {
                return "/alumno/vista_inicio";
            }
        } else {
            return "login";
        }

    }

    @RequestMapping(value = {"/home.do"}, method = RequestMethod.GET)
    public String home(Model model, HttpSession sesion) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String codigo = auth.getName();
        PersonaBean persona = personaDAO.obtenerPersonaxCodigo(codigo);
        model.addAttribute("personaBean", persona);
        if (persona.getRol().getNombre().equalsIgnoreCase("ADMIN")) {
            /*Integer cantidadPersonas = personaDAO.cantidadPersonas();
             Integer cantidadPaginas = (int) round(cantidadPersonas / CANTIDAD_PERSONAS_POR_PAGINA + 0.49);
             int pagInicial = 1;
             List<UsuarioDTO> lstUsuariosCompleto = usuarioDAO.listarPorPagina(pagInicial, CANTIDAD_PERSONAS_POR_PAGINA);*/
            List<UsuarioDTO> lstUsuariosCompleto = usuarioDAO.listarUsuariosActivos();
            model.addAttribute("lstUsuariosCompleto", lstUsuariosCompleto);
            /*sesion.setAttribute("idpage", pagInicial);
             sesion.setAttribute("cantPag", cantidadPaginas);*/
            return "admin/vista_usuarios_completo";
        } else if (persona.getRol().getNombre().equalsIgnoreCase("ASESOR")) {
            List<UsuarioDTO> listPersonas = usuarioDAO.listarAlumnosxAsesor(persona.getIdpersona());
            model.addAttribute("listaUsuariosCompleto", listPersonas);
            return "/asesor/vista_alumnos";
        } else {
            return "/alumno/vista_inicio";
        }
    }

    @RequestMapping(value = {"/accessdenied.do"}, method = RequestMethod.GET)
    public String denied() {
        return "/denied";
    }


    @RequestMapping("recuperarpassword")
    public String recuperarContrasena(Model model) {
        PersonaBean p = new PersonaBean();
        String codigo = p.getCodigo();
        model.addAttribute("Codigo", codigo);
        return "recuperarpassword";
    }

    @RequestMapping("recuperar")
    public String cambiarPassword(@ModelAttribute("CodigoDTO") @Valid PersonaBean persona, BindingResult result, Model model) {
        PersonaBean p = new PersonaBean();
        String codigo = p.getCodigo();
        if (result.hasErrors()) {
            // No pasó validación. Retornamos al formulario y mostramos los errores
            model.addAttribute("Codigo", codigo);
            return "recuperarpassword";
        } else {
            boolean validar = personaDAO.personaRegistrada(persona.getCodigo());
            if (validar) {
                PersonaBean personaHallada = personaDAO.obtenerPersonaxCodigo(persona.getCodigo());
                MailDAO mail = new MailDAO();
                String contrasenia = UUID.randomUUID().toString();
                System.out.println("password: " + contrasenia);
                personaDAO.cambiarPassword(p.getIdpersona(), p.getPassword());
                mail.send(persona.getCorreo(), "Etesis: Nueva Contraseña", "Hola " + persona.getNombre() + ", esta es tu nueva contraseña para acceder a tu cuenta, te recomendamos cambiarla por una que recuerdes con mayor facilidad: " + contrasenia);
                return "redirect:/inicial/login";
            } else {
                model.addAttribute("error", 2);
                model.addAttribute("Codigo", codigo);
                return "/inicial/recuperarpassword";

            }
        }
    }
}
