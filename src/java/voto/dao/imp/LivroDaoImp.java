/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.dao.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import voto.dao.LivroDao;
import voto.model.Livro;

/**
 *
 * @author Davi Souza
 */
public class LivroDaoImp extends GenericoDaoImp<Livro, Integer> implements LivroDao {

    @Override
    public void deleteInVotli(Integer cd_livro) throws SQLException {
        String sql = "delete FROM votli where cd_livro = " + cd_livro;
        Connection con = getConnection(sql);
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
        con.close();
    }
}
