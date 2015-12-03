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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JULIAN
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v"),
    @NamedQuery(name = "Ventas.findByIdventas", query = "SELECT v FROM Ventas v WHERE v.idventas = :idventas"),
    @NamedQuery(name = "Ventas.findByCantidad", query = "SELECT v FROM Ventas v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "Ventas.findByIva", query = "SELECT v FROM Ventas v WHERE v.iva = :iva"),
    @NamedQuery(name = "Ventas.findByTotal", query = "SELECT v FROM Ventas v WHERE v.total = :total")})
public class Ventas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idventas")
    private Integer idventas;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "iva")
    private Integer iva;
    @Column(name = "total")
    private BigInteger total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventasIdventas")
    private Collection<Facturas> facturasCollection;
    @JoinColumn(name = "productos_idproductos", referencedColumnName = "idproductos")
    @ManyToOne(optional = false)
    private Productos productosIdproductos;

    public Ventas() {
    }

    public Ventas(Integer idventas) {
        this.idventas = idventas;
    }

    public Integer getIdventas() {
        return idventas;
    }

    public void setIdventas(Integer idventas) {
        this.idventas = idventas;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    @XmlTransient
    public Collection<Facturas> getFacturasCollection() {
        return facturasCollection;
    }

    public void setFacturasCollection(Collection<Facturas> facturasCollection) {
        this.facturasCollection = facturasCollection;
    }

    public Productos getProductosIdproductos() {
        return productosIdproductos;
    }

    public void setProductosIdproductos(Productos productosIdproductos) {
        this.productosIdproductos = productosIdproductos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventas != null ? idventas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idventas == null && other.idventas != null) || (this.idventas != null && !this.idventas.equals(other.idventas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entidades.Ventas[ idventas=" + idventas + " ]";
        return ""+idventas;
    }
    
}
