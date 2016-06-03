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
 * @author julianolarte
 */
@Entity
@Table(name = "materias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m"),
    @NamedQuery(name = "Materias.findByIdMateria", query = "SELECT m FROM Materias m WHERE m.idMateria = :idMateria"),
    @NamedQuery(name = "Materias.findByDescripcion", query = "SELECT m FROM Materias m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Materias.findByTipoExperencia", query = "SELECT m FROM Materias m WHERE m.tipoExperencia = :tipoExperencia")})
public class Materias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materia")
    private Long idMateria;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "tipo_experencia")
    private String tipoExperencia;
    @JoinColumn(name = "id_detalle", referencedColumnName = "id_detalle")
    @ManyToOne
    private DetalleExperiencia idDetalle;

    public Materias() {
    }

    public Materias(Long idMateria) {
        this.idMateria = idMateria;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoExperencia() {
        return tipoExperencia;
    }

    public void setTipoExperencia(String tipoExperencia) {
        this.tipoExperencia = tipoExperencia;
    }

    public DetalleExperiencia getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(DetalleExperiencia idDetalle) {
        this.idDetalle = idDetalle;
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
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.Materias[ idMateria=" + idMateria + " ]";
    }
    
}
