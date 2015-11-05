/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import pucp.sw2.proyecto.etesis0891.DTO.Persona;

/**
 *
 * @author Oscar
 */
public class personaDao {

    public boolean personaRegistrada(String codigo) {

        return true;
    }

    public Persona obtenerPersona(String codigo) {
        Persona p = new Persona();

        return p;
    }

    public void cambiarPassword(String codigo, String password) {

    }

    public List<Persona> listarPersonas() {

    List<Persona> listaPersonas = null;
    
    return listaPersonas;
    
    }

}
