/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poli.prap.gd.data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CAMILO
 */
@Entity
@Table(name = "EXPERIENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencia.findAll", query = "SELECT e FROM Experiencia e"),
    @NamedQuery(name = "Experiencia.findByIdExperiencia", query = "SELECT e FROM Experiencia e WHERE e.idExperiencia = :idExperiencia"),
    @NamedQuery(name = "Experiencia.findByTotalExperienciaReal", query = "SELECT e FROM Experiencia e WHERE e.totalExperienciaReal = :totalExperienciaReal"),
    @NamedQuery(name = "Experiencia.findByTotalExperienciaDocente", query = "SELECT e FROM Experiencia e WHERE e.totalExperienciaDocente = :totalExperienciaDocente")})
public class Experiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EXPERIENCIA")
    private Long idExperiencia;
    @Column(name = "TOTAL_EXPERIENCIA_REAL")
    private Long totalExperienciaReal;
    @Column(name = "TOTAL_EXPERIENCIA_DOCENTE")
    private Long totalExperienciaDocente;
    //@OneToMany(mappedBy = "idExperiencia")
    //private Collection<ExperienciaDocente> experienciaDocenteCollection;
    @OneToMany(mappedBy = "idExperiencia")
    private Collection<ExperienciaReal> experienciaRealCollection;
    @JoinColumn(name = "ID_PROFESOR", referencedColumnName = "ID_PROFESOR")
    @ManyToOne
    private Profesor idProfesor;

    public Experiencia() {
    }

    public Experiencia(Long idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public Long getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(Long idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public Long getTotalExperienciaReal() {
        return totalExperienciaReal;
    }

    public void setTotalExperienciaReal(Long totalExperienciaReal) {
        this.totalExperienciaReal = totalExperienciaReal;
    }

    public Long getTotalExperienciaDocente() {
        return totalExperienciaDocente;
    }

    public void setTotalExperienciaDocente(Long totalExperienciaDocente) {
        this.totalExperienciaDocente = totalExperienciaDocente;
    }

    //(@XmlTransient
    //public Collection<ExperienciaDocente> getExperienciaDocenteCollection() {
        //return experienciaDocenteCollection;
    //}

    //public void setExperienciaDocenteCollection(Collection<ExperienciaDocente> experienciaDocenteCollection) {
        //this.experienciaDocenteCollection = experienciaDocenteCollection;
    //}

    //@XmlTransient
    //public Collection<ExperienciaReal> getExperienciaRealCollection() {
        //return experienciaRealCollection;
    //}

    //public void setExperienciaRealCollection(Collection<ExperienciaReal> experienciaRealCollection) {
        //this.experienciaRealCollection = experienciaRealCollection;
    //}

    public Long getIdProfesor() {
        return idProfesor.getIdProfesor();
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExperiencia != null ? idExperiencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencia)) {
            return false;
        }
        Experiencia other = (Experiencia) object;
        if ((this.idExperiencia == null && other.idExperiencia != null) || (this.idExperiencia != null && !this.idExperiencia.equals(other.idExperiencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.Experiencia[ idExperiencia=" + idExperiencia + " ]";
    }
    
}
