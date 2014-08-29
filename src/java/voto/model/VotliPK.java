/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package voto.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Davi Souza
 */
@Embeddable
public class VotliPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cd_usuar")
    private int cdUsuar;
    @Basic(optional = false)
    @Column(name = "cd_livro")
    private int cdLivro;

    public VotliPK() {
    }

    public VotliPK(int cdUsuar, int cdLivro) {
        this.cdUsuar = cdUsuar;
        this.cdLivro = cdLivro;
    }

    public int getCdUsuar() {
        return cdUsuar;
    }

    public void setCdUsuar(int cdUsuar) {
        this.cdUsuar = cdUsuar;
    }

    public int getCdLivro() {
        return cdLivro;
    }

    public void setCdLivro(int cdLivro) {
        this.cdLivro = cdLivro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cdUsuar;
        hash += (int) cdLivro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VotliPK)) {
            return false;
        }
        VotliPK other = (VotliPK) object;
        if (this.cdUsuar != other.cdUsuar) {
            return false;
        }
        if (this.cdLivro != other.cdLivro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vote.VotliPK[ cdUsuar=" + cdUsuar + ", cdLivro=" + cdLivro + " ]";
    }
    
}
