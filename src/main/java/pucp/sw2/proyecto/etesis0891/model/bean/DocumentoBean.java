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
public class DocumentoBean {

    private int IdDocumento;
    private String url;
    private Date fechaSubida;
    private String estado;

    public int getIdDocumento() {
        return IdDocumento;
    }

    public void setIdDocumento(int IdDocumento) {
        this.IdDocumento = IdDocumento;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public AvanceBean getAvance() {
        return avance;
    }

    public void setAvance(AvanceBean avance) {
        this.avance = avance;
    }

    private AvanceBean avance;

}
