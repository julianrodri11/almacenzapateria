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
@Table(name = "estadocuotas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadocuotas.findAll", query = "SELECT e FROM Estadocuotas e"),
    @NamedQuery(name = "Estadocuotas.findByIdestadocuotas", query = "SELECT e FROM Estadocuotas e WHERE e.idestadocuotas = :idestadocuotas"),
    @NamedQuery(name = "Estadocuotas.findByNombreEstCuota", query = "SELECT e FROM Estadocuotas e WHERE e.nombreEstCuota = :nombreEstCuota"),
    @NamedQuery(name = "Estadocuotas.findByDescripcion", query = "SELECT e FROM Estadocuotas e WHERE e.descripcion = :descripcion")})
public class Estadocuotas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestadocuotas")
    private Integer idestadocuotas;
    @Size(max = 45)
    @Column(name = "nombre_est_cuota")
    private String nombreEstCuota;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadocuotasIdestadocuotas")
    private Collection<Pagos> pagosCollection;

    public Estadocuotas() {
    }

    public Estadocuotas(Integer idestadocuotas) {
        this.idestadocuotas = idestadocuotas;
    }

    public Integer getIdestadocuotas() {
        return idestadocuotas;
    }

    public void setIdestadocuotas(Integer idestadocuotas) {
        this.idestadocuotas = idestadocuotas;
    }

    public String getNombreEstCuota() {
        return nombreEstCuota;
    }

    public void setNombreEstCuota(String nombreEstCuota) {
        this.nombreEstCuota = nombreEstCuota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idestadocuotas != null ? idestadocuotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadocuotas)) {
            return false;
        }
        Estadocuotas other = (Estadocuotas) object;
        if ((this.idestadocuotas == null && other.idestadocuotas != null) || (this.idestadocuotas != null && !this.idestadocuotas.equals(other.idestadocuotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "entidades.Estadocuotas[ idestadocuotas=" + idestadocuotas + " ]";
        return nombreEstCuota;
    }
    
}
