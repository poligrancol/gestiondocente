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
 * @author julianolarte
 */
@Entity
@Table(name = "titulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Titulo.findAll", query = "SELECT t FROM Titulo t"),
    @NamedQuery(name = "Titulo.findByIdTitulo", query = "SELECT t FROM Titulo t WHERE t.idTitulo = :idTitulo"),
    @NamedQuery(name = "Titulo.findByDiploma", query = "SELECT t FROM Titulo t WHERE t.diploma = :diploma")})
public class Titulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_titulo")
    private Long idTitulo;
    @Size(max = 50)
    @Column(name = "diploma")
    private String diploma;
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    @ManyToOne
    private Profesor idProfesor;
    @JoinColumn(name = "id_archivo", referencedColumnName = "id_archivo")
    @ManyToOne
    private ArchivosAdjuntos idArchivo;
    @OneToMany(mappedBy = "idTitulo")
    private Collection<Escolaridad> escolaridadCollection;

    public Titulo() {
    }

    public Titulo(Long idTitulo) {
        this.idTitulo = idTitulo;
    }

    public Long getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(Long idTitulo) {
        this.idTitulo = idTitulo;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public ArchivosAdjuntos getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(ArchivosAdjuntos idArchivo) {
        this.idArchivo = idArchivo;
    }

    @XmlTransient
    public Collection<Escolaridad> getEscolaridadCollection() {
        return escolaridadCollection;
    }

    public void setEscolaridadCollection(Collection<Escolaridad> escolaridadCollection) {
        this.escolaridadCollection = escolaridadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTitulo != null ? idTitulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titulo)) {
            return false;
        }
        Titulo other = (Titulo) object;
        if ((this.idTitulo == null && other.idTitulo != null) || (this.idTitulo != null && !this.idTitulo.equals(other.idTitulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.Titulo[ idTitulo=" + idTitulo + " ]";
    }
    
}
