/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.model.bean;


import java.util.Date;

/**
 *
 * @author gtrpucp
 */
public class AvanceBean {
    
        private int idAvance;
   
        private String comentarioAsesor;
          
        private String comentarioAlumno;
             
        private int Semana;
              
        private Date fechaLimite;
               
        private String Descripcion;
    
         private int idMatricula;

    public int getIdAvance() {
        return idAvance;
    }

    public void setIdAvance(int idAvance) {
        this.idAvance = idAvance;
    }

    public String getComentarioAsesor() {
        return comentarioAsesor;
    }

    public void setComentarioAsesor(String comentarioAsesor) {
        this.comentarioAsesor = comentarioAsesor;
    }

    public String getComentarioAlumno() {
        return comentarioAlumno;
    }

    public void setComentarioAlumno(String comentarioAlumno) {
        this.comentarioAlumno = comentarioAlumno;
    }

    public int getSemana() {
        return Semana;
    }

    public void setSemana(int Semana) {
        this.Semana = Semana;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }
    
                
}
