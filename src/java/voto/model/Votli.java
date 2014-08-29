/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package voto.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Davi Souza
 */
@Entity
@Table(name = "votli")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Votli.findAll", query = "SELECT v FROM Votli v"),
//    @NamedQuery(name = "Votli.findByCdUsuar", query = "SELECT v FROM Votli v WHERE v.votliPK.cdUsuar = :cdUsuar"),
//    @NamedQuery(name = "Votli.findByCdLivro", query = "SELECT v FROM Votli v WHERE v.votliPK.cdLivro = :cdLivro"),
//    @NamedQuery(name = "Votli.findByContVoto", query = "SELECT v FROM Votli v WHERE v.contVoto = :contVoto")})
public class Votli implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VotliPK votliPK;
//    @Basic(optional = false)
//    @Column(name = "cont_voto")
//    private int contVoto;
    @JoinColumn(name = "cd_usuar", referencedColumnName = "cd_usuar", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuar usuar;
    @JoinColumn(name = "cd_livro", referencedColumnName = "cd_livro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Livro livro;

    public Votli() {
    }

    public Votli(VotliPK votliPK) {
        this.votliPK = votliPK;
    }

//    public Votli(VotliPK votliPK, int contVoto) {
//        this.votliPK = votliPK;
//        this.contVoto = contVoto;
//    }

    public Votli(int cdUsuar, int cdLivro) {
        this.votliPK = new VotliPK(cdUsuar, cdLivro);
    }

    public VotliPK getVotliPK() {
        return votliPK;
    }

    public void setVotliPK(VotliPK votliPK) {
        this.votliPK = votliPK;
    }

//    public int getContVoto() {
//        return contVoto;
//    }
//
//    public void setContVoto(int contVoto) {
//        this.contVoto = contVoto;
//    }

    public Usuar getUsuar() {
        return usuar;
    }

    public void setUsuar(Usuar usuar) {
        this.usuar = usuar;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (votliPK != null ? votliPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Votli)) {
            return false;
        }
        Votli other = (Votli) object;
        if ((this.votliPK == null && other.votliPK != null) || (this.votliPK != null && !this.votliPK.equals(other.votliPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vote.Votli[ votliPK=" + votliPK + " ]";
    }
    
}
