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
import pucp.sw2.proyecto.etesis0891.model.bean.*;

/**
 *
 * @author Marcelo
 */
public class DocumentoMapper  implements RowMapper<DocumentoBean>{
    public DocumentoBean mapRow(ResultSet rs, int i) throws SQLException {
      
        DocumentoBean doc = new DocumentoBean();
        
        /*doc.setAvance(rs.getInt("d.id"));
        doc.setEstado(rs.getString("r.Nombre"));*/
        
        return doc;
    
    
    }
}
