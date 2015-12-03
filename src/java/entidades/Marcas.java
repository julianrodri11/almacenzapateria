/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
@Table(name = "marcas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcas.findAll", query = "SELECT m FROM Marcas m"),
    @NamedQuery(name = "Marcas.findByIdmarcas", query = "SELECT m FROM Marcas m WHERE m.idmarcas = :idmarcas"),
    @NamedQuery(name = "Marcas.findByMarca", query = "SELECT m FROM Marcas m WHERE m.marca = :marca"),
    @NamedQuery(name = "Marcas.findByDescripcion", query = "SELECT m FROM Marcas m WHERE m.descripcion = :descripcion")})
public class Marcas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmarcas")
    private Integer idmarcas;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcasIdmarcas")
    private Collection<Productos> productosCollection;

    public Marcas() {
    }

    public Marcas(Integer idmarcas) {
        this.idmarcas = idmarcas;
    }

    public Integer getIdmarcas() {
        return idmarcas;
    }

    public void setIdmarcas(Integer idmarcas) {
        this.idmarcas = idmarcas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmarcas != null ? idmarcas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcas)) {
            return false;
        }
        Marcas other = (Marcas) object;
        if ((this.idmarcas == null && other.idmarcas != null) || (this.idmarcas != null && !this.idmarcas.equals(other.idmarcas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    //    return "entidades.Marcas[ idmarcas=" + idmarcas + " ]";
        return marca;
    }
    
}
