/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pucp.sw2.proyecto.etesis0891.model.bean.AvanceBean;
import pucp.sw2.proyecto.etesis0891.model.bean.MatriculaBean;
import pucp.sw2.proyecto.etesis0891.model.bean.PersonaBean;

/**
 *
 * @author Marcelo
 */
public class AvanceMapper  implements RowMapper<AvanceBean>{
    public AvanceBean mapRow(ResultSet rs, int i) throws SQLException {
      
        AvanceBean avance = new AvanceBean();
        
        avance.setIdAvance(rs.getInt("a.idAvance"));
        avance.setIdMatricula(rs.getInt("a.idMatricula"));
        avance.setComentarioAsesor(rs.getString("a.ComentarioAsesor"));
        avance.setComentarioAlumno(rs.getString("a.ComentarioAlumno"));
        avance.setSemana(rs.getInt("a.Semana"));
        avance.setFechaLimite(rs.getDate("a.FechaLimite"));
        avance.setDescripcion(rs.getString("a.Descripcion"));
        
        return avance;
    
    
    }
}
