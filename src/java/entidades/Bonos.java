/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JULIAN
 */
@Entity
@Table(name = "bonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bonos.findAll", query = "SELECT b FROM Bonos b"),
    @NamedQuery(name = "Bonos.findByIdbonos", query = "SELECT b FROM Bonos b WHERE b.idbonos = :idbonos"),
    @NamedQuery(name = "Bonos.findByNombreBono", query = "SELECT b FROM Bonos b WHERE b.nombreBono = :nombreBono"),
    @NamedQuery(name = "Bonos.findByValor", query = "SELECT b FROM Bonos b WHERE b.valor = :valor")})
public class Bonos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbonos")
    private Integer idbonos;
    @Size(max = 45)
    @Column(name = "nombre_bono")
    private String nombreBono;
    @Column(name = "valor")
    private BigInteger valor;
    @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false)
    private Usuarios usuariosIdusuarios;

    public Bonos() {
    }

    public Bonos(Integer idbonos) {
        this.idbonos = idbonos;
    }

    public Integer getIdbonos() {
        return idbonos;
    }

    public void setIdbonos(Integer idbonos) {
        this.idbonos = idbonos;
    }

    public String getNombreBono() {
        return nombreBono;
    }

    public void setNombreBono(String nombreBono) {
        this.nombreBono = nombreBono;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public Usuarios getUsuariosIdusuarios() {
        return usuariosIdusuarios;
    }

    public void setUsuariosIdusuarios(Usuarios usuariosIdusuarios) {
        this.usuariosIdusuarios = usuariosIdusuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbonos != null ? idbonos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bonos)) {
            return false;
        }
        Bonos other = (Bonos) object;
        if ((this.idbonos == null && other.idbonos != null) || (this.idbonos != null && !this.idbonos.equals(other.idbonos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Bonos[ idbonos=" + idbonos + " ]";
    }
    
}
