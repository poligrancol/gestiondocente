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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CAMILO
 */
@Entity
@Table(name = "EXPERIENCIA_DOCENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExperienciaDocente.findAll", query = "SELECT e FROM ExperienciaDocente e"),
    @NamedQuery(name = "ExperienciaDocente.findByIdExperienciaDocente", query = "SELECT e FROM ExperienciaDocente e WHERE e.idExperienciaDocente = :idExperienciaDocente"),
    @NamedQuery(name = "ExperienciaDocente.findByUniversidad", query = "SELECT e FROM ExperienciaDocente e WHERE e.universidad = :universidad"),
    @NamedQuery(name = "ExperienciaDocente.findByTipoDocente", query = "SELECT e FROM ExperienciaDocente e WHERE e.tipoDocente = :tipoDocente"),
    @NamedQuery(name = "ExperienciaDocente.findByCiudad", query = "SELECT e FROM ExperienciaDocente e WHERE e.ciudad = :ciudad")})
public class ExperienciaDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EXPERIENCIA_DOCENTE")
    private Long idExperienciaDocente;
    @Size(max = 50)
    @Column(name = "UNIVERSIDAD")
    private String universidad;
    @Size(max = 50)
    @Column(name = "TIPO_DOCENTE")
    private String tipoDocente;
    @Size(max = 50)
    @Column(name = "CIUDAD")
    private String ciudad;
    @JoinColumn(name = "ID_EXPERIENCIA", referencedColumnName = "ID_EXPERIENCIA")
    @ManyToOne
    private Experiencia idExperiencia;
    @OneToMany(mappedBy = "idExperienciaDocente")
    private Collection<Materia> materiaCollection;

    public ExperienciaDocente() {
    }

    public ExperienciaDocente(Long idExperienciaDocente) {
        this.idExperienciaDocente = idExperienciaDocente;
    }

    public Long getIdExperienciaDocente() {
        return idExperienciaDocente;
    }

    public void setIdExperienciaDocente(Long idExperienciaDocente) {
        this.idExperienciaDocente = idExperienciaDocente;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getTipoDocente() {
        return tipoDocente;
    }

    public void setTipoDocente(String tipoDocente) {
        this.tipoDocente = tipoDocente;
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

    @XmlTransient
    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExperienciaDocente != null ? idExperienciaDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienciaDocente)) {
            return false;
        }
        ExperienciaDocente other = (ExperienciaDocente) object;
        if ((this.idExperienciaDocente == null && other.idExperienciaDocente != null) || (this.idExperienciaDocente != null && !this.idExperienciaDocente.equals(other.idExperienciaDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.ExperienciaDocente[ idExperienciaDocente=" + idExperienciaDocente + " ]";
    }
    
}
