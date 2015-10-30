/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.DTO;


import java.util.Date;

/**
 *
 * @author gtrpucp
 */
public class Avance {
    
        private int idavance;
   
        private String comentarioAsesor;
          
        private String comentarioAlumno;
             
        private int Semana;
              
        private Date fechaLimite;
               
        private String Descripcion;
    
         private Matricula matricula;

    public int getIdavance() {
        return idavance;
    }

    public void setIdavance(int idavance) {
        this.idavance = idavance;
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

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    
                
}
