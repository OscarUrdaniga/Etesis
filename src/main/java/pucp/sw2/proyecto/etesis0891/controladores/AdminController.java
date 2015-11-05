/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.controladores;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pucp.sw2.proyecto.etesis0891.DTO.Persona;
import pucp.sw2.proyecto.etesis0891.dao.personaDao;


/**
 *
 * @author Oscar
 */

@Controller (value = "adminController")

public class AdminController {
    
    @RequestMapping(value = "listar")
    public String listarPersonas(Model model){
        
     
        List<Persona> lstPersonas;
        
        lstPersonas = personaDao.listaPersonas();
       
        model.addAttribute("lstPersonas", lstPersonas);
        
        return "admin/vista_usuarios";
    }

}
