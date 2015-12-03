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
@Table(name = "ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudades.findAll", query = "SELECT c FROM Ciudades c"),
    @NamedQuery(name = "Ciudades.findByIdciudades", query = "SELECT c FROM Ciudades c WHERE c.idciudades = :idciudades"),
    @NamedQuery(name = "Ciudades.findByCiudad", query = "SELECT c FROM Ciudades c WHERE c.ciudad = :ciudad")})
public class Ciudades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idciudades")
    private Integer idciudades;
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadesIdciudades")
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadesIdciudades")
    private Collection<Sucursales> sucursalesCollection;
    @JoinColumn(name = "departamentos_iddepartamentos", referencedColumnName = "iddepartamentos")
    @ManyToOne(optional = false)
    private Departamentos departamentosIddepartamentos;

    public Ciudades() {
    }

    public Ciudades(Integer idciudades) {
        this.idciudades = idciudades;
    }

    public Integer getIdciudades() {
        return idciudades;
    }

    public void setIdciudades(Integer idciudades) {
        this.idciudades = idciudades;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @XmlTransient
    public Collection<Sucursales> getSucursalesCollection() {
        return sucursalesCollection;
    }

    public void setSucursalesCollection(Collection<Sucursales> sucursalesCollection) {
        this.sucursalesCollection = sucursalesCollection;
    }

    public Departamentos getDepartamentosIddepartamentos() {
        return departamentosIddepartamentos;
    }

    public void setDepartamentosIddepartamentos(Departamentos departamentosIddepartamentos) {
        this.departamentosIddepartamentos = departamentosIddepartamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idciudades != null ? idciudades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudades)) {
            return false;
        }
        Ciudades other = (Ciudades) object;
        if ((this.idciudades == null && other.idciudades != null) || (this.idciudades != null && !this.idciudades.equals(other.idciudades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    //    return "entidades.Ciudades[ idciudades=" + idciudades + " ]";
          return ciudad;
    }
    
}
