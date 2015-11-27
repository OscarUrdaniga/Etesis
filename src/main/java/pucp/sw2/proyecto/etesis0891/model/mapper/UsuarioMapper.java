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
import pucp.sw2.proyecto.etesis0891.model.dto.UsuarioDTO;


/**
 *
 * @author Administrator
 */
public class UsuarioMapper implements RowMapper<UsuarioDTO>{
    
    public UsuarioDTO mapRow(ResultSet rs, int i) throws SQLException {
        UsuarioDTO persona = new UsuarioDTO();
        persona.setIdpersona(rs.getInt("idPersona"));
        persona.setNombre(rs.getString("Nombre"));
        persona.setApellidos(rs.getString("Apellidos"));
        persona.setCodigo(rs.getString("Codigo"));
        persona.setDni(rs.getString("DNI"));
        persona.setCorreo(rs.getString("Correo"));
        persona.setIdMatricula(rs.getInt("idMatricula"));
        persona.setAsesor(rs.getString("Asesor"));
        persona.setIdAsesor(rs.getInt("idAsesor"));
        persona.setTelefono(rs.getString("Telefono"));
        persona.setRol(rs.getString("Rol"));
        persona.setEstado(rs.getString("Estado"));
        return persona;   
    
    }
}
