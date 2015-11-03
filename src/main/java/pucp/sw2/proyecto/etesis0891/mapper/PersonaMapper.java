/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.tree.RowMapper;
import pucp.sw2.proyecto.etesis0891.DTO.Persona;
import pucp.sw2.proyecto.etesis0891.DTO.Rol;

/**
 *
 * @author Administrator
 */
public class PersonaMapper implements RowMapper<Persona>{
    
    public Persona mapRow(ResultSet rs, int i) throws SQLException {
        Persona persona = new Persona();
        persona.setIdpersona(rs.getInt("p.idPersona"));
        persona.setNombre(rs.getString("p.nombre"));
        persona.setApelidos(rs.getString("p.Apellidos"));
        persona.setCodigo(rs.getString("p.Codigo"));
        persona.setPassword(rs.getString("p.password"));
        persona.setDNI(rs.getString("p.DNI"));
        persona.setCorreo(rs.getString("p.correo"));
        persona.setTelefono(rs.getString("p.telefono"));
        persona.setEstado(rs.getString("p.Estado"));
        Rol rol = new Rol();
        rol.setIdrol(rs.getInt("p.idRol"));
        rol.setNombre(rs.getString("r.nombre"));
        persona.setRol(rol);
        return persona;
    
    
    }
}
