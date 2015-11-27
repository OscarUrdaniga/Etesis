/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.controladores;

import static java.lang.Math.*;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pucp.sw2.proyecto.etesis0891.model.bean.*;
import pucp.sw2.proyecto.etesis0891.model.dao.*;
import pucp.sw2.proyecto.etesis0891.model.dto.*;

/**
 *
 * @author Oscar
 */
@Controller(value = "adminController")
@SessionAttributes("usuarioDTO")
public class AdminController {

    private final int CANTIDAD_PERSONAS_POR_PAGINA = 10;

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private MatriculaDAO matriculaDAO;

    @Autowired
    private PersonaDAO personaDAO;

    private static final Logger log = Logger.getLogger("adminController");

    //LISTAS//
    @RequestMapping(value = "/admin/listaractivos")
    public String listarUsuariosActivos(Model model) {
        List<UsuarioDTO> lstUsuarios;
        lstUsuarios = usuarioDAO.listarUsuariosActivos();
        model.addAttribute("lstUsuariosCompleto", lstUsuarios);
        return "admin/vista_usuarios_completo";
    }

    @RequestMapping(value = "/admin/listarinactivos")
    public String listarUsuariosInactivos(Model model) {
        List<UsuarioDTO> lstUsuarios;
        lstUsuarios = usuarioDAO.listarUsuariosInactivos();
        model.addAttribute("lstUsuariosCompleto", lstUsuarios);
        return "admin/vista_usuarios_completo";
    }

    @RequestMapping(value = "/admin/listarborrados")
    public String listarUsuariosBorrados(Model model) {
        List<UsuarioDTO> lstUsuarios;
        lstUsuarios = usuarioDAO.listarUsuariosBorrados();
        model.addAttribute("lstUsuariosCompleto", lstUsuarios);
        return "admin/vista_usuarios_completo";
    }

    //CRUD ALUMNO - ASESOR
    @RequestMapping(value = "/admin/seleccionado", method = RequestMethod.POST)
    public String definirTipoDeUsuario(@ModelAttribute("RolBean") RolBean rb, Model model) {
        int id = rb.getIdrol();
        UsuarioDTO usuarioNuevo = new UsuarioDTO();
        model.addAttribute("usuarioDTO", usuarioNuevo);
        model.addAttribute("lstAsesores", personaDAO.listarAsesores());
        model.addAttribute("lstRoles", personaDAO.listarRoles());
        model.addAttribute("lstEstados", personaDAO.listarEstados());
        if (id == 1) {
            return "admin/vista_registro_admin";
        } else if (id == 2) {
            return "admin/vista_registro_asesor";
        } else {
            return "admin/vista_registro_alumno";
        }
    }

    @RequestMapping(value = "/admin/agregar")
    public String agregarUsuario(Model model, HttpSession sesion) {
        RolBean rb = new RolBean();
        model.addAttribute("rolBean", rb);
        return "admin/vista_seleccionar";
    }

    @RequestMapping(value = "/admin/update")
    public String updatePersona(HttpSession sesion, @RequestParam Integer id) {
        sesion.setAttribute("id", id);
        return "redirect:/admin/editar";
    }

    @RequestMapping(value = "/admin/editar")
    public String editarPersona(Model model, HttpSession sesion) {
        Integer id = (Integer) sesion.getAttribute("id");
        log.info("Buscando persona: " + id);
        UsuarioDTO pb = usuarioDAO.obtenerUsuarioxID(id);
        sesion.setAttribute("id", id);
        model.addAttribute("usuarioDTO", pb);
        model.addAttribute("lstAsesores", personaDAO.listarAsesores());
        model.addAttribute("lstRoles", personaDAO.listarRoles());
        model.addAttribute("lstEstados", personaDAO.listarEstados());
        return "admin/vista_registro_usuario"; //Desde la vista se envía un "save_persona"
    }

    @RequestMapping(value = {"/admin/save_persona"}, method = RequestMethod.POST)
    public String savePersona(@ModelAttribute("usuarioDTO") @Valid UsuarioDTO usuario, BindingResult result, Model model) {
        PersonaBean persona = pasarDTOaBeanPersona(usuario);
        MatriculaBean matricula = pasarDTOaBeanMatricula(usuario);
        if (result.hasErrors()) {
            model.addAttribute("usuarioDTO", usuario);
            model.addAttribute("lstAsesores", personaDAO.listarAsesores());
            model.addAttribute("lstRoles", personaDAO.listarRoles());
            model.addAttribute("lstEstados", personaDAO.listarEstados());
            return "/admin/vista_registro_usuario";
        } else {
            if (usuario.getIdpersona() == 0) {
                personaDAO.agregarUsuario(persona);
            } else {
                personaDAO.updateUusario(persona);
                matriculaDAO.updateMatriculaPorCambioAsesor(matricula);
            }
            return "redirect:/admin/listaractivos";
        }
    }

    @RequestMapping(value = {"/admin/delete"}, method = RequestMethod.GET)
    public String deletePersona(@RequestParam(value = "id", required = true) Integer id) {
        if (id != null) {
            personaDAO.deleteUsuario(id);
        }
        return "redirect:/admin/listarborrados";
    }

    //MATRICULA//
    @RequestMapping(value = "/admin/matricular")
    public String agregarMatricula(Model model, HttpSession sesion) {

        //model.addAttribute("personaBean",personaBean);
        return "admin/vista_registro_matricula";
    }

    //PAGINACION - ETESIS NORMAL//
    /*@RequestMapping(value = {"/admin/page"}, method = RequestMethod.GET)
     public String paginar(@RequestParam(value = "idpage", required = true) Integer idpage, Model model, HttpSession sesion) {
     Integer cantPag = (Integer) sesion.getAttribute("cantPag");
     if (idpage >= 1 && idpage <= cantPag) {
     List<UsuarioDTO> lstUsuariosCompleto;
     lstUsuariosCompleto = usuarioDAO.listarPorPagina(idpage, CANTIDAD_PERSONAS_POR_PAGINA);
     model.addAttribute("lstUsuariosCompleto", lstUsuariosCompleto);
     sesion.setAttribute("lstUsuariosCompleto", lstUsuariosCompleto);
     sesion.setAttribute("idpage", idpage);
     sesion.setAttribute("cantPag", cantPag);
     return "/admin/vista_usuarios_completo";

     } else {
     List<UsuarioDTO> lstUsuariosCompleto = (List<UsuarioDTO>) sesion.getAttribute("lstUsuariosCompleto");
     model.addAttribute("lstUsuariosCompleto", lstUsuariosCompleto);
     return "/admin/vista_usuarios_completo";
     }
     }*/
    //FUNCIONES AUXILIARES
    private PersonaBean pasarDTOaBeanPersona(UsuarioDTO usuario) {
        PersonaBean pb = new PersonaBean();
        pb.setIdpersona(usuario.getIdpersona());
        pb.setNombre(usuario.getNombre());
        pb.setApellidos(usuario.getApellidos());
        pb.setCodigo(usuario.getCodigo());
        pb.setDNI(usuario.getDni());
        pb.setCorreo(usuario.getCorreo());
        pb.setTelefono(usuario.getTelefono());
        pb.setEstado(usuario.getEstado());
        RolBean rb = new RolBean();
        rb.setIdrol(usuario.getIdRol());
        if (rb.getIdrol() == 1) {
            rb.setNombre("ADMIN");
        } else if (rb.getIdrol() == 2) {
            rb.setNombre("ASESOR");
        } else {
            rb.setNombre("ALUMNO");
        }
        pb.setRol(rb);
        return pb;
    }

    private MatriculaBean pasarDTOaBeanMatricula(UsuarioDTO usuario) {
        MatriculaBean matri = new MatriculaBean();
        matri.setIdmatricula(usuario.getIdMatricula());
        matri.setIdAlumno(usuario.getIdpersona());
        matri.setIdAsesor(usuario.getIdAsesor());
        return matri;
    }

}
