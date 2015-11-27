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
@Repository("avanceDAO")

public class AvanceDAO {

    @Autowired
    private DataSource dataSource;

    public List<AvanceBean> listarAvances(int idMatricula) {

        String query = "SELECT a.idAvance, "
                + "a.idMatricula, "
                + "a.ComentarioAsesor, "
                + "a.ComentarioAlumno, "
                + "a.Semana, "
                + "a.FechaLimite, "
                + "a.Descripcion "
                + "FROM avance a "
                + "where idMatricula = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<AvanceBean> listaAvances = jdbcTemplate.query(query,new Object[]{idMatricula}, new AvanceMapper());
        return listaAvances;
    }

}
