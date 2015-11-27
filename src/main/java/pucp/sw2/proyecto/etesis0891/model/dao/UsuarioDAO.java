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
import pucp.sw2.proyecto.etesis0891.model.bean.*;
import pucp.sw2.proyecto.etesis0891.model.dto.UsuarioDTO;
import pucp.sw2.proyecto.etesis0891.model.mapper.*;

/**
 *
 * @author Oscar
 */
@Repository("usuarioDAO")
public class UsuarioDAO {

    @Autowired
    private DataSource dataSource;

    //OBTIENE UN USUARIODTO DE ACUERDO A SU ID
    public UsuarioDTO obtenerUsuarioxID(Integer id) {
        String query = "select p.idPersona, p.Nombre, p.Apellidos, p.Codigo, p.DNI, p.Correo, p.Telefono,m.idMatricula as 'idMatricula',ase.idPersona as 'idAsesor', concat(ase.Nombre,' ', ase.Apellidos) as 'Asesor', r.nombre as 'Rol', p.Estado from persona p inner join rol r on r.idRol = p.idRol left join matricula m on m.idAlumno = p.idPersona left join persona ase on ase.idPersona = m.idAsesor where p.idPersona = ? order by p.Apellidos;";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        UsuarioDTO persona = jdbcTemplate.queryForObject(query, new Object[]{id}, new UsuarioMapper());
        return persona;
    }

    //OBTIENE UNA LISTA DE USUARIODTO ACTIVOS
    public List<UsuarioDTO> listarUsuariosActivos() {
        String query = "select p.idPersona,p.Nombre,p.Apellidos,p.Codigo,p.DNI,p.Correo,p.Telefono,m.idMatricula as 'idMatricula', "
                + "concat(ase.Nombre,' ', ase.Apellidos) as 'Asesor',ase.idPersona as 'idAsesor',r.nombre as 'Rol',p.Estado "
                + "from persona p inner join rol r on r.idRol = p.idRol "
                + "left join matricula m on m.idAlumno = p.idPersona "
                + "left join persona ase on ase.idPersona = m.idAsesor "
                + "where p.Estado = 'Activo' "
                + "order by p.Apellidos;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<UsuarioDTO> listaPersonas = jdbcTemplate.query(query, new UsuarioMapper());
        return listaPersonas;
    }

    //OBTIENE UNA LISTA DE USUARIODTO INACTIVOS
    public List<UsuarioDTO> listarUsuariosInactivos() {
        String query = "select p.idPersona,p.Nombre,p.Apellidos,p.Codigo,p.DNI,p.Correo,p.Telefono,m.idMatricula as 'idMatricula', "
                + "concat(ase.Nombre,' ', ase.Apellidos) as 'Asesor',ase.idPersona as 'idAsesor',r.nombre as 'Rol',p.Estado "
                + "from persona p inner join rol r on r.idRol = p.idRol "
                + "left join matricula m on m.idAlumno = p.idPersona "
                + "left join persona ase on ase.idPersona = m.idAsesor "
                + "where p.Estado = 'Inactivo' "
                + "order by p.Apellidos;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<UsuarioDTO> listaPersonas = jdbcTemplate.query(query, new UsuarioMapper());
        return listaPersonas;
    }

    //OBTIENE UNA LISTA DE USUARIODTO BORRADOS
    public List<UsuarioDTO> listarUsuariosBorrados() {
        String query = "select p.idPersona,p.Nombre,p.Apellidos,p.Codigo,p.DNI,p.Correo,p.Telefono,m.idMatricula as 'idMatricula', "
                + "concat(ase.Nombre,' ', ase.Apellidos) as 'Asesor',ase.idPersona as 'idAsesor',r.nombre as 'Rol',p.Estado "
                + "from persona p inner join rol r on r.idRol = p.idRol "
                + "left join matricula m on m.idAlumno = p.idPersona "
                + "left join persona ase on ase.idPersona = m.idAsesor "
                + "where p.Estado = 'Borrado' "
                + "order by p.Apellidos;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<UsuarioDTO> listaPersonas = jdbcTemplate.query(query, new UsuarioMapper());
        return listaPersonas;
    }

    //OBTIENE LA LISTA DE USUARIOS POR PÁGINA
    public List<UsuarioDTO> listarPorPagina(Integer pagina, int cantPersonasxPag) {

        int offset = cantPersonasxPag * (pagina - 1); //cantidad de personas previas al limit
        String query = "select p.idPersona, p.Nombre, p.Apellidos, p.Codigo, p.DNI, p.Correo, p.Telefono,m.idMatricula as 'idMatricula', concat(ase.Nombre,' ', ase.Apellidos) as 'Asesor',ase.idPersona as 'idAsesor', r.nombre as 'Rol', p.Estado from persona p inner join rol r on r.idRol = p.idRol left join matricula m on m.idAlumno = p.idPersona left join persona ase on ase.idPersona = m.idAsesor order by p.Apellidos limit ? ,?;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<UsuarioDTO> listaPersonas;
        listaPersonas = jdbcTemplate.query(query, new Object[]{offset, cantPersonasxPag}, new UsuarioMapper());
        return listaPersonas;
    }

    //OBTIENE UNA LISTA DE ALUMNOS POR ASESOR
    public List<UsuarioDTO> listarAlumnosxAsesor(int idAsesor) {
        String query = "select p.idPersona,p.Nombre,p.Apellidos,p.Codigo,p.DNI,p.Correo,p.Telefono,m.idMatricula as 'idMatricula', "
                + "concat(ase.Nombre,' ', ase.Apellidos) as 'Asesor',ase.idPersona as 'idAsesor',r.nombre as 'Rol',p.Estado "
                + "from persona p "
                + "inner join rol r on r.idRol = p.idRol "
                + "left join matricula m on m.idAlumno = p.idPersona "
                + "left join persona ase on ase.idPersona = m.idAsesor "
                + "where m.idAsesor = ? "
                + "order by p.Apellidos";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<UsuarioDTO> listaAlumnos = jdbcTemplate.query(query, new Object[]{idAsesor}, new UsuarioMapper());
        return listaAlumnos;
    }
}
