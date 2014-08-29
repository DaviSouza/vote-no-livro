/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import voto.util.CriterioOrdenacao;

/**
 *
 * @author adaoce.souza
 */
public interface GenericoDao<T, ID extends Serializable> {

    public T updateOrSave(T object);
    public void excluir(T object);
    public List<T> todos(Class<T> t, CriterioOrdenacao... criterios);
    public List<T> listPesqParam(String query, Map<String, Object> params);
    public List<T> listPesqParam(String query, Map<String, Object> params, int maximo, int atual);
    public T getById(Class<T> t, int id);
    public List<T> listUser(Class<T> t);
    public T getMaxValue(Class<T> t);
    public List getListQuery(String sql);
    public Integer totalRegistros(Class<T> t);
    public Connection getConnection(String sql);
    
}
