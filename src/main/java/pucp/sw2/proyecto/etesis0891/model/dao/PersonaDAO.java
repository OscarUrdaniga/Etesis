/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pucp.sw2.proyecto.etesis0891.model.bean.PersonaBean;
import pucp.sw2.proyecto.etesis0891.model.bean.RolBean;
import pucp.sw2.proyecto.etesis0891.model.mapper.PersonaMapper;
import pucp.sw2.proyecto.etesis0891.model.mapper.RolMapper;

/**
 *
 * @author Oscar
 */
@Repository("personaDAO")
public class PersonaDAO {

    @Autowired
    private DataSource dataSource;

    //EVALUA SI LA PERSONA ESTA REGISTRADA O NO
    public boolean personaRegistrada(String codigo) {
        PersonaBean persona = new PersonaBean();
        StringBuilder sb = new StringBuilder();
        sb.append("select Nombre from persona where codigo = ?;");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        persona = jdbcTemplate.queryForObject(sb.toString(), new Object[]{codigo}, new RowMapper<PersonaBean>() {
            @Override
            public PersonaBean mapRow(ResultSet rs, int rowNum) throws SQLException {
                PersonaBean p = new PersonaBean();
                p.setNombre(rs.getString("Nombre"));
                return p;
            }
        });
        if (persona != null) {
            return true;
        } else {
            return false;
        }
    }

    //OBTIENE UN PERSONABEAN DE ACUERDO A SU CODIGO
    public PersonaBean obtenerPersonaxCodigo(String codigo) {

        String query = "select p.idPersona, "
                + "p.Nombre, "
                + "p.Apellidos, "
                + "p.Codigo, "
                + "p.Password, "
                + "p.DNI, "
                + "p.Correo, "
                + "p.Telefono, "
                + "p.Estado, "
                + "p.idRol, "
                + "r.nombre "
                + "from persona p , rol r "
                + "where p.idRol = r.idRol and p.Codigo = ?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        PersonaBean persona = jdbcTemplate.queryForObject(query, new Object[]{codigo}, new PersonaMapper());
        return persona;
    }
    
    // ver rol de acuerdo al id
    public int obtenerRolxId(int id) {

        String query = " select idrol from persona where idPersona=?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Integer idrol = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                Integer a = rs.getInt(1);
                return a;
            }
        });
        return idrol;
    }

    //OBTIENE UN PERSONABEAN DE ACUERDO A SU ID
    public PersonaBean obtenerPersonaxID(Integer id) {

        String query = "select p.idPersona, "
                + "p.Nombre, "
                + "p.Apellidos, "
                + "p.Codigo, "
                + "p.Password, "
                + "p.DNI, "
                + "p.Correo, "
                + "p.Telefono, "
                + "p.Estado, "
                + "p.idRol, "
                + "r.nombre "
                + "from persona p , rol r "
                + "where p.idRol = r.idRol and p.idPersona = ?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        PersonaBean persona = jdbcTemplate.queryForObject(query, new Object[]{id}, new PersonaMapper());
        return persona;
    }

    //ACTUALIZA LA CONTRASEÑA DE UNA PERSONA DE ACUERDO A SU ID Y CONTRASEÑA
    public void cambiarPassword(int idPersona, String password) {

        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE persona SET Password  = sha2('?',256),"
                + " WHERE idPersona = ?");

        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            List<Object> parametros = new ArrayList<Object>();
            parametros.add(password);
            parametros.add(idPersona);
            jdbcTemplate.update(sql.toString(), parametros.toArray());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    //OBTIENE UNA LISTA DE PERSONABEAN
    public List<PersonaBean> listarPersonas() {

        String query = "select p.idPersona, "
                + "p.Nombre, "
                + "p.Apellidos, "
                + "p.Codigo, "
                + "p.Password, "
                + "p.DNI, "
                + "p.Correo, "
                + "p.Telefono, "
                + "p.Estado, "
                + "p.idRol, "
                + "r.nombre "
                + "from persona p , rol r "
                + "where p.idRol = r.idRol";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<PersonaBean> listaPersonas = jdbcTemplate.query(query, new PersonaMapper());
        return listaPersonas;
    }

    //OBTIENE UNA LISTA DE PERSONABEAN CON ROL ALUMNO
    public List<PersonaBean> listarAlumnos() {

        String query = "select p.idPersona, "
                + "p.Nombre, "
                + "p.Apellidos, "
                + "p.Codigo, "
                + "p.Password, "
                + "p.DNI, "
                + "p.Correo, "
                + "p.Telefono, "
                + "p.Estado, "
                + "p.idRol, "
                + "r.nombre "
                + "from persona p , rol r "
                + "where p.idRol = '3' ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<PersonaBean> listaAlumnos = jdbcTemplate.query(query, new PersonaMapper());
        return listaAlumnos;

    }

    //OBTIENE UNA LISTA DE PERSONABEAN CON ROL ASESOR
    public List<PersonaBean> listarAsesores() {
        String query = "select p.idPersona, "
                + "p.Nombre, "
                + "p.Apellidos, "
                + "p.Codigo, "
                + "p.Password, "
                + "p.DNI, "
                + "p.Correo, "
                + "p.Telefono, "
                + "p.Estado, "
                + "p.idRol, "
                + "r.nombre "
                + "from persona p "
                + "inner join rol r on p.idRol = r.idRol "
                + "where p.idRol = '2' ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<PersonaBean> listaAsesores = jdbcTemplate.query(query, new PersonaMapper());
        return listaAsesores;
    }

    //ACTUALIZA UN PERSONABEAN
    public void updateUusario(PersonaBean persona) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE persona SET Nombre = ?,"
                + " Apellidos = ? ,"
                + " Codigo = ? ,"
                + " DNI = ? ,"
                + " Correo = ? ,"
                + " Telefono = ? "
                + " WHERE idPersona = ?");

        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            List<Object> parametros = new ArrayList<Object>();
            parametros.add(persona.getNombre());
            parametros.add(persona.getApellidos());
            parametros.add(persona.getCodigo());
            parametros.add(persona.getDNI());
            parametros.add(persona.getCorreo());
            parametros.add(persona.getTelefono());
            parametros.add(persona.getIdpersona());
            jdbcTemplate.update(sql.toString(), parametros.toArray());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

    //BLOQUEA A UNA PERSONA (LO HACE EL ADMIN)
    public void bloquear(int id) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE persona SET Estado = 'Inactivo' "
                + " WHERE idPersona = ?");

        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            List<Object> parametros = new ArrayList<Object>();
            parametros.add(id);
            jdbcTemplate.update(sql.toString(), parametros.toArray());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

    //AGREGA UN USUARIO (LO HACE EL ADMIN)
    public void agregarUsuario(PersonaBean persona) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO persona (Nombre, "
                + " Apellidos ,"
                + " Codigo ,"
                + " Password ,"
                + " Hash ,"
                + " DNI ,"
                + " Correo ,"
                + " Telefono ,"
                + " Estado ,"
                + " idRol) VALUES"
                + " (?, ?, ?, SHA2('?',256), concat(persona.idPersona,now(),\"abc\") , ?, ?, ?, ?, ?)");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Object> parametros = new ArrayList<Object>();
        parametros.add(persona.getNombre());
        parametros.add(persona.getApellidos());
        parametros.add(persona.getCodigo());
        parametros.add(persona.getPassword());
        parametros.add(persona.getDNI());
        parametros.add(persona.getCorreo());
        parametros.add(persona.getTelefono());
        parametros.add(persona.getEstado());
        parametros.add(persona.getRol().getIdrol());
        jdbcTemplate.update(sql.toString(), parametros.toArray());
    }

    //ELIMINA UN USUARIO (LO HACE EL ADMIN) PASA A ESTADO BORRADO
    public void deleteUsuario(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE persona SET Estado = 'Borrado' WHERE idPersona = ?");
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql.toString(), new Object[]{id});
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    //OBTIENE UNA LISTA DE ROLBEAN
    public List<RolBean> listarRoles() {
        String query = "select r.idRol, "
                + "r.Nombre "
                + "from rol r ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<RolBean> listaRoles = jdbcTemplate.query(query, new RolMapper());
        return listaRoles;
    }

    //OBTIENE UNA LISTA DE ESTADOS
    public ArrayList<String> listarEstados() {
        ArrayList<String> listaEstados = new ArrayList<>();
        listaEstados.add("Activo");
        listaEstados.add("Inactivo");
        listaEstados.add("Borrado");
        return listaEstados;
    }

    //OBTIENE UNA LISTA DE ROLBEAN
    public int cantidadPersonas() {
        Integer totalPersonas = 0;
        String query = "select count(*) from persona;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        totalPersonas = jdbcTemplate.queryForObject(query, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer cant = null;
                cant = rs.getInt(1);
                return cant;
            }
        });
        return totalPersonas;
    }

    public void cambiarPassword(String codigo, String password) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        StringBuilder sql = new StringBuilder();
        sql.append("update persona set password = SHA2(?,256) where codigo = ? and idPersona = ? ;");
        List<Object> parametros = new ArrayList<Object>();
        parametros.add(password);
        parametros.add(codigo);
        jdbcTemplate.update(sql.toString(), parametros.toArray());
    }

}
