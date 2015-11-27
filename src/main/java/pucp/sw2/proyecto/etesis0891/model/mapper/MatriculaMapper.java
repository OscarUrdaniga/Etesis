/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pucp.sw2.proyecto.etesis0891.model.bean.MatriculaBean;
import pucp.sw2.proyecto.etesis0891.model.bean.PersonaBean;

/**
 *
 * @author Marcelo
 */
public class MatriculaMapper  implements RowMapper<MatriculaBean>{
    public MatriculaBean mapRow(ResultSet rs, int i) throws SQLException {
      
        MatriculaBean matricula = new MatriculaBean();
        
        matricula.setIdmatricula(rs.getInt("m.idMatricula"));
        matricula.setCiclo(rs.getString("m.Curso"));
        matricula.setCurso(rs.getString(" m.Ciclo"));
        matricula.setIdAsesor(rs.getInt("m.idAsesor"));
        matricula.setIdAlumno(rs.getInt("m.idAlumno"));
        
        return matricula;
    
    
    }
}
