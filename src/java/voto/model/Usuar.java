/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package voto.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Davi Souza
 */
@Entity
@Table(name = "usuar")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Usuar.findAll", query = "SELECT u FROM Usuar u"),
//    @NamedQuery(name = "Usuar.findByCdUsuar", query = "SELECT u FROM Usuar u WHERE u.cdUsuar = :cdUsuar"),
//    @NamedQuery(name = "Usuar.findByNmUsuar", query = "SELECT u FROM Usuar u WHERE u.nmUsuar = :nmUsuar"),
//    @NamedQuery(name = "Usuar.findByEmUsuar", query = "SELECT u FROM Usuar u WHERE u.emUsuar = :emUsuar")})
public class Usuar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_usuar", unique = true, nullable = false)
    private Integer cdUsuar;
    @Basic(optional = false)
    @Column(name = "nm_usuar")
    private String nmUsuar;
    @Basic(optional = false)
    @Column(name = "em_usuar")
    private String emUsuar;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuar")
//    private Collection<Votli> votliCollection;

    public Usuar() {
    }

    public Usuar(Integer cdUsuar) {
        this.cdUsuar = cdUsuar;
    }

    public Usuar(Integer cdUsuar, String nmUsuar, String emUsuar) {
        this.cdUsuar = cdUsuar;
        this.nmUsuar = nmUsuar;
        this.emUsuar = emUsuar;
    }

    public Integer getCdUsuar() {
        return cdUsuar;
    }

    public void setCdUsuar(Integer cdUsuar) {
        this.cdUsuar = cdUsuar;
    }

    public String getNmUsuar() {
        return nmUsuar;
    }

    public void setNmUsuar(String nmUsuar) {
        this.nmUsuar = nmUsuar;
    }

    public String getEmUsuar() {
        return emUsuar;
    }

    public void setEmUsuar(String emUsuar) {
        this.emUsuar = emUsuar;
    }

//    @XmlTransient
//    public Collection<Votli> getVotliCollection() {
//        return votliCollection;
//    }
//
//    public void setVotliCollection(Collection<Votli> votliCollection) {
//        this.votliCollection = votliCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdUsuar != null ? cdUsuar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuar)) {
            return false;
        }
        Usuar other = (Usuar) object;
        if ((this.cdUsuar == null && other.cdUsuar != null) || (this.cdUsuar != null && !this.cdUsuar.equals(other.cdUsuar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vote.Usuar[ cdUsuar=" + cdUsuar + " ]";
    }
    
}
