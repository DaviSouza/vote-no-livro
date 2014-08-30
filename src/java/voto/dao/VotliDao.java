/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import voto.model.Votli;

/**
 *
 * @author Davi Souza
 */
public interface VotliDao extends GenericoDao<Votli, Integer> {

    public ResultSet getMoreVoted() throws SQLException;

    public void closeConnections() throws SQLException;
}
