/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import voto.dao.VotliDao;
import voto.model.Votli;

/**
 *
 * @author Davi Souza
 */
public class VotliDaoImp extends GenericoDaoImp<Votli, Integer> implements VotliDao {

    private Connection con;
    Statement stmt;

    @Override
    public ResultSet getMoreVoted() throws SQLException {
        String sql = "select distinct livro.cd_livro, livro.nm_livro as nome, livro.nl_livro as url,"
                + "(SELECT COUNT(e.cd_livro) FROM votli e where e.cd_livro = livro.cd_livro) as votos "
                + "from livro, votli where votli.cd_livro = livro.cd_livro";
        con = new VotadosDaoImp().getConnection(sql);
        stmt = con.createStatement();
        return stmt.executeQuery(sql);
    }

    @Override
    public void closeConnections() throws SQLException {
        stmt.close();
        con.close();
    }
}
