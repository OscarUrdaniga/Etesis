/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.controladores;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pucp.sw2.proyecto.etesis0891.model.bean.*;
import pucp.sw2.proyecto.etesis0891.model.dao.*;
import pucp.sw2.proyecto.etesis0891.model.dto.UsuarioDTO;

/**
 *
 * @author Oscar
 */
@Controller
@SessionAttributes("personaBean")
public class AsesorController {

    @Autowired
    private PersonaDAO personaDAO;

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private MatriculaDAO matriculaDAO;

    @Autowired
    private AvanceDAO avanceDAO;

    @Autowired
    private DocumentoDAO documentoDAO;

    @RequestMapping(value = "/asesor/alumnos", method = RequestMethod.GET)
    public String home(Model model, HttpSession sesion) {
        PersonaBean asesor = (PersonaBean) sesion.getAttribute("personaBean");
        List<UsuarioDTO> listaAlumnos = usuarioDAO.listarAlumnosxAsesor(asesor.getIdpersona());
        model.addAttribute("listaAlumnos", listaAlumnos);
        return "mantenimiento";
    }

    @RequestMapping(value = "/asesor/vertesis", method = RequestMethod.GET)
    public String tesisAlumno(Model model, HttpSession sesion, @RequestParam Integer id) {
        /*Integer idMatricula = matriculaDAO.obtenerIdMatri(id);
         List<AvanceBean> avances = avanceDAO.listarAvances(idMatricula);
         //List<DocumentoBean> avances = documentoDAO.listarDocumentos(idMatricula);

         sesion.setAttribute("idAlumno", id);
         sesion.setAttribute("semana", avances.get(1).getSemana());
         sesion.setAttribute("nombreArchivo", avances.get(1).getSemana());

         return "/asesor/vista_tesis_actual";*/
        return "/asesor/vista_tesis_actual";
    }

}
