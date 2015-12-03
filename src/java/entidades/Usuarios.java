/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author JULIAN
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdusuarios", query = "SELECT u FROM Usuarios u WHERE u.idusuarios = :idusuarios"),
    @NamedQuery(name = "Usuarios.findByPrimerNombre", query = "SELECT u FROM Usuarios u WHERE u.primerNombre = :primerNombre"),
    @NamedQuery(name = "Usuarios.findBySegundoNombre", query = "SELECT u FROM Usuarios u WHERE u.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Usuarios.findByPrimerApellido", query = "SELECT u FROM Usuarios u WHERE u.primerApellido = :primerApellido"),
    @NamedQuery(name = "Usuarios.findBySegundoApellido", query = "SELECT u FROM Usuarios u WHERE u.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Usuarios.findByCelular", query = "SELECT u FROM Usuarios u WHERE u.celular = :celular"),
    @NamedQuery(name = "Usuarios.findByDireccion", query = "SELECT u FROM Usuarios u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuarios.findByGenero", query = "SELECT u FROM Usuarios u WHERE u.genero = :genero"),
    @NamedQuery(name = "Usuarios.findByFechaNacimiento", query = "SELECT u FROM Usuarios u WHERE u.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Usuarios.findByFoto", query = "SELECT u FROM Usuarios u WHERE u.foto = :foto"),
    @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuarios")
    private Integer idusuarios;
    @Size(max = 45)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 45)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Size(max = 45)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 45)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "celular")
    private BigInteger celular;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "genero")
    private String genero;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "foto")
    private String foto;
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;
    @Lob
    @Size(max = 65535)
    @Column(name = "contrasena")
    private String contrasena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteIdusuarios")
    private Collection<Facturas> facturasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajeroIdusuarios")
    private Collection<Facturas> facturasCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosIdusuarios")
    private Collection<Perfiles> perfilesCollection;
    @JoinColumn(name = "almacenes_idalmacenes", referencedColumnName = "idalmacenes")
    @ManyToOne(optional = false)
    private Almacenes almacenesIdalmacenes;
    @JoinColumn(name = "ciudades_idciudades", referencedColumnName = "idciudades")
    @ManyToOne(optional = false)
    private Ciudades ciudadesIdciudades;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosIdusuarios")
    private Collection<Bonos> bonosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosIdusuarios")
    private Collection<Stock> stockCollection;

    public Usuarios() {
    }

    public Usuarios(Integer idusuarios) {
        this.idusuarios = idusuarios;
    }

    public Integer getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(Integer idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        /*encriptar la contrasena en el registro*/
        //String texto="123";
        //String encript=DigestUtils.sha256(texto);
        String encript=DigestUtils.sha256Hex(contrasena);
        //System.out.println("shaHex:"+encript);
        contrasena=encript;        
        this.contrasena = contrasena;
    }

    @XmlTransient
    public Collection<Facturas> getFacturasCollection() {
        return facturasCollection;
    }

    public void setFacturasCollection(Collection<Facturas> facturasCollection) {
        this.facturasCollection = facturasCollection;
    }

    @XmlTransient
    public Collection<Facturas> getFacturasCollection1() {
        return facturasCollection1;
    }

    public void setFacturasCollection1(Collection<Facturas> facturasCollection1) {
        this.facturasCollection1 = facturasCollection1;
    }

    @XmlTransient
    public Collection<Perfiles> getPerfilesCollection() {
        return perfilesCollection;
    }

    public void setPerfilesCollection(Collection<Perfiles> perfilesCollection) {
        this.perfilesCollection = perfilesCollection;
    }

    public Almacenes getAlmacenesIdalmacenes() {
        return almacenesIdalmacenes;
    }

    public void setAlmacenesIdalmacenes(Almacenes almacenesIdalmacenes) {
        this.almacenesIdalmacenes = almacenesIdalmacenes;
    }

    public Ciudades getCiudadesIdciudades() {
        return ciudadesIdciudades;
    }

    public void setCiudadesIdciudades(Ciudades ciudadesIdciudades) {
        this.ciudadesIdciudades = ciudadesIdciudades;
    }

    @XmlTransient
    public Collection<Bonos> getBonosCollection() {
        return bonosCollection;
    }

    public void setBonosCollection(Collection<Bonos> bonosCollection) {
        this.bonosCollection = bonosCollection;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuarios != null ? idusuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idusuarios == null && other.idusuarios != null) || (this.idusuarios != null && !this.idusuarios.equals(other.idusuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "entidades.Usuarios[ idusuarios=" + idusuarios + " ]";
        return idusuarios+" "+primerNombre+" "+primerApellido;
    }
    
}
