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
@Table(name = "EXPERIENCIA_REAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExperienciaReal.findAll", query = "SELECT e FROM ExperienciaReal e"),
    @NamedQuery(name = "ExperienciaReal.findByIdExperienciaReal", query = "SELECT e FROM ExperienciaReal e WHERE e.idExperienciaReal = :idExperienciaReal"),
    @NamedQuery(name = "ExperienciaReal.findByNombreEmpresa", query = "SELECT e FROM ExperienciaReal e WHERE e.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "ExperienciaReal.findByCargo", query = "SELECT e FROM ExperienciaReal e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "ExperienciaReal.findByArea", query = "SELECT e FROM ExperienciaReal e WHERE e.area = :area"),
    @NamedQuery(name = "ExperienciaReal.findByFechaInicio", query = "SELECT e FROM ExperienciaReal e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "ExperienciaReal.findByFechaFin", query = "SELECT e FROM ExperienciaReal e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "ExperienciaReal.findByCiudad", query = "SELECT e FROM ExperienciaReal e WHERE e.ciudad = :ciudad")})
public class ExperienciaReal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EXPERIENCIA_REAL")
    private Long idExperienciaReal;
    @Size(max = 50)
    @Column(name = "NOMBRE_EMPRESA")
    private String nombreEmpresa;
    @Size(max = 50)
    @Column(name = "CARGO")
    private String cargo;
    @Size(max = 50)
    @Column(name = "AREA")
    private String area;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 50)
    @Column(name = "CIUDAD")
    private String ciudad;
    @JoinColumn(name = "ID_EXPERIENCIA", referencedColumnName = "ID_EXPERIENCIA")
    @ManyToOne
    private Experiencia idExperiencia;

    public ExperienciaReal() {
    }

    public ExperienciaReal(Long idExperienciaReal) {
        this.idExperienciaReal = idExperienciaReal;
    }

    public Long getIdExperienciaReal() {
        return idExperienciaReal;
    }

    public void setIdExperienciaReal(Long idExperienciaReal) {
        this.idExperienciaReal = idExperienciaReal;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Experiencia getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(Experiencia idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExperienciaReal != null ? idExperienciaReal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienciaReal)) {
            return false;
        }
        ExperienciaReal other = (ExperienciaReal) object;
        if ((this.idExperienciaReal == null && other.idExperienciaReal != null) || (this.idExperienciaReal != null && !this.idExperienciaReal.equals(other.idExperienciaReal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.ExperienciaReal[ idExperienciaReal=" + idExperienciaReal + " ]";
    }
    
}
