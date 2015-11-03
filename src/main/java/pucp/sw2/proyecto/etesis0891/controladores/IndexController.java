/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Oscar
 */

@Controller (value = "indexController")

public class IndexController {
    
    @RequestMapping(value = "logueo")
    public String logueo (){
        return "vista_inicio_login";
    }
    

}
