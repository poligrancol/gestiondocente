package edu.poli.prap.gd.data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author DarkKlitos
 */
@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findById", query = "SELECT p FROM Profesor p WHERE p.id = :id"),
    @NamedQuery(name = "Profesor.findByIdProfesor", query = "SELECT p FROM Profesor p WHERE p.idProfesor = :idProfesor"),
    @NamedQuery(name = "Profesor.findByTipoDocumento", query = "SELECT p FROM Profesor p WHERE p.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Profesor.findByNumeroDocumento", query = "SELECT p FROM Profesor p WHERE p.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Profesor.findByApellido", query = "SELECT p FROM Profesor p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Profesor.findByFechaDeExpedicion", query = "SELECT p FROM Profesor p WHERE p.fechaDeExpedicion = :fechaDeExpedicion"),
    @NamedQuery(name = "Profesor.findByLugarDeExpedicion", query = "SELECT p FROM Profesor p WHERE p.lugarDeExpedicion = :lugarDeExpedicion"),
    @NamedQuery(name = "Profesor.findByRh", query = "SELECT p FROM Profesor p WHERE p.rh = :rh"),
    @NamedQuery(name = "Profesor.findByIdPaisNacionalidad", query = "SELECT p FROM Profesor p WHERE p.idPaisNacionalidad = :idPaisNacionalidad"),
    @NamedQuery(name = "Profesor.findByGenero", query = "SELECT p FROM Profesor p WHERE p.genero = :genero"),
    @NamedQuery(name = "Profesor.findByIdPaisLugarNacimiento", query = "SELECT p FROM Profesor p WHERE p.idPaisLugarNacimiento = :idPaisLugarNacimiento"),
    @NamedQuery(name = "Profesor.findByFechaDeNacimiento", query = "SELECT p FROM Profesor p WHERE p.fechaDeNacimiento = :fechaDeNacimiento"),
    @NamedQuery(name = "Profesor.findByIdPaisDeOrigen", query = "SELECT p FROM Profesor p WHERE p.idPaisDeOrigen = :idPaisDeOrigen"),
    @NamedQuery(name = "Profesor.findByEstadoCivil", query = "SELECT p FROM Profesor p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Profesor.findByIdDepartamento", query = "SELECT p FROM Profesor p WHERE p.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "Profesor.findByEmailPersonal", query = "SELECT p FROM Profesor p WHERE p.emailPersonal = :emailPersonal"),
    @NamedQuery(name = "Profesor.findByEmailInstitucional", query = "SELECT p FROM Profesor p WHERE p.emailInstitucional = :emailInstitucional"),
    @NamedQuery(name = "Profesor.findByTelefonoFijo", query = "SELECT p FROM Profesor p WHERE p.telefonoFijo = :telefonoFijo"),
    @NamedQuery(name = "Profesor.findByCelular", query = "SELECT p FROM Profesor p WHERE p.celular = :celular"),
    @NamedQuery(name = "Profesor.findByDireccion", query = "SELECT p FROM Profesor p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Profesor.findByParams", query = " SELECT p" +
                                                        "   FROM Profesor p" +
                                                        "  WHERE lower(p.nombre) like :parametro" +
                                                        "     OR lower(p.apellido) like :parametro" +
                                                        "     OR lower(p.genero) like :parametro" +
                                                        "     OR lower(p.estadoCivil) like :parametro" +
                                                        "     OR lower(p.emailPersonal) like :parametro" +
                                                        "     OR lower(p.emailInstitucional) like :parametro" +
                                                        "     OR lower(p.direccion) like :parametro" )})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_profesor")
    private int idProfesor;
    @Size(max = 2147483647)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_documento")
    private BigInteger numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_de_expedicion")
    @Temporal(TemporalType.DATE)
    private Date fechaDeExpedicion;
    @Size(max = 2147483647)
    @Column(name = "lugar_de_expedicion")
    private String lugarDeExpedicion;
    @Size(max = 2147483647)
    @Column(name = "rh")
    private String rh;
    @Column(name = "id_pais_nacionalidad")
    private Integer idPaisNacionalidad;
    @Size(max = 2147483647)
    @Column(name = "genero")
    private String genero;
    @Column(name = "id_pais_lugar_nacimiento")
    private Integer idPaisLugarNacimiento;
    @Column(name = "fecha_de_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;
    @Column(name = "id_pais_de_origen")
    private Integer idPaisDeOrigen;
    @Size(max = 2147483647)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "id_departamento")
    private Integer idDepartamento;
    @Size(max = 2147483647)
    @Column(name = "email_personal")
    private String emailPersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email_institucional")
    private String emailInstitucional;
    @Size(max = 2147483647)
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @Column(name = "celular")
    private BigInteger celular;
    @Size(max = 2147483647)
    @Column(name = "direccion")
    private String direccion;

    public Profesor() {
    }

    public Profesor(Integer id) {
        this.id = id;
    }

    public Profesor(Integer id, int idProfesor, BigInteger numeroDocumento, String nombre, String apellido, String emailInstitucional) {
        this.id = id;
        this.idProfesor = idProfesor;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.emailInstitucional = emailInstitucional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public BigInteger getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(BigInteger numeroDocumento) {
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

    public Integer getIdPaisNacionalidad() {
        return idPaisNacionalidad;
    }

    public void setIdPaisNacionalidad(Integer idPaisNacionalidad) {
        this.idPaisNacionalidad = idPaisNacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getIdPaisLugarNacimiento() {
        return idPaisLugarNacimiento;
    }

    public void setIdPaisLugarNacimiento(Integer idPaisLugarNacimiento) {
        this.idPaisLugarNacimiento = idPaisLugarNacimiento;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getIdPaisDeOrigen() {
        return idPaisDeOrigen;
    }

    public void setIdPaisDeOrigen(Integer idPaisDeOrigen) {
        this.idPaisDeOrigen = idPaisDeOrigen;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
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

    public BigInteger getCelular() {
        return celular;
    }

    public void setCelular(BigInteger celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.gd.data.Profesor[ id=" + id + " ]";
    }
    
}
