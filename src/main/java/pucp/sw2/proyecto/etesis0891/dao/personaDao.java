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

/**
 *
 * @author gtrpucp
 */
public class personaDao {
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
     
      public void create(Persona persona) {
      StringBuilder sql = new StringBuilder();
      
      sql.append("INSERT INTO `etesis0891`.`persona` (`idPersona`, `Nombre`, `Apellidos`, `Codigo`, `Password`, `DNI`, `Correo`, `Telefono`, `Estado`, `idRol`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            try{
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
            
            
            
            
            
            
            }catch (Exception ex) {
            System.out.println(ex.toString());
        }
      }
             
}
