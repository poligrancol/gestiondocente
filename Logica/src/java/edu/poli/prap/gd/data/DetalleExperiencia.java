/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poli.prap.gd.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CAMILO
 */
@Entity
@Table(name = "DETALLE_EXPERIENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleExperiencia.findAll", query = "SELECT d FROM DetalleExperiencia d"),
    @NamedQuery(name = "DetalleExperiencia.findByIdDetalle", query = "SELECT d FROM DetalleExperiencia d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetalleExperiencia.findByCargo", query = "SELECT d FROM DetalleExperiencia d WHERE d.cargo = :cargo"),
    @NamedQuery(name = "DetalleExperiencia.findByDuracion", query = "SELECT d FROM DetalleExperiencia d WHERE d.duracion = :duracion"),
    @NamedQuery(name = "DetalleExperiencia.findByEmpresa", query = "SELECT d FROM DetalleExperiencia d WHERE d.empresa = :empresa"),
    @NamedQuery(name = "DetalleExperiencia.findByFechaInicio", query = "SELECT d FROM DetalleExperiencia d WHERE d.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "DetalleExperiencia.findByFechaFinal", query = "SELECT d FROM DetalleExperiencia d WHERE d.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "DetalleExperiencia.findByJefe", query = "SELECT d FROM DetalleExperiencia d WHERE d.jefe = :jefe")})
public class DetalleExperiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE")
    private Long idDetalle;
    @Size(max = 50)
    @Column(name = "CARGO")
    private String cargo;
    @Column(name = "DURACION")
    private Long duracion;
    @Size(max = 50)
    @Column(name = "EMPRESA")
    private String empresa;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Size(max = 50)
    @Column(name = "JEFE")
    private String jefe;
    @JoinColumn(name = "ID_PROFESOR", referencedColumnName = "ID_PROFESOR")
    @ManyToOne
    private Profesor idProfesor;

    public DetalleExperiencia() {
    }

    public DetalleExperiencia(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getDuracion() {
        return duracion;
    }

    public void setDuracion(Long duracion) {
        this.duracion = duracion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleExperiencia)) {
            return false;
        }
        DetalleExperiencia other = (DetalleExperiencia) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.DetalleExperiencia[ idDetalle=" + idDetalle + " ]";
    }
    
}
