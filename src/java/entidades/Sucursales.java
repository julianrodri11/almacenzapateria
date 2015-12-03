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
 * @author JULIAN
 */
@Entity
@Table(name = "sucursales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursales.findAll", query = "SELECT s FROM Sucursales s"),
    @NamedQuery(name = "Sucursales.findByIdsucursales", query = "SELECT s FROM Sucursales s WHERE s.idsucursales = :idsucursales"),
    @NamedQuery(name = "Sucursales.findByDireccion", query = "SELECT s FROM Sucursales s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Sucursales.findByCorreo", query = "SELECT s FROM Sucursales s WHERE s.correo = :correo"),
    @NamedQuery(name = "Sucursales.findByCelular", query = "SELECT s FROM Sucursales s WHERE s.celular = :celular"),
    @NamedQuery(name = "Sucursales.findByTelefono", query = "SELECT s FROM Sucursales s WHERE s.telefono = :telefono")})
public class Sucursales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsucursales")
    private Integer idsucursales;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;
    @Column(name = "celular")
    private BigInteger celular;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @JoinColumn(name = "ciudades_idciudades", referencedColumnName = "idciudades")
    @ManyToOne(optional = false)
    private Ciudades ciudadesIdciudades;
    @JoinColumn(name = "almacenes_idalmacenes", referencedColumnName = "idalmacenes")
    @ManyToOne(optional = false)
    private Almacenes almacenesIdalmacenes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalesIdsucursales")
    private Collection<Productos> productosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalesIdsucursales")
    private Collection<Cajas> cajasCollection;

    public Sucursales() {
    }

    public Sucursales(Integer idsucursales) {
        this.idsucursales = idsucursales;
    }

    public Integer getIdsucursales() {
        return idsucursales;
    }

    public void setIdsucursales(Integer idsucursales) {
        this.idsucursales = idsucursales;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Ciudades getCiudadesIdciudades() {
        return ciudadesIdciudades;
    }

    public void setCiudadesIdciudades(Ciudades ciudadesIdciudades) {
        this.ciudadesIdciudades = ciudadesIdciudades;
    }

    public Almacenes getAlmacenesIdalmacenes() {
        return almacenesIdalmacenes;
    }

    public void setAlmacenesIdalmacenes(Almacenes almacenesIdalmacenes) {
        this.almacenesIdalmacenes = almacenesIdalmacenes;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @XmlTransient
    public Collection<Cajas> getCajasCollection() {
        return cajasCollection;
    }

    public void setCajasCollection(Collection<Cajas> cajasCollection) {
        this.cajasCollection = cajasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsucursales != null ? idsucursales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursales)) {
            return false;
        }
        Sucursales other = (Sucursales) object;
        if ((this.idsucursales == null && other.idsucursales != null) || (this.idsucursales != null && !this.idsucursales.equals(other.idsucursales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    //    return "entidades.Sucursales[ idsucursales=" + idsucursales + " ]";
        return almacenesIdalmacenes+" - "+ciudadesIdciudades;
    }
    
}
