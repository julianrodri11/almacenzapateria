/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author JULIAN
 */
@Entity
@Table(name = "almacenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Almacenes.findAll", query = "SELECT a FROM Almacenes a"),
    @NamedQuery(name = "Almacenes.findByIdalmacenes", query = "SELECT a FROM Almacenes a WHERE a.idalmacenes = :idalmacenes"),
    @NamedQuery(name = "Almacenes.findByAlmacen", query = "SELECT a FROM Almacenes a WHERE a.almacen = :almacen"),
    @NamedQuery(name = "Almacenes.findByNit", query = "SELECT a FROM Almacenes a WHERE a.nit = :nit"),
    @NamedQuery(name = "Almacenes.findByCorreo", query = "SELECT a FROM Almacenes a WHERE a.correo = :correo"),
    @NamedQuery(name = "Almacenes.findByCelular", query = "SELECT a FROM Almacenes a WHERE a.celular = :celular"),
    @NamedQuery(name = "Almacenes.findByTelefono", query = "SELECT a FROM Almacenes a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Almacenes.findByDireccion", query = "SELECT a FROM Almacenes a WHERE a.direccion = :direccion")})
public class Almacenes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idalmacenes")
    private Integer idalmacenes;
    @Size(max = 45)
    @Column(name = "almacen")
    private String almacen;
    @Size(max = 45)
    @Column(name = "nit")
    private String nit;
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;
    @Column(name = "celular")
    private BigInteger celular;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacenesIdalmacenes")
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacenesIdalmacenes")
    private Collection<Sucursales> sucursalesCollection;

    public Almacenes() {
    }

    public Almacenes(Integer idalmacenes) {
        this.idalmacenes = idalmacenes;
    }

    public Integer getIdalmacenes() {
        return idalmacenes;
    }

    public void setIdalmacenes(Integer idalmacenes) {
        this.idalmacenes = idalmacenes;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public BigInteger getCelular() {
        return celular;
    }

    public void setCelular(BigInteger celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @XmlTransient
    public Collection<Sucursales> getSucursalesCollection() {
        return sucursalesCollection;
    }

    public void setSucursalesCollection(Collection<Sucursales> sucursalesCollection) {
        this.sucursalesCollection = sucursalesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalmacenes != null ? idalmacenes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacenes)) {
            return false;
        }
        Almacenes other = (Almacenes) object;
        if ((this.idalmacenes == null && other.idalmacenes != null) || (this.idalmacenes != null && !this.idalmacenes.equals(other.idalmacenes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    //    return "entidades.Almacenes[ idalmacenes=" + idalmacenes + " ]";
        return almacen;
    }
    
}
