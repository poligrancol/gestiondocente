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
@Table(name = "ARCHIVOS_ADJUNTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchivosAdjuntos.findAll", query = "SELECT a FROM ArchivosAdjuntos a"),
    @NamedQuery(name = "ArchivosAdjuntos.findByIdArchivo", query = "SELECT a FROM ArchivosAdjuntos a WHERE a.idArchivo = :idArchivo"),
    @NamedQuery(name = "ArchivosAdjuntos.findByClaseDocumento", query = "SELECT a FROM ArchivosAdjuntos a WHERE a.claseDocumento = :claseDocumento"),
    @NamedQuery(name = "ArchivosAdjuntos.findByExtensionArchivo", query = "SELECT a FROM ArchivosAdjuntos a WHERE a.extensionArchivo = :extensionArchivo")})
public class ArchivosAdjuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ARCHIVO")
    private Long idArchivo;
    @Size(max = 50)
    @Column(name = "CLASE_DOCUMENTO")
    private String claseDocumento;
    @Size(max = 50)
    @Column(name = "EXTENSION_ARCHIVO")
    private String extensionArchivo;
    @JoinColumn(name = "ID_PROFESOR", referencedColumnName = "ID_PROFESOR")
    @ManyToOne
    private Profesor idProfesor;
    @JoinColumn(name = "NUM_DOC_PROFESIONAL", referencedColumnName = "NUM_DOC_PROFESIONAL")
    @ManyToOne
    private TarjetaProfesional numDocProfesional;
    @OneToMany(mappedBy = "idArchivo")
    private Collection<Titulo> tituloCollection;

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

    public String getClaseDocumento() {
        return claseDocumento;
    }

    public void setClaseDocumento(String claseDocumento) {
        this.claseDocumento = claseDocumento;
    }

    public String getExtensionArchivo() {
        return extensionArchivo;
    }

    public void setExtensionArchivo(String extensionArchivo) {
        this.extensionArchivo = extensionArchivo;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public TarjetaProfesional getNumDocProfesional() {
        return numDocProfesional;
    }

    public void setNumDocProfesional(TarjetaProfesional numDocProfesional) {
        this.numDocProfesional = numDocProfesional;
    }

    @XmlTransient
    public Collection<Titulo> getTituloCollection() {
        return tituloCollection;
    }

    public void setTituloCollection(Collection<Titulo> tituloCollection) {
        this.tituloCollection = tituloCollection;
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
