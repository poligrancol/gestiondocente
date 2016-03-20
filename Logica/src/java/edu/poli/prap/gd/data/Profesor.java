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
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByIdProfesor", query = "SELECT p FROM Profesor p WHERE p.idProfesor = :idProfesor"),
    @NamedQuery(name = "Profesor.findByTipoDocumento", query = "SELECT p FROM Profesor p WHERE p.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Profesor.findByNumeroDocumento", query = "SELECT p FROM Profesor p WHERE p.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Profesor.findByApellido", query = "SELECT p FROM Profesor p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Profesor.findByFechaDeExpedicion", query = "SELECT p FROM Profesor p WHERE p.fechaDeExpedicion = :fechaDeExpedicion"),
    @NamedQuery(name = "Profesor.findByLugarDeExpedicion", query = "SELECT p FROM Profesor p WHERE p.lugarDeExpedicion = :lugarDeExpedicion"),
    @NamedQuery(name = "Profesor.findByRh", query = "SELECT p FROM Profesor p WHERE p.rh = :rh"),
    @NamedQuery(name = "Profesor.findByGenero", query = "SELECT p FROM Profesor p WHERE p.genero = :genero"),
    @NamedQuery(name = "Profesor.findByFechaDeNacimiento", query = "SELECT p FROM Profesor p WHERE p.fechaDeNacimiento = :fechaDeNacimiento"),
    @NamedQuery(name = "Profesor.findByEstadoCivil", query = "SELECT p FROM Profesor p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Profesor.findByEmailPersonal", query = "SELECT p FROM Profesor p WHERE p.emailPersonal = :emailPersonal"),
    @NamedQuery(name = "Profesor.findByEmailInstitucional", query = "SELECT p FROM Profesor p WHERE p.emailInstitucional = :emailInstitucional"),
    @NamedQuery(name = "Profesor.findByTelefonoFijo", query = "SELECT p FROM Profesor p WHERE p.telefonoFijo = :telefonoFijo"),
    @NamedQuery(name = "Profesor.findByCelular", query = "SELECT p FROM Profesor p WHERE p.celular = :celular"),
    @NamedQuery(name = "Profesor.findByDireccion", query = "SELECT p FROM Profesor p WHERE p.direccion = :direccion"),
    @NamedQuery(
        name = "Profesor.findByParams",
        query = "SELECT p FROM Profesor p WHERE " +
                "lower(p.nombre) like :first_name and " +
                "lower(p.apellido) like :last_name and " +
                "p.numeroDocumento like :document_number and " +
                "lower(p.genero) like :gender"
    )
})
public class Profesor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_profesor")
    private Long idProfesor;
    @Size(max = 50)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_de_expedicion")
    @Temporal(TemporalType.DATE)
    private Date fechaDeExpedicion;
    @Size(max = 50)
    @Column(name = "lugar_de_expedicion")
    private String lugarDeExpedicion;
    @Size(max = 50)
    @Column(name = "rh")
    private String rh;
    @Size(max = 50)
    @Column(name = "genero")
    private String genero;
    @Column(name = "fecha_de_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;
    @Size(max = 50)
    @Column(name = "Estado_Civil")
    private String estadoCivil;
    @Size(max = 50)
    @Column(name = "email_personal")
    private String emailPersonal;
    @Size(max = 50)
    @Column(name = "email_institucional")
    private String emailInstitucional;
    @Size(max = 50)
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @Column(name = "celular")
    private Long celular;
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "id_pais_de_origen", referencedColumnName = "id_pais")
    @ManyToOne
    private Pais idPaisDeOrigen;
    @JoinColumn(name = "id_pais_lugar_nacimiento", referencedColumnName = "id_pais")
    @ManyToOne
    private Pais idPaisLugarNacimiento;
    @JoinColumn(name = "id_pais_nacionalidad", referencedColumnName = "id_pais")
    @ManyToOne
    private Pais idPaisNacionalidad;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    @ManyToOne
    private Departamento idDepartamento;
    @OneToMany(mappedBy = "idProfesor")
    private Collection<Titulo> tituloCollection;
    @OneToMany(mappedBy = "idProfesor")
    private Collection<DetalleExperiencia> detalleExperienciaCollection;
    @OneToMany(mappedBy = "idProfesor")
    private Collection<Experiencia> experienciaCollection;
    @OneToMany(mappedBy = "idProfesor")
    private Collection<ArchivosAdjuntos> archivosAdjuntosCollection;
    @OneToMany(mappedBy = "idProfesor")
    private Collection<Escolaridad> escolaridadCollection;
    @OneToMany(mappedBy = "idProfesor")
    private Collection<TarjetaProfesional> tarjetaProfesionalCollection;

    public Profesor() {
    }

    public Profesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaDeExpedicion() {
        return fechaDeExpedicion;
    }

    public void setFechaDeExpedicion(Date fechaDeExpedicion) {
        this.fechaDeExpedicion = fechaDeExpedicion;
    }

    public String getLugarDeExpedicion() {
        return lugarDeExpedicion;
    }

    public void setLugarDeExpedicion(String lugarDeExpedicion) {
        this.lugarDeExpedicion = lugarDeExpedicion;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pais getIdPaisDeOrigen() {
        return idPaisDeOrigen;
    }

    public void setIdPaisDeOrigen(Pais idPaisDeOrigen) {
        this.idPaisDeOrigen = idPaisDeOrigen;
    }

    public Pais getIdPaisLugarNacimiento() {
        return idPaisLugarNacimiento;
    }

    public void setIdPaisLugarNacimiento(Pais idPaisLugarNacimiento) {
        this.idPaisLugarNacimiento = idPaisLugarNacimiento;
    }

    public Pais getIdPaisNacionalidad() {
        return idPaisNacionalidad;
    }

    public void setIdPaisNacionalidad(Pais idPaisNacionalidad) {
        this.idPaisNacionalidad = idPaisNacionalidad;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @XmlTransient
    public Collection<Titulo> getTituloCollection() {
        return tituloCollection;
    }

    public void setTituloCollection(Collection<Titulo> tituloCollection) {
        this.tituloCollection = tituloCollection;
    }

    @XmlTransient
    public Collection<DetalleExperiencia> getDetalleExperienciaCollection() {
        return detalleExperienciaCollection;
    }

    public void setDetalleExperienciaCollection(Collection<DetalleExperiencia> detalleExperienciaCollection) {
        this.detalleExperienciaCollection = detalleExperienciaCollection;
    }

    @XmlTransient
    public Collection<Experiencia> getExperienciaCollection() {
        return experienciaCollection;
    }

    public void setExperienciaCollection(Collection<Experiencia> experienciaCollection) {
        this.experienciaCollection = experienciaCollection;
    }

    @XmlTransient
    public Collection<ArchivosAdjuntos> getArchivosAdjuntosCollection() {
        return archivosAdjuntosCollection;
    }

    public void setArchivosAdjuntosCollection(Collection<ArchivosAdjuntos> archivosAdjuntosCollection) {
        this.archivosAdjuntosCollection = archivosAdjuntosCollection;
    }

    @XmlTransient
    public Collection<Escolaridad> getEscolaridadCollection() {
        return escolaridadCollection;
    }

    public void setEscolaridadCollection(Collection<Escolaridad> escolaridadCollection) {
        this.escolaridadCollection = escolaridadCollection;
    }

    @XmlTransient
    public Collection<TarjetaProfesional> getTarjetaProfesionalCollection() {
        return tarjetaProfesionalCollection;
    }

    public void setTarjetaProfesionalCollection(Collection<TarjetaProfesional> tarjetaProfesionalCollection) {
        this.tarjetaProfesionalCollection = tarjetaProfesionalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesor != null ? idProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idProfesor == null && other.idProfesor != null) || (this.idProfesor != null && !this.idProfesor.equals(other.idProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.Profesor[ idProfesor=" + idProfesor + " ]";
    }

}
