/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pucp.sw2.proyecto.etesis0891.DTO.Persona;
import pucp.sw2.proyecto.etesis0891.DTO.Rol;
import pucp.sw2.proyecto.etesis0891.mapper.PersonaMapper;

/**
 *
 * @author gtrpucp
 */
@Repository(value = "personaDao")
public class personaDao {

    @Autowired
    private DataSource dataSource;

    public List<Persona> listaPersonas() {
        List<Persona> listaPersonas = null;
        StringBuilder sql = new StringBuilder();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sql.append("select p.idPersona, p.nombre, p.Apellidos, p.Codigo, p.password, p.DNI, p.correo, p.telefono, p.Estado, p.idRol, r.nombre ");
        sql.append("from persona p, rol r ");
        sql.append("where p.idRol= r.idRol;");

        listaPersonas = jdbcTemplate.query(sql.toString(), new RowMapper<Persona>() {

            @Override
            public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
                Persona persona = new Persona();
                persona.setIdpersona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellidos(rs.getString(3));
                persona.setCodigo(rs.getString(4));
                persona.setPassword(rs.getString(5));
                persona.setHash(rs.getString(6));
                persona.setDNI(rs.getString(7));
                persona.setCorreo(rs.getString(8));
                persona.setTelefono(rs.getString(9));
                persona.setEstado(rs.getString(10));
                Rol rol = new Rol();
                rol.setIdrol(rs.getInt(11));
                rol.setNombre(rs.getString(12));
                persona.setRol(rol);
                
                return persona;
            }
        });
        return listaPersonas;

    }

    public List<Persona> listaPersonasRol(Rol rol) {
        String query = "select p.idPersona,"
                + "p.nombre, "
                + "p.Apellidos, "
                + "p.Codigo,"
                + " p.password,"
                + " p.DNI,"
                + " p.correo,"
                + " p.telefono,"
                + " p.Estado,"
                + "p.idRol,"
                + "r.nombre"
                + "from persona p, rol r "
                + "where p.idRol= r.idRol" + "and r.idRol=?";

        List<Object> parametros = new ArrayList<Object>();
        parametros.add(rol.getIdrol());

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Persona> user_list = jdbcTemplate.query(query, parametros.toArray(), new PersonaMapper());
        return user_list;
    }

    public void create(Persona persona) {
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO `etesis0891`.`persona` (`idPersona`, `Nombre`, `Apellidos`, `Codigo`, `Password`, `DNI`, `Correo`, `Telefono`, `Estado`, `idRol`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            List<Object> parametros = new ArrayList<Object>();

            parametros.add(persona.getIdpersona());
            parametros.add(persona.getNombre());
            parametros.add(persona.getApelidos());
            parametros.add(persona.getCodigo());
            parametros.add(persona.getPassword());
            parametros.add(persona.getDNI());
            parametros.add(persona.getCorreo());
            parametros.add(persona.getTelefono());
            parametros.add(persona.getEstado());
            /* Rol rol=new Rol();
             rol.getIdrol();
             rol.getNombre();
             persona.setRol(rol);*/
            parametros.add(persona.getRol().getIdrol());
            parametros.add(persona.getRol().getNombre());

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
