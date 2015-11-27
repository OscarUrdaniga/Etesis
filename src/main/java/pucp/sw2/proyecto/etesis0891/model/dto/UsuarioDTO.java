package pucp.sw2.proyecto.etesis0891.model.dto;

import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import pucp.sw2.proyecto.etesis0891.validator.*;

public class UsuarioDTO implements Serializable{

    private int idpersona;
    
    @NotNull @Size(min=2,max=30,message = "Nombre entre 2 y 30 caracteres.")
    private String nombre;
    
    @NotNull @Size(min=2,max=30, message = "Apellidos entre 2 y 30 caracteres.")
    private String apellidos;
    
    @NotNull @Size(max=8,message = "Maximo 8 digitos.")
    //@NotNull @Codigo
    private String codigo;
    
    @Digits(integer = 8, fraction = 0, message = "Debe ser un numero de 8 digitos.")
    private String dni;
    
    @Email(message = "Debe tener formato email.")
    //@NotNull @Correo
    private String correo;
    
    @Telefono
    private String telefono;
    private Integer idAsesor;
    @NotSelected
    private String asesor;
    @NotSelected
    private String rol;
    @NotSelected
    private String estado;
    private int idMatricula;
    
    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }
    
    

    public Integer getIdAsesor() {
        return idAsesor;
    }

    public void setIdAsesor(Integer idAsesor) {
        this.idAsesor = idAsesor;
    }
    
    
    
    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
}
