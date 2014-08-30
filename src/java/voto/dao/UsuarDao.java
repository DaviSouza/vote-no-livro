/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.dao;

import java.sql.SQLException;
import voto.model.Usuar;

/**
 *
 * @author Davi Souza
 */
public interface UsuarDao extends GenericoDao<Usuar, Integer> {

    public void deleteInVotli(Integer cd_usuar) throws SQLException;
}
