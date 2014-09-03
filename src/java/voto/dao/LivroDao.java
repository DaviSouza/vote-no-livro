/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.dao;

import java.sql.SQLException;
import voto.model.Livro;

/**
 *
 * @author Davi Souza
 */
public interface LivroDao extends GenericoDao<Livro, Integer> {

    public void deleteInVotli(Integer cd_livro) throws SQLException;
}
