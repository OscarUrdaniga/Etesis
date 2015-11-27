/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pucp.sw2.proyecto.etesis0891.model.bean.*;
import pucp.sw2.proyecto.etesis0891.model.dao.*;

/**
 *
 * @author Oscar
 */
@Controller

public class AlumnoController {

    @Autowired
    private PersonaDAO personaDAO;

    @Autowired
    private AvanceDAO avanceDAO;

}
