/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.dao.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import voto.dao.UsuarDao;
import voto.model.Usuar;

/**
 *
 * @author Davi Souza
 */
public class UsuarDaoImp extends GenericoDaoImp<Usuar, Integer> implements UsuarDao {

    @Override
    public void deleteInVotli(Integer cd_usuar) throws SQLException {
        String sql = "delete FROM votli where cd_livro = " + cd_usuar;
        Connection con = getConnection(sql);
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        stmt.close();
        con.close();
    }
}
