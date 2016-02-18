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
@Table(name = "archivos_adjuntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchivosAdjuntos.findAll", query = "SELECT a FROM ArchivosAdjuntos a"),
    @NamedQuery(name = "ArchivosAdjuntos.findByIdArchivo", query = "SELECT a FROM ArchivosAdjuntos a WHERE a.idArchivo = :idArchivo"),
    @NamedQuery(name = "ArchivosAdjuntos.findByDescripcion", query = "SELECT a FROM ArchivosAdjuntos a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "ArchivosAdjuntos.findByPdf", query = "SELECT a FROM ArchivosAdjuntos a WHERE a.pdf = :pdf")})
public class ArchivosAdjuntos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_archivo")
    private Long idArchivo;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "pdf")
    private String pdf;
    @OneToMany(mappedBy = "idArchivo")
    private Collection<Titulo> tituloCollection;
    @JoinColumn(name = "num_doc_profesional", referencedColumnName = "num_doc_profesional")
    @ManyToOne
    private TarjetaProfesional numDocProfesional;
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    @ManyToOne
    private Profesor idProfesor;

    public ArchivosAdjuntos() {
    }

    public ArchivosAdjuntos(Long idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Long getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Long idArchivo) {
        this.idArchivo = idArchivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    @XmlTransient
    public Collection<Titulo> getTituloCollection() {
        return tituloCollection;
    }

    public void setTituloCollection(Collection<Titulo> tituloCollection) {
        this.tituloCollection = tituloCollection;
    }

    public TarjetaProfesional getNumDocProfesional() {
        return numDocProfesional;
    }

    public void setNumDocProfesional(TarjetaProfesional numDocProfesional) {
        this.numDocProfesional = numDocProfesional;
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
        hash += (idArchivo != null ? idArchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchivosAdjuntos)) {
            return false;
        }
        ArchivosAdjuntos other = (ArchivosAdjuntos) object;
        if ((this.idArchivo == null && other.idArchivo != null) || (this.idArchivo != null && !this.idArchivo.equals(other.idArchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.ArchivosAdjuntos[ idArchivo=" + idArchivo + " ]";
    }
    
}
