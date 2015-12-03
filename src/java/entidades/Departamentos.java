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
@Table(name = "departamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByIddepartamentos", query = "SELECT d FROM Departamentos d WHERE d.iddepartamentos = :iddepartamentos"),
    @NamedQuery(name = "Departamentos.findByDepartamento", query = "SELECT d FROM Departamentos d WHERE d.departamento = :departamento")})
public class Departamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddepartamentos")
    private Integer iddepartamentos;
    @Size(max = 45)
    @Column(name = "departamento")
    private String departamento;
    @JoinColumn(name = "paises_idpaises", referencedColumnName = "idpaises")
    @ManyToOne(optional = false)
    private Paises paisesIdpaises;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentosIddepartamentos")
    private Collection<Ciudades> ciudadesCollection;

    public Departamentos() {
    }

    public Departamentos(Integer iddepartamentos) {
        this.iddepartamentos = iddepartamentos;
    }

    public Integer getIddepartamentos() {
        return iddepartamentos;
    }

    public void setIddepartamentos(Integer iddepartamentos) {
        this.iddepartamentos = iddepartamentos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Paises getPaisesIdpaises() {
        return paisesIdpaises;
    }

    public void setPaisesIdpaises(Paises paisesIdpaises) {
        this.paisesIdpaises = paisesIdpaises;
    }

    @XmlTransient
    public Collection<Ciudades> getCiudadesCollection() {
        return ciudadesCollection;
    }

    public void setCiudadesCollection(Collection<Ciudades> ciudadesCollection) {
        this.ciudadesCollection = ciudadesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepartamentos != null ? iddepartamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.iddepartamentos == null && other.iddepartamentos != null) || (this.iddepartamentos != null && !this.iddepartamentos.equals(other.iddepartamentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entidades.Departamentos[ iddepartamentos=" + iddepartamentos + " ]";
        return departamento;
    }
    
}
