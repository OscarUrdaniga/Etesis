/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pucp.sw2.proyectom.dao.ComunDao;
import pucp.sw2.proyectom.dao.PersonasDao;
import pucp.sw2.proyectom.dto.PersonaDTO;
import pucp.sw2.proyectom.ui.PersonaFiltro;


@Controller(value = "personaController")
@RequestMapping(value = "persona")
public class PersonaController {
    
    @Autowired
    PersonasDao personasDao;
    @Autowired
    ComunDao comunDao;
    
    /* se configura un log para este controlador*/
    private static final Logger log = Logger.getLogger("PersonaController");
   
    
       
    @RequestMapping(value = "listar")
    public String listarPersonas(Model model, @RequestParam(required = false) String nombres,
                                               @RequestParam(required = false) Integer idCargo){
        
        PersonaFiltro filtros = new PersonaFiltro();
        List<PersonaDTO> lstPersonas;
        
        filtros.setNombres(nombres);
        filtros.setIdCargo(idCargo);
        filtros.setTodos(1);
        
        lstPersonas = personasDao.busqueda(filtros);
        
        model.addAttribute("filtros", filtros);
        model.addAttribute("lstCargos",comunDao.listarCargos());
        model.addAttribute("lstPersonas", lstPersonas);
        
        return "admin/vista_usuarios";
    }
    
    
    
    
}
