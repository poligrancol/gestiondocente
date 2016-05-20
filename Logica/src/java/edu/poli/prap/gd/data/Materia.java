/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poli.prap.gd.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CAMILO
 */
@Entity
@Table(name = "MATERIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByIdMateria", query = "SELECT m FROM Materia m WHERE m.idMateria = :idMateria"),
    @NamedQuery(name = "Materia.findByNombreMateria", query = "SELECT m FROM Materia m WHERE m.nombreMateria = :nombreMateria"),
    @NamedQuery(name = "Materia.findByFacultad", query = "SELECT m FROM Materia m WHERE m.facultad = :facultad"),
    @NamedQuery(name = "Materia.findByArea", query = "SELECT m FROM Materia m WHERE m.area = :area"),
    @NamedQuery(name = "Materia.findByTipoMateria", query = "SELECT m FROM Materia m WHERE m.tipoMateria = :tipoMateria"),
    @NamedQuery(name = "Materia.findByTiempoDictado", query = "SELECT m FROM Materia m WHERE m.tiempoDictado = :tiempoDictado")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MATERIA")
    private Long idMateria;
    @Size(max = 50)
    @Column(name = "NOMBRE_MATERIA")
    private String nombreMateria;
    @Size(max = 50)
    @Column(name = "FACULTAD")
    private String facultad;
    @Size(max = 50)
    @Column(name = "AREA")
    private String area;
    @Size(max = 50)
    @Column(name = "TIPO_MATERIA")
    private String tipoMateria;
    @Column(name = "TIEMPO_DICTADO")
    private Long tiempoDictado;
    @JoinColumn(name = "ID_EXPERIENCIA_DOCENTE", referencedColumnName = "ID_EXPERIENCIA_DOCENTE")
    @ManyToOne
    private ExperienciaDocente idExperienciaDocente;

    public Materia() {
    }

    public Materia(Long idMateria) {
        this.idMateria = idMateria;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTipoMateria() {
        return tipoMateria;
    }

    public void setTipoMateria(String tipoMateria) {
        this.tipoMateria = tipoMateria;
    }

    public Long getTiempoDictado() {
        return tiempoDictado;
    }

    public void setTiempoDictado(Long tiempoDictado) {
        this.tiempoDictado = tiempoDictado;
    }

    public ExperienciaDocente getIdExperienciaDocente() {
        return idExperienciaDocente;
    }

    public void setIdExperienciaDocente(ExperienciaDocente idExperienciaDocente) {
        this.idExperienciaDocente = idExperienciaDocente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.Materia[ idMateria=" + idMateria + " ]";
    }
    
}
