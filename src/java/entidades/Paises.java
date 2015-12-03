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
@Table(name = "paises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p"),
    @NamedQuery(name = "Paises.findByIdpaises", query = "SELECT p FROM Paises p WHERE p.idpaises = :idpaises"),
    @NamedQuery(name = "Paises.findByPais", query = "SELECT p FROM Paises p WHERE p.pais = :pais")})
public class Paises implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpaises")
    private Integer idpaises;
    @Size(max = 45)
    @Column(name = "pais")
    private String pais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paisesIdpaises")
    private Collection<Departamentos> departamentosCollection;

    public Paises() {
    }

    public Paises(Integer idpaises) {
        this.idpaises = idpaises;
    }

    public Integer getIdpaises() {
        return idpaises;
    }

    public void setIdpaises(Integer idpaises) {
        this.idpaises = idpaises;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @XmlTransient
    public Collection<Departamentos> getDepartamentosCollection() {
        return departamentosCollection;
    }

    public void setDepartamentosCollection(Collection<Departamentos> departamentosCollection) {
        this.departamentosCollection = departamentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaises != null ? idpaises.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.idpaises == null && other.idpaises != null) || (this.idpaises != null && !this.idpaises.equals(other.idpaises))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entidades.Paises[ idpaises=" + idpaises + " ]";
        return pais;
    }
    
}
