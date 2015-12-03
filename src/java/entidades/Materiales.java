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
@Table(name = "materiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiales.findAll", query = "SELECT m FROM Materiales m"),
    @NamedQuery(name = "Materiales.findByIdmateriales", query = "SELECT m FROM Materiales m WHERE m.idmateriales = :idmateriales"),
    @NamedQuery(name = "Materiales.findByMaterial", query = "SELECT m FROM Materiales m WHERE m.material = :material"),
    @NamedQuery(name = "Materiales.findByDescripcion", query = "SELECT m FROM Materiales m WHERE m.descripcion = :descripcion")})
public class Materiales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmateriales")
    private Integer idmateriales;
    @Size(max = 45)
    @Column(name = "material")
    private String material;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialesIdmateriales")
    private Collection<Productos> productosCollection;

    public Materiales() {
    }

    public Materiales(Integer idmateriales) {
        this.idmateriales = idmateriales;
    }

    public Integer getIdmateriales() {
        return idmateriales;
    }

    public void setIdmateriales(Integer idmateriales) {
        this.idmateriales = idmateriales;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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
        hash += (idmateriales != null ? idmateriales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiales)) {
            return false;
        }
        Materiales other = (Materiales) object;
        if ((this.idmateriales == null && other.idmateriales != null) || (this.idmateriales != null && !this.idmateriales.equals(other.idmateriales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    //    return "entidades.Materiales[ idmateriales=" + idmateriales + " ]";
        return material;
    }
    
}
