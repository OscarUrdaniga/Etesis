/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import pucp.sw2.proyecto.etesis0891.model.bean.PersonaBean;
import pucp.sw2.proyecto.etesis0891.model.bean.RolBean;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author Administrator
 */
public class PersonaMapper implements RowMapper<PersonaBean>{
    
    public PersonaBean mapRow(ResultSet rs, int i) throws SQLException {
        PersonaBean persona = new PersonaBean();
        persona.setIdpersona(rs.getInt("p.idPersona"));
        persona.setNombre(rs.getString("p.Nombre"));
        persona.setApellidos(rs.getString("p.Apellidos"));
        persona.setCodigo(rs.getString("p.Codigo"));
        persona.setPassword(rs.getString("p.Password"));
        persona.setDNI(rs.getString("p.DNI"));
        persona.setCorreo(rs.getString("p.Correo"));
        persona.setTelefono(rs.getString("p.Telefono"));
        persona.setEstado(rs.getString("p.Estado"));
        RolBean rol = new RolBean();
        rol.setIdrol(rs.getInt("p.idRol"));
        rol.setNombre(rs.getString("r.nombre"));
        persona.setRol(rol);
        return persona;
    
    
    }
}
