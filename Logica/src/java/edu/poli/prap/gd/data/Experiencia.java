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
 * @author Giovanni
 */
@Entity
@Table(name = "EXPERIENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencia.findAll", query = "SELECT e FROM Experiencia e"),
    @NamedQuery(name = "Experiencia.findByCodigoExperiencia", query = "SELECT e FROM Experiencia e WHERE e.codigoExperiencia = :codigoExperiencia"),
    @NamedQuery(name = "Experiencia.findByExperenciaReal", query = "SELECT e FROM Experiencia e WHERE e.experenciaReal = :experenciaReal"),
    @NamedQuery(name = "Experiencia.findByNivelDeCargoAlto", query = "SELECT e FROM Experiencia e WHERE e.nivelDeCargoAlto = :nivelDeCargoAlto"),
    @NamedQuery(name = "Experiencia.findByExperenciaDiferentePoli", query = "SELECT e FROM Experiencia e WHERE e.experenciaDiferentePoli = :experenciaDiferentePoli"),
    @NamedQuery(name = "Experiencia.findByExperenciaPoli", query = "SELECT e FROM Experiencia e WHERE e.experenciaPoli = :experenciaPoli"),
    @NamedQuery(name = "Experiencia.findByNivelDeCargoAltoAcademico", query = "SELECT e FROM Experiencia e WHERE e.nivelDeCargoAltoAcademico = :nivelDeCargoAltoAcademico"),
    @NamedQuery(name = "Experiencia.findByNivelDeCargoAltoPoli", query = "SELECT e FROM Experiencia e WHERE e.nivelDeCargoAltoPoli = :nivelDeCargoAltoPoli")})
public class Experiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_EXPERIENCIA")
    private Long codigoExperiencia;
    @Column(name = "EXPERENCIA_REAL")
    private Long experenciaReal;
    @Size(max = 50)
    @Column(name = "NIVEL_DE_CARGO_ALTO")
    private String nivelDeCargoAlto;
    @Column(name = "EXPERENCIA_DIFERENTE_POLI")
    private Long experenciaDiferentePoli;
    @Column(name = "EXPERENCIA_POLI")
    private Long experenciaPoli;
    @Size(max = 50)
    @Column(name = "NIVEL_DE_CARGO_ALTO_ACADEMICO")
    private String nivelDeCargoAltoAcademico;
    @Size(max = 50)
    @Column(name = "NIVEL_DE_CARGO_ALTO_POLI")
    private String nivelDeCargoAltoPoli;
    @JoinColumn(name = "ID_PROFESOR", referencedColumnName = "ID_PROFESOR")
    @ManyToOne
    private Profesor idProfesor;

    public Experiencia() {
    }

    public Experiencia(Long codigoExperiencia) {
        this.codigoExperiencia = codigoExperiencia;
    }

    public Long getCodigoExperiencia() {
        return codigoExperiencia;
    }

    public void setCodigoExperiencia(Long codigoExperiencia) {
        this.codigoExperiencia = codigoExperiencia;
    }

    public Long getExperenciaReal() {
        return experenciaReal;
    }

    public void setExperenciaReal(Long experenciaReal) {
        this.experenciaReal = experenciaReal;
    }

    public String getNivelDeCargoAlto() {
        return nivelDeCargoAlto;
    }

    public void setNivelDeCargoAlto(String nivelDeCargoAlto) {
        this.nivelDeCargoAlto = nivelDeCargoAlto;
    }

    public Long getExperenciaDiferentePoli() {
        return experenciaDiferentePoli;
    }

    public void setExperenciaDiferentePoli(Long experenciaDiferentePoli) {
        this.experenciaDiferentePoli = experenciaDiferentePoli;
    }

    public Long getExperenciaPoli() {
        return experenciaPoli;
    }

    public void setExperenciaPoli(Long experenciaPoli) {
        this.experenciaPoli = experenciaPoli;
    }

    public String getNivelDeCargoAltoAcademico() {
        return nivelDeCargoAltoAcademico;
    }

    public void setNivelDeCargoAltoAcademico(String nivelDeCargoAltoAcademico) {
        this.nivelDeCargoAltoAcademico = nivelDeCargoAltoAcademico;
    }

    public String getNivelDeCargoAltoPoli() {
        return nivelDeCargoAltoPoli;
    }

    public void setNivelDeCargoAltoPoli(String nivelDeCargoAltoPoli) {
        this.nivelDeCargoAltoPoli = nivelDeCargoAltoPoli;
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
        hash += (codigoExperiencia != null ? codigoExperiencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencia)) {
            return false;
        }
        Experiencia other = (Experiencia) object;
        if ((this.codigoExperiencia == null && other.codigoExperiencia != null) || (this.codigoExperiencia != null && !this.codigoExperiencia.equals(other.codigoExperiencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.Experiencia[ codigoExperiencia=" + codigoExperiencia + " ]";
    }
    
}
