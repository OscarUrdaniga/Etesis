/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.dao;

import java.util.ArrayList;
import java.util.List;
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
    
     public List<Matricula> listaMatricula(){
         
         String query ="select m.idMatricula,m.Curso , m.Ciclo, m.idAsesor, m.idAlumno from matricula m ";
         
         
         JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
          List<Matricula> matricula_lista = jdbcTemplate.query(query, new MatriculaMapper());
        return matricula_lista;
       
     }
     
     public void create(Matricula matricula){
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
    
}
