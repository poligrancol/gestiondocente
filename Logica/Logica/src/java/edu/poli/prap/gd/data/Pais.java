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
@Table(name = "pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
    @NamedQuery(name = "Pais.findByIdPais", query = "SELECT p FROM Pais p WHERE p.idPais = :idPais"),
    @NamedQuery(name = "Pais.findByNombre", query = "SELECT p FROM Pais p WHERE p.nombre = :nombre")})
public class Pais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pais")
    private Long idPais;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idPaisDeOrigen")
    private Collection<Profesor> profesorCollection;
    @OneToMany(mappedBy = "idPaisLugarNacimiento")
    private Collection<Profesor> profesorCollection1;
    @OneToMany(mappedBy = "idPaisNacionalidad")
    private Collection<Profesor> profesorCollection2;
    @OneToMany(mappedBy = "idPais")
    private Collection<Escolaridad> escolaridadCollection;

    public Pais() {
    }

    public Pais(Long idPais) {
        this.idPais = idPais;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection1() {
        return profesorCollection1;
    }

    public void setProfesorCollection1(Collection<Profesor> profesorCollection1) {
        this.profesorCollection1 = profesorCollection1;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection2() {
        return profesorCollection2;
    }

    public void setProfesorCollection2(Collection<Profesor> profesorCollection2) {
        this.profesorCollection2 = profesorCollection2;
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
        hash += (idPais != null ? idPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.idPais == null && other.idPais != null) || (this.idPais != null && !this.idPais.equals(other.idPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.Pais[ idPais=" + idPais + " ]";
    }
    
}
