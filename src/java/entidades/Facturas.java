/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JULIAN
 */
@Entity
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f"),
    @NamedQuery(name = "Facturas.findByIdfacturas", query = "SELECT f FROM Facturas f WHERE f.idfacturas = :idfacturas"),
    @NamedQuery(name = "Facturas.findByFecha", query = "SELECT f FROM Facturas f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Facturas.findByHora", query = "SELECT f FROM Facturas f WHERE f.hora = :hora")})
public class Facturas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfacturas")
    private Integer idfacturas;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "tipoventas_idtipoventas", referencedColumnName = "idtipoventas")
    @ManyToOne(optional = false)
    private Tipoventas tipoventasIdtipoventas;
    @JoinColumn(name = "cliente_idusuarios", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false)
    private Usuarios clienteIdusuarios;
    @JoinColumn(name = "cajero_idusuarios", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false)
    private Usuarios cajeroIdusuarios;
    @JoinColumn(name = "cajas_idcajas", referencedColumnName = "idcajas")
    @ManyToOne(optional = false)
    private Cajas cajasIdcajas;
    @JoinColumn(name = "ventas_idventas", referencedColumnName = "idventas")
    @ManyToOne(optional = false)
    private Ventas ventasIdventas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturasIdfacturas")
    private Collection<Pagos> pagosCollection;

    public Facturas() {
    }

    public Facturas(Integer idfacturas) {
        this.idfacturas = idfacturas;
    }

    public Integer getIdfacturas() {
        return idfacturas;
    }

    public void setIdfacturas(Integer idfacturas) {
        this.idfacturas = idfacturas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Tipoventas getTipoventasIdtipoventas() {
        return tipoventasIdtipoventas;
    }

    public void setTipoventasIdtipoventas(Tipoventas tipoventasIdtipoventas) {
        this.tipoventasIdtipoventas = tipoventasIdtipoventas;
    }

    public Usuarios getClienteIdusuarios() {
        return clienteIdusuarios;
    }

    public void setClienteIdusuarios(Usuarios clienteIdusuarios) {
        this.clienteIdusuarios = clienteIdusuarios;
    }

    public Usuarios getCajeroIdusuarios() {
        return cajeroIdusuarios;
    }

    public void setCajeroIdusuarios(Usuarios cajeroIdusuarios) {
        this.cajeroIdusuarios = cajeroIdusuarios;
    }

    public Cajas getCajasIdcajas() {
        return cajasIdcajas;
    }

    public void setCajasIdcajas(Cajas cajasIdcajas) {
        this.cajasIdcajas = cajasIdcajas;
    }

    public Ventas getVentasIdventas() {
        return ventasIdventas;
    }

    public void setVentasIdventas(Ventas ventasIdventas) {
        this.ventasIdventas = ventasIdventas;
    }

    @XmlTransient
    public Collection<Pagos> getPagosCollection() {
        return pagosCollection;
    }

    public void setPagosCollection(Collection<Pagos> pagosCollection) {
        this.pagosCollection = pagosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacturas != null ? idfacturas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.idfacturas == null && other.idfacturas != null) || (this.idfacturas != null && !this.idfacturas.equals(other.idfacturas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura No: " + idfacturas+" No Venta :"+ventasIdventas;
    }
    
}
