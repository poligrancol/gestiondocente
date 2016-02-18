/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poli.prap.gd.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julianolarte
 */
@Entity
@Table(name = "tarjeta_profesional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarjetaProfesional.findAll", query = "SELECT t FROM TarjetaProfesional t"),
    @NamedQuery(name = "TarjetaProfesional.findByNumDocProfesional", query = "SELECT t FROM TarjetaProfesional t WHERE t.numDocProfesional = :numDocProfesional"),
    @NamedQuery(name = "TarjetaProfesional.findByDocumentoProfesional", query = "SELECT t FROM TarjetaProfesional t WHERE t.documentoProfesional = :documentoProfesional"),
    @NamedQuery(name = "TarjetaProfesional.findByFechaDeExpedicionProfesional", query = "SELECT t FROM TarjetaProfesional t WHERE t.fechaDeExpedicionProfesional = :fechaDeExpedicionProfesional"),
    @NamedQuery(name = "TarjetaProfesional.findByLugarDeExpedicion", query = "SELECT t FROM TarjetaProfesional t WHERE t.lugarDeExpedicion = :lugarDeExpedicion")})
public class TarjetaProfesional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_doc_profesional")
    private Long numDocProfesional;
    @Size(max = 50)
    @Column(name = "documento_profesional")
    private String documentoProfesional;
    @Column(name = "fecha_de_expedicion_profesional")
    @Temporal(TemporalType.DATE)
    private Date fechaDeExpedicionProfesional;
    @Size(max = 50)
    @Column(name = "lugar_de_expedicion")
    private String lugarDeExpedicion;
    @OneToMany(mappedBy = "numDocProfesional")
    private Collection<ArchivosAdjuntos> archivosAdjuntosCollection;
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    @ManyToOne
    private Profesor idProfesor;

    public TarjetaProfesional() {
    }

    public TarjetaProfesional(Long numDocProfesional) {
        this.numDocProfesional = numDocProfesional;
    }

    public Long getNumDocProfesional() {
        return numDocProfesional;
    }

    public void setNumDocProfesional(Long numDocProfesional) {
        this.numDocProfesional = numDocProfesional;
    }

    public String getDocumentoProfesional() {
        return documentoProfesional;
    }

    public void setDocumentoProfesional(String documentoProfesional) {
        this.documentoProfesional = documentoProfesional;
    }

    public Date getFechaDeExpedicionProfesional() {
        return fechaDeExpedicionProfesional;
    }

    public void setFechaDeExpedicionProfesional(Date fechaDeExpedicionProfesional) {
        this.fechaDeExpedicionProfesional = fechaDeExpedicionProfesional;
    }

    public String getLugarDeExpedicion() {
        return lugarDeExpedicion;
    }

    public void setLugarDeExpedicion(String lugarDeExpedicion) {
        this.lugarDeExpedicion = lugarDeExpedicion;
    }

    @XmlTransient
    public Collection<ArchivosAdjuntos> getArchivosAdjuntosCollection() {
        return archivosAdjuntosCollection;
    }

    public void setArchivosAdjuntosCollection(Collection<ArchivosAdjuntos> archivosAdjuntosCollection) {
        this.archivosAdjuntosCollection = archivosAdjuntosCollection;
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
        hash += (numDocProfesional != null ? numDocProfesional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetaProfesional)) {
            return false;
        }
        TarjetaProfesional other = (TarjetaProfesional) object;
        if ((this.numDocProfesional == null && other.numDocProfesional != null) || (this.numDocProfesional != null && !this.numDocProfesional.equals(other.numDocProfesional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.TarjetaProfesional[ numDocProfesional=" + numDocProfesional + " ]";
    }
    
}
