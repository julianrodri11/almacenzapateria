/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JULIAN
 */
@Entity
@Table(name = "pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findByIdpago", query = "SELECT p FROM Pagos p WHERE p.idpago = :idpago"),
    @NamedQuery(name = "Pagos.findByNopagos", query = "SELECT p FROM Pagos p WHERE p.nopagos = :nopagos"),
    @NamedQuery(name = "Pagos.findByValorPagoCuota", query = "SELECT p FROM Pagos p WHERE p.valorPagoCuota = :valorPagoCuota"),
    @NamedQuery(name = "Pagos.findByFechaAPagar", query = "SELECT p FROM Pagos p WHERE p.fechaAPagar = :fechaAPagar"),
    @NamedQuery(name = "Pagos.findByHora", query = "SELECT p FROM Pagos p WHERE p.hora = :hora")})
public class Pagos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpago")
    private Integer idpago;
    @Column(name = "nopagos")
    private Integer nopagos;
    @Column(name = "valor_pago_cuota")
    private BigInteger valorPagoCuota;
    @Column(name = "fecha_a_pagar")
    @Temporal(TemporalType.DATE)
    private Date fechaAPagar;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "estadocuotas_idestadocuotas", referencedColumnName = "idestadocuotas")
    @ManyToOne(optional = false)
    private Estadocuotas estadocuotasIdestadocuotas;
    @JoinColumn(name = "facturas_idfacturas", referencedColumnName = "idfacturas")
    @ManyToOne(optional = false)
    private Facturas facturasIdfacturas;

    public Pagos() {
    }

    public Pagos(Integer idpago) {
        this.idpago = idpago;
    }

    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    public Integer getNopagos() {
        return nopagos;
    }

    public void setNopagos(Integer nopagos) {
        this.nopagos = nopagos;
    }

    public BigInteger getValorPagoCuota() {
        return valorPagoCuota;
    }

    public void setValorPagoCuota(BigInteger valorPagoCuota) {
        this.valorPagoCuota = valorPagoCuota;
    }

    public Date getFechaAPagar() {
        return fechaAPagar;
    }

    public void setFechaAPagar(Date fechaAPagar) {
        this.fechaAPagar = fechaAPagar;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Estadocuotas getEstadocuotasIdestadocuotas() {
        return estadocuotasIdestadocuotas;
    }

    public void setEstadocuotasIdestadocuotas(Estadocuotas estadocuotasIdestadocuotas) {
        this.estadocuotasIdestadocuotas = estadocuotasIdestadocuotas;
    }

    public Facturas getFacturasIdfacturas() {
        return facturasIdfacturas;
    }

    public void setFacturasIdfacturas(Facturas facturasIdfacturas) {
        this.facturasIdfacturas = facturasIdfacturas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pagos[ idpago=" + idpago + " ]";
    }
    
}
