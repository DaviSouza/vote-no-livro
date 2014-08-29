/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package voto.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Davi Souza
 */
@Entity
@Table(name = "livro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l"),
    @NamedQuery(name = "Livro.findByCdLivro", query = "SELECT l FROM Livro l WHERE l.cdLivro = :cdLivro"),
    @NamedQuery(name = "Livro.findByNmLivro", query = "SELECT l FROM Livro l WHERE l.nmLivro = :nmLivro"),
    @NamedQuery(name = "Livro.findByTxLivro", query = "SELECT l FROM Livro l WHERE l.txLivro = :txLivro"),
    @NamedQuery(name = "Livro.findByNlLivro", query = "SELECT l FROM Livro l WHERE l.nlLivro = :nlLivro")})
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_livro")
    private Integer cdLivro;
    @Basic(optional = false)
    @Column(name = "nm_livro")
    private String nmLivro;
    @Basic(optional = false)
    @Column(name = "tx_livro")
    private String txLivro;
    @Basic(optional = false)
    @Column(name = "nl_livro")
    private String nlLivro;
    @Transient
    private String urlImage;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
    
    public Livro() {
    }

    public Livro(Integer cdLivro) {
        this.cdLivro = cdLivro;
    }

    public Livro(Integer cdLivro, String nmLivro, String txLivro, String nlLivro) {
        this.cdLivro = cdLivro;
        this.nmLivro = nmLivro;
        this.txLivro = txLivro;
        this.nlLivro = nlLivro;
    }

    public Integer getCdLivro() {
        return cdLivro;
    }

    public void setCdLivro(Integer cdLivro) {
        this.cdLivro = cdLivro;
    }

    public String getNmLivro() {
        return nmLivro;
    }

    public void setNmLivro(String nmLivro) {
        this.nmLivro = nmLivro;
    }

    public String getTxLivro() {
        return txLivro;
    }

    public void setTxLivro(String txLivro) {
        this.txLivro = txLivro;
    }

    public String getNlLivro() {
        return nlLivro;
    }

    public void setNlLivro(String nlLivro) {
        this.nlLivro = nlLivro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdLivro != null ? cdLivro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.cdLivro == null && other.cdLivro != null) || (this.cdLivro != null && !this.cdLivro.equals(other.cdLivro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "voto.model.Livro[ cdLivro=" + cdLivro + " ]";
    }
    
}
