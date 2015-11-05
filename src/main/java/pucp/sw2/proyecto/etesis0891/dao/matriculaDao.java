/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import pucp.sw2.proyecto.etesis0891.DTO.Matricula;
import pucp.sw2.proyecto.etesis0891.DTO.Persona;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import pucp.sw2.proyecto.etesis0891.mapper.MatriculaMapper;
import pucp.sw2.proyecto.etesis0891.mapper.PersonaMapper;

/**
 *
 * @author Marcelo
 */
public class matriculaDao {

    @Autowired
    private DataSource dataSource;

    public List<Matricula> listaMatricula() {

        String query = "select m.idMatricula,m.Curso , m.Ciclo, m.idAsesor, m.idAlumno from matricula m ";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Matricula> matricula_lista = jdbcTemplate.query(query, new MatriculaMapper());
        return matricula_lista;

    }

    public void create(Matricula matricula) {
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO `etesis0891`.`matricula` (`idMatricula`, `Curso`, `Ciclo`, `idAsesor`, `idAlumno`) VALUES ('?', '?', '?', '?', '?');");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Object> parametros = new ArrayList<Object>();

        parametros.add(matricula.getIdmatricula());
        parametros.add(matricula.getCurso());
        parametros.add(matricula.getCiclo());
        parametros.add(matricula.getIdAsesor());
        parametros.add(matricula.getIdAlumno());

        jdbcTemplate.update(sql.toString(), parametros.toArray());

    }

    public void actualizar_matricula(Matricula matricula) {

        StringBuilder sb = new StringBuilder();
        sb.append(" update matricula ");
        sb.append(" set Curso = ? ,");
        sb.append(" Ciclo = ? ,");
        sb.append(" Asesor = ? ,");
        sb.append(" Alumno = ? ");
        sb.append(" where idMatricula = ? ");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sb.toString(), new Object[]{matricula.getCurso(),
            matricula.getCiclo(), matricula.getIdAsesor(), matricula.getIdAlumno(), matricula.getIdmatricula()});

    }

    public boolean delete(Matricula matricula) {
        boolean result = false;

        if (this.connect()) {
            try {
                String query = "DELETE FROM matricula WHERE idMatricula = ?";
                PreparedStatement pstmt = this.conn.prepareStatement(query);
                pstmt.setInt(1, matricula.getIdmatricula());
                pstmt.execute();
                if (pstmt.getUpdateCount() > 0) {
                    result = true;
                }
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    this.disconnect();
                } catch (SQLException ex) {
                    Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return result;
    }
}
