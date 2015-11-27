/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.model.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pucp.sw2.proyecto.etesis0891.model.bean.*;
import pucp.sw2.proyecto.etesis0891.model.mapper.*;

/**
 *
 * @author Oscar
 */
@Repository("documentoDAO")

public class DocumentoDAO {

    @Autowired
    private DataSource dataSource;

    public List<DocumentoBean> listarDocumentos(int idMatricula) {

        String query = "SELECT d.* "
                + "FROM documento d, avance a, matricula m "
                + "where d.idAvance = a.idAvance and a.idMatricula = m.idMatricula;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<DocumentoBean> listaAvances = jdbcTemplate.query(query, new Object[]{idMatricula}, new DocumentoMapper());
        return listaAvances;
    }

}
