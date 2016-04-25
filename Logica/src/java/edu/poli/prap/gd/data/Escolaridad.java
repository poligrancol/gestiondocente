/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poli.prap.gd.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julianolarte
 */
@Entity
@Table(name = "escolaridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escolaridad.findAll", query = "SELECT e FROM Escolaridad e"),
    @NamedQuery(name = "Escolaridad.findByCodigoEscolaridad", query = "SELECT e FROM Escolaridad e WHERE e.codigoEscolaridad = :codigoEscolaridad"),
    @NamedQuery(name = "Escolaridad.findByInstitucion", query = "SELECT e FROM Escolaridad e WHERE e.institucion = :institucion"),
    @NamedQuery(name = "Escolaridad.findByNivel", query = "SELECT e FROM Escolaridad e WHERE e.nivel = :nivel"),
    @NamedQuery(name = "Escolaridad.findByFacultad", query = "SELECT e FROM Escolaridad e WHERE e.facultad = :facultad"),
    @NamedQuery(name = "Escolaridad.findByAnos", query = "SELECT e FROM Escolaridad e WHERE e.anos = :anos"),
    @NamedQuery(name = "Escolaridad.findByFechaDeInicio", query = "SELECT e FROM Escolaridad e WHERE e.fechaDeInicio = :fechaDeInicio"),
    @NamedQuery(name = "Escolaridad.findByFechaGrado", query = "SELECT e FROM Escolaridad e WHERE e.fechaGrado = :fechaGrado"),
    @NamedQuery(name = "Escolaridad.findByConvalidado", query = "SELECT e FROM Escolaridad e WHERE e.convalidado = :convalidado"),
    @NamedQuery(name = "Escolaridad.findByEstadoEstudio", query = "SELECT e FROM Escolaridad e WHERE e.estadoEstudio = :estadoEstudio")})
public class Escolaridad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_escolaridad")
    private Long codigoEscolaridad;
    @Size(max = 50)
    @Column(name = "institucion")
    private String institucion;
    @Size(max = 50)
    @Column(name = "nivel")
    private String nivel;
    @Size(max = 50)
    @Column(name = "facultad")
    private String facultad;
    @Column(name = "anos")
    private Long anos;
    @Column(name = "fecha_de_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaDeInicio;
    @Column(name = "fecha_grado")
    @Temporal(TemporalType.DATE)
    private Date fechaGrado;
    @Size(max = 50)
    @Column(name = "convalidado")
    private String convalidado;
    @Column(name = "estado_estudio")
    private Boolean estadoEstudio;
    @JoinColumn(name = "id_titulo", referencedColumnName = "id_titulo")
    @ManyToOne
    private Titulo idTitulo;
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    @ManyToOne
    private Profesor idProfesor;
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")
    @ManyToOne
    private Pais idPais;

    public Escolaridad() {
    }

    public Escolaridad(Long codigoEscolaridad) {
        this.codigoEscolaridad = codigoEscolaridad;
    }

    public Long getCodigoEscolaridad() {
        return codigoEscolaridad;
    }

    public void setCodigoEscolaridad(Long codigoEscolaridad) {
        this.codigoEscolaridad = codigoEscolaridad;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public Long getAnos() {
        return anos;
    }

    public void setAnos(Long anos) {
        this.anos = anos;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public Date getFechaGrado() {
        return fechaGrado;
    }

    public void setFechaGrado(Date fechaGrado) {
        this.fechaGrado = fechaGrado;
    }

    public String getConvalidado() {
        return convalidado;
    }

    public void setConvalidado(String convalidado) {
        this.convalidado = convalidado;
    }

    public Boolean getEstadoEstudio() {
        return estadoEstudio;
    }

    public void setEstadoEstudio(Boolean estadoEstudio) {
        this.estadoEstudio = estadoEstudio;
    }

    public Titulo getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(Titulo idTitulo) {
        this.idTitulo = idTitulo;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEscolaridad != null ? codigoEscolaridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escolaridad)) {
            return false;
        }
        Escolaridad other = (Escolaridad) object;
        if ((this.codigoEscolaridad == null && other.codigoEscolaridad != null) || (this.codigoEscolaridad != null && !this.codigoEscolaridad.equals(other.codigoEscolaridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.Escolaridad[ codigoEscolaridad=" + codigoEscolaridad + " ]";
    }
    
}
