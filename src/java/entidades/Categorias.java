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
@Table(name = "categorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c"),
    @NamedQuery(name = "Categorias.findByIdcategorias", query = "SELECT c FROM Categorias c WHERE c.idcategorias = :idcategorias"),
    @NamedQuery(name = "Categorias.findByCategoria", query = "SELECT c FROM Categorias c WHERE c.categoria = :categoria"),
    @NamedQuery(name = "Categorias.findByDescripcion", query = "SELECT c FROM Categorias c WHERE c.descripcion = :descripcion")})
public class Categorias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcategorias")
    private Integer idcategorias;
    @Size(max = 45)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriasIdcategorias")
    private Collection<Productos> productosCollection;

    public Categorias() {
    }

    public Categorias(Integer idcategorias) {
        this.idcategorias = idcategorias;
    }

    public Integer getIdcategorias() {
        return idcategorias;
    }

    public void setIdcategorias(Integer idcategorias) {
        this.idcategorias = idcategorias;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
        hash += (idcategorias != null ? idcategorias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.idcategorias == null && other.idcategorias != null) || (this.idcategorias != null && !this.idcategorias.equals(other.idcategorias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "entidades.Categorias[ idcategorias=" + idcategorias + " ]";
        return categoria;
    }
    
}
