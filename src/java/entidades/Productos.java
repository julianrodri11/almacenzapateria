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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdproductos", query = "SELECT p FROM Productos p WHERE p.idproductos = :idproductos"),
    @NamedQuery(name = "Productos.findByProducto", query = "SELECT p FROM Productos p WHERE p.producto = :producto"),
    @NamedQuery(name = "Productos.findByPrecio", query = "SELECT p FROM Productos p WHERE p.precio = :precio"),
    @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Productos.findByImagen", query = "SELECT p FROM Productos p WHERE p.imagen = :imagen"),
    @NamedQuery(name = "Productos.findByColor", query = "SELECT p FROM Productos p WHERE p.color = :color"),
    @NamedQuery(name = "Productos.findByTalla", query = "SELECT p FROM Productos p WHERE p.talla = :talla")})
public class Productos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproductos")
    private Integer idproductos;
    @Size(max = 45)
    @Column(name = "producto")
    private String producto;
    @Column(name = "precio")
    private BigInteger precio;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "imagen")
    private String imagen;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    @Size(max = 45)
    @Column(name = "talla")
    private String talla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productosIdproductos")
    private Collection<Ventas> ventasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productosIdproductos")
    private Collection<Stock> stockCollection;
    @JoinColumn(name = "materiales_idmateriales", referencedColumnName = "idmateriales")
    @ManyToOne(optional = false)
    private Materiales materialesIdmateriales;
    @JoinColumn(name = "categorias_idcategorias", referencedColumnName = "idcategorias")
    @ManyToOne(optional = false)
    private Categorias categoriasIdcategorias;
    @JoinColumn(name = "marcas_idmarcas", referencedColumnName = "idmarcas")
    @ManyToOne(optional = false)
    private Marcas marcasIdmarcas;
    @JoinColumn(name = "sucursales_idsucursales", referencedColumnName = "idsucursales")
    @ManyToOne(optional = false)
    private Sucursales sucursalesIdsucursales;

    public Productos() {
    }

    public Productos(Integer idproductos) {
        this.idproductos = idproductos;
    }

    public Integer getIdproductos() {
        return idproductos;
    }

    public void setIdproductos(Integer idproductos) {
        this.idproductos = idproductos;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    public Materiales getMaterialesIdmateriales() {
        return materialesIdmateriales;
    }

    public void setMaterialesIdmateriales(Materiales materialesIdmateriales) {
        this.materialesIdmateriales = materialesIdmateriales;
    }

    public Categorias getCategoriasIdcategorias() {
        return categoriasIdcategorias;
    }

    public void setCategoriasIdcategorias(Categorias categoriasIdcategorias) {
        this.categoriasIdcategorias = categoriasIdcategorias;
    }

    public Marcas getMarcasIdmarcas() {
        return marcasIdmarcas;
    }

    public void setMarcasIdmarcas(Marcas marcasIdmarcas) {
        this.marcasIdmarcas = marcasIdmarcas;
    }

    public Sucursales getSucursalesIdsucursales() {
        return sucursalesIdsucursales;
    }

    public void setSucursalesIdsucursales(Sucursales sucursalesIdsucursales) {
        this.sucursalesIdsucursales = sucursalesIdsucursales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproductos != null ? idproductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idproductos == null && other.idproductos != null) || (this.idproductos != null && !this.idproductos.equals(other.idproductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entidades.Productos[ idproductos=" + idproductos + " ]";
        return producto;
    }
    
}
