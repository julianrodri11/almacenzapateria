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
@Table(name = "cajas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cajas.findAll", query = "SELECT c FROM Cajas c"),
    @NamedQuery(name = "Cajas.findByIdcajas", query = "SELECT c FROM Cajas c WHERE c.idcajas = :idcajas"),
    @NamedQuery(name = "Cajas.findByCaja", query = "SELECT c FROM Cajas c WHERE c.caja = :caja")})
public class Cajas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcajas")
    private Integer idcajas;
    @Size(max = 45)
    @Column(name = "caja")
    private String caja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajasIdcajas")
    private Collection<Facturas> facturasCollection;
    @JoinColumn(name = "sucursales_idsucursales", referencedColumnName = "idsucursales")
    @ManyToOne(optional = false)
    private Sucursales sucursalesIdsucursales;

    public Cajas() {
    }

    public Cajas(Integer idcajas) {
        this.idcajas = idcajas;
    }

    public Integer getIdcajas() {
        return idcajas;
    }

    public void setIdcajas(Integer idcajas) {
        this.idcajas = idcajas;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    @XmlTransient
    public Collection<Facturas> getFacturasCollection() {
        return facturasCollection;
    }

    public void setFacturasCollection(Collection<Facturas> facturasCollection) {
        this.facturasCollection = facturasCollection;
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
        hash += (idcajas != null ? idcajas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cajas)) {
            return false;
        }
        Cajas other = (Cajas) object;
        if ((this.idcajas == null && other.idcajas != null) || (this.idcajas != null && !this.idcajas.equals(other.idcajas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "entidades.Cajas[ idcajas=" + idcajas + " ]";
        return caja+" - "+sucursalesIdsucursales;
    }
    
}
