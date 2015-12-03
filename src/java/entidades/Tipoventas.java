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
@Table(name = "tipoventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoventas.findAll", query = "SELECT t FROM Tipoventas t"),
    @NamedQuery(name = "Tipoventas.findByIdtipoventas", query = "SELECT t FROM Tipoventas t WHERE t.idtipoventas = :idtipoventas"),
    @NamedQuery(name = "Tipoventas.findByTipoVenta", query = "SELECT t FROM Tipoventas t WHERE t.tipoVenta = :tipoVenta"),
    @NamedQuery(name = "Tipoventas.findByDescripcion", query = "SELECT t FROM Tipoventas t WHERE t.descripcion = :descripcion")})
public class Tipoventas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipoventas")
    private Integer idtipoventas;
    @Size(max = 45)
    @Column(name = "tipo_venta")
    private String tipoVenta;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoventasIdtipoventas")
    private Collection<Facturas> facturasCollection;

    public Tipoventas() {
    }

    public Tipoventas(Integer idtipoventas) {
        this.idtipoventas = idtipoventas;
    }

    public Integer getIdtipoventas() {
        return idtipoventas;
    }

    public void setIdtipoventas(Integer idtipoventas) {
        this.idtipoventas = idtipoventas;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Facturas> getFacturasCollection() {
        return facturasCollection;
    }

    public void setFacturasCollection(Collection<Facturas> facturasCollection) {
        this.facturasCollection = facturasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoventas != null ? idtipoventas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoventas)) {
            return false;
        }
        Tipoventas other = (Tipoventas) object;
        if ((this.idtipoventas == null && other.idtipoventas != null) || (this.idtipoventas != null && !this.idtipoventas.equals(other.idtipoventas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entidades.Tipoventas[ idtipoventas=" + idtipoventas + " ]";
        return tipoVenta;
        
    }
    
}
