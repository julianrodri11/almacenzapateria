/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
@Table(name = "perfiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfiles.findAll", query = "SELECT p FROM Perfiles p"),
    @NamedQuery(name = "Perfiles.findByIdperfiles", query = "SELECT p FROM Perfiles p WHERE p.idperfiles = :idperfiles"),
    @NamedQuery(name = "Perfiles.findByPerfil", query = "SELECT p FROM Perfiles p WHERE p.perfil = :perfil"),
    @NamedQuery(name = "Perfiles.findByDescripcion", query = "SELECT p FROM Perfiles p WHERE p.descripcion = :descripcion")})
public class Perfiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperfiles")
    private Integer idperfiles;
    @Size(max = 45)
    @Column(name = "perfil")
    private String perfil;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false)
    private Usuarios usuariosIdusuarios;

    public Perfiles() {
    }

    public Perfiles(Integer idperfiles) {
        this.idperfiles = idperfiles;
    }

    public Integer getIdperfiles() {
        return idperfiles;
    }

    public void setIdperfiles(Integer idperfiles) {
        this.idperfiles = idperfiles;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idperfiles != null ? idperfiles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfiles)) {
            return false;
        }
        Perfiles other = (Perfiles) object;
        if ((this.idperfiles == null && other.idperfiles != null) || (this.idperfiles != null && !this.idperfiles.equals(other.idperfiles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "entidades.Perfiles[ idperfiles=" + idperfiles + " ]";
        return perfil;
    }
    
}
