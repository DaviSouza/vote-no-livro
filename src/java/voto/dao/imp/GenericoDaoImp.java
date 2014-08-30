/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.dao.imp;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import voto.dao.GenericoDao;
import voto.model.Livro;
import voto.model.Usuar;
import voto.util.CriterioOrdenacao;
import voto.util.HibernateUtil;

/**
 *
 * @author Davi Souza
 */
public class GenericoDaoImp<T, ID extends Serializable> implements GenericoDao<T, ID> {

    private static final Log log = LogFactory.getLog(GenericoDaoImp.class);

    protected void releaseSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    protected void releaseRollback(Transaction tx) {
        if (tx != null) {
            tx.rollback();
        }
    }

    protected void releaseRollback(Session session) {
        if (session != null) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public T updateOrSave(T object) {
        Session session = null;
        try {
            session = (Session) HibernateUtil.getSession();
            session.beginTransaction();
            session.saveOrUpdate(object);
            session.getTransaction().commit();
            return object;
        } catch (RuntimeException e) {
            releaseRollback(session);
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            releaseSession(session);
        }
    }

    @Override
    public void excluir(T object) {
        Session session = (Session) HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            releaseRollback(session);
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            releaseSession(session);
        }
    }

    @Override
    public Integer totalRegistros(Class<T> t) {
        Integer resultado = 0;
        Session session = (Session) HibernateUtil.getSession();

        try {
            session.beginTransaction();
            final Criteria criteria = session.createCriteria(t);
            resultado = criteria.list().size();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            releaseSession(session);
        }

        return resultado;
    }

    @Override
    public List<T> todos(Class<T> t, CriterioOrdenacao... criterios) {
        List<T> resultado = new ArrayList<T>();
        Session session = (Session) HibernateUtil.getSession();

        try {
            session.beginTransaction();
            final Criteria criteria = session.createCriteria(t);
            if (criterios != null) {
                for (CriterioOrdenacao ordenacao : criterios) {
                    final String propriedade = ordenacao.getPropriedade();
                    final boolean ascendente = ordenacao.isAscendente();
                    criteria.addOrder(ascendente ? Order.asc(propriedade) : Order.desc(propriedade));
                }
            }
            resultado = criteria.list();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            releaseSession(session);
        }

        return resultado;
    }

    @Override
    public T getById(Class<T> t, int id) {
        T resultado;
        Session session = (Session) HibernateUtil.getSession();

        try {
            session.beginTransaction();
            final Criteria criteria = session.createCriteria(t);
            resultado = (T) criteria.add(Restrictions.idEq(id)).uniqueResult();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            releaseSession(session);
        }
        return resultado;
    }

    @Override
    public T getMaxValue(Class<T> t) {
        T resultado;
        Session session = (Session) HibernateUtil.getSession();
        try {
            session.beginTransaction();
            final Criteria criteria = session.createCriteria(t);
            resultado = (T) criteria.addOrder(Order.desc("cd" + t.getSimpleName())).setMaxResults(1).uniqueResult();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            releaseSession(session);
        }
        return resultado;
    }

    public Usuar getByCpfAndUsuario(String nome, int cpf) throws Exception {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            final Criteria query = session.createCriteria(Usuar.class)
                    .add(Restrictions.eq("user_name", nome))
                    .createCriteria("user_cpf")
                    .add(Restrictions.idEq(cpf));

            final Usuar usuario = (Usuar) query.uniqueResult();
            session.getTransaction().commit();

            return usuario;
        } catch (Exception e) {
            releaseRollback(session);
            log.error(e.getMessage(), e);
            throw new Exception("Ocorreu um erro durante a pesquisa por pessoa", e);
        } finally {
            releaseSession(session);
        }
    }

    @Override
    public List getListQuery(String sql) {
        List resultado = new ArrayList<T>();
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Livro.class);
            resultado = query.list();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            releaseSession(session);
        }

        return resultado;
    }

    @Override
    public Connection getConnection(String sql) {
        String url = "jdbc:mysql://localhost:3306/desafio_db";
        Connection con;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try {
            con = DriverManager.getConnection(url,"root", "1234");
            return con;
        } catch (SQLException ex) {
            System.err.print("SQLException: ");
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<T> listUser(Class<T> t) {
        List<T> resultado = new ArrayList<T>();
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            final Criteria criteria = session.createCriteria(t);
            criteria.addOrder(Order.asc("nome"));
            resultado = criteria.list();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            releaseSession(session);
        }

        return resultado;
    }

    public List<T> listPesqParam(String query, Map<String, Object> params) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> listPesqParam(String query, Map<String, Object> params, int maximo, int atual) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
