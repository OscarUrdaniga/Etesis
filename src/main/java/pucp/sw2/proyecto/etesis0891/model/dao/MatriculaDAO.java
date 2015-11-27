/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import pucp.sw2.proyecto.etesis0891.model.bean.MatriculaBean;
import pucp.sw2.proyecto.etesis0891.model.bean.PersonaBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pucp.sw2.proyecto.etesis0891.model.dto.UsuarioDTO;
import pucp.sw2.proyecto.etesis0891.model.mapper.MatriculaMapper;
import pucp.sw2.proyecto.etesis0891.model.mapper.PersonaMapper;

/**
 *
 * @author Marcelo
 */
@Repository("matriculaDAO")
public class MatriculaDAO {

    @Autowired
    private DataSource dataSource;

    public List<MatriculaBean> listarMatricula() {

        String query = "select m.idMatricula,m.Curso , m.Ciclo, m.idAsesor, m.idAlumno from matricula m ";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<MatriculaBean> matricula_lista = jdbcTemplate.query(query, new MatriculaMapper());
        return matricula_lista;

    }

    public void agregarMatricula(MatriculaBean matricula) {
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

    public void updateMatriculaCompleto(MatriculaBean matricula) {

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

    public void updateMatriculaPorCambioAsesor(MatriculaBean matricula) {

        StringBuilder sb = new StringBuilder();
        sb.append(" update matricula ");
        sb.append(" set idAsesor = ? ,");
        sb.append(" idAlumno = ? ");
        sb.append(" where idMatricula = ? ");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sb.toString(), new Object[]{matricula.getIdAsesor(), matricula.getIdAlumno(), matricula.getIdmatricula()});

    }

    public void deleteMatricula(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM matricula WHERE idMatricula = ?");
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql.toString(), new Object[]{id});
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public Integer obtenerIdMatri(Integer idAlumno) {
        StringBuilder sql = new StringBuilder();
        List<Object> parametros = new ArrayList<Object>();
        sql.append("select idMatricula FROM matricula m, avance a WHERE idMatricula = a.idMatricula and idAlumno = ?");
        parametros.add(idAlumno);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Integer> idMatri = jdbcTemplate.query(sql.toString(), parametros.toArray(),
                new RowMapper<Integer>() {
                    @Override
                    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Integer id = null;
                        id = rs.getInt(1);
                        return id;
                    }
                });
        return idMatri.get(1);
    }

}
