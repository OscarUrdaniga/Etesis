/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import pucp.sw2.proyecto.etesis0891.DTO.Persona;
import pucp.sw2.proyecto.etesis0891.DTO.Rol;
import pucp.sw2.proyecto.etesis0891.mapper.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author gtrpucp
 */
public class PersonaDao  {
    @Autowired
    private DataSource dataSource;
    
    public List<Persona> listaPersonas(){
    
        String query = "select p.idPersona,"+
                "p.nombre, "+
                "p.Apellidos, "+
                "p.Codigo,"+
                " p.password,"+ 
                " p.DNI,"+
                " p.correo,"+
                " p.telefono,"+
                " p.Estado,"+
                "p.idRol,"+ 
                "r.nombre"+ 
                "from persona p, rol r "
                +"where p.idRol= r.idRol;";
        
        
         JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
          List<Persona> user_list = jdbcTemplate.query(query, new PersonaMapper());
        return user_list;
       
    } 
    
    
    
    
    
    
    
     public List<Persona> listaPersonasRol(Rol rol){
     String query ="select p.idPersona,"+
                "p.nombre, "+
                "p.Apellidos, "+
                "p.Codigo,"+
                " p.password,"+ 
                " p.DNI,"+
                " p.correo,"+
                " p.telefono,"+
                " p.Estado,"+
                "p.idRol,"+ 
                "r.nombre"+ 
                "from persona p, rol r "
                +"where p.idRol= r.idRol"+"and r.idRol=?";
     
     List<Object> parametros = new ArrayList<Object>();
        parametros.add(rol.getIdrol());
     
      JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
          List<Persona> user_list = jdbcTemplate.query(query,parametros.toArray(), new PersonaMapper());
        return user_list;
     }
     
     
     
     public List<Persona> busquedaperso(Rol rol,String dato ){
         tringBuilder sql = new StringBuilder();
      
      sql.append("select * from (select p.idPersona, p.nombre, p.Apellidos, p.Codigo, p.Password, p.DNI, p.correo,p.telefono,p.Estado,p.idRol,r.nombre as nombreRol from persona p, rol r where p.idRol= r.idRol and r.idRol=? ) tg where nombre LIKE '%?%' or Apellidos LIKE '%?%' or Correo LIKE '%?%' OR Estado= '%?%';" );
          
     List<Object> parametros = new ArrayList<Object>();
        parametros.add(rol.getIdrol());
        parametros.add(dato);
        parametros.add(dato);
        parametros.add(dato);
        parametros.add(dato);
     
      JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
          List<Persona> user_list = jdbcTemplate.query(sql,parametros.toArray(), new PersonaMapper());
        return user_list;
     }
     
      public List<Persona> busquedaperso(Rol rol,int dato ){
         tringBuilder sql = new StringBuilder();
      
      sql.append("select * from (select p.idPersona, p.nombre, p.Apellidos, p.Codigo, p.Password, p.DNI, p.correo,p.telefono,p.Estado,p.idRol,r.nombre as nombreRol from persona p, rol r where p.idRol= r.idRol and r.idRol=? ) tg where DNI LIKE '%?%' or telefono LIKE '%?%' or codigo LIKE '%?%';");
      
   
     List<Object> parametros = new ArrayList<Object>();
        parametros.add(rol.getIdrol());
        parametros.add(dato);
        parametros.add(dato);
        parametros.add(dato);
     
      JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
          List<Persona> user_list = jdbcTemplate.query(sql,parametros.toArray(), new PersonaMapper());
        return user_list;
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
      public void create(Persona persona) {
      StringBuilder sql = new StringBuilder();
      
      sql.append("INSERT INTO `etesis0891`.`persona` (`idPersona`, `Nombre`, `Apellidos`, `Codigo`, `Password`, `DNI`, `Correo`, `Telefono`, `Estado`, `idRol`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
         
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
            jdbcTemplate.update(sql.toString(), parametros.toArray());
            
            
            
            
            
            
      }
             
}