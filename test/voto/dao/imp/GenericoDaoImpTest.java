/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.dao.imp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;
import org.hibernate.Transaction;
import voto.model.Livro;
import voto.model.Usuar;
import voto.util.HibernateUtil;

/**
 *
 * @author davi
 */
public class GenericoDaoImpTest extends TestCase {
    
    public GenericoDaoImpTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(GenericoDaoImpTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of releaseSession method, of class GenericoDaoImp.
     */
    public void testReleaseSession() {
        System.out.println("releaseSession");
        Session session = HibernateUtil.getSession();
        GenericoDaoImp instance = new GenericoDaoImp();
        instance.releaseSession(session);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of releaseRollback method, of class GenericoDaoImp.
     */
    public void testReleaseRollback_Transaction() {
        System.out.println("releaseRollback");   
        Transaction tx = HibernateUtil.getSession().getTransaction();
        GenericoDaoImp instance = new GenericoDaoImp();
        instance.releaseRollback(tx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of releaseRollback method, of class GenericoDaoImp.
     */
    public void testReleaseRollback_Session() {
        System.out.println("releaseRollback");
        Session session = HibernateUtil.getSession();
        GenericoDaoImp instance = new GenericoDaoImp();
        instance.releaseRollback(session);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOrSave method, of class GenericoDaoImp.
     */
    public void testUpdateOrSave() {
        System.out.println("updateOrSave");
        Object object = new Usuar(3, "Usuario 3", "usuar3@gmail.com");
        GenericoDaoImp instance = new GenericoDaoImp();
        //Object expResult = null;
        instance.updateOrSave(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class GenericoDaoImp.
     */
    public void testExcluir() {
        System.out.println("excluir");
        Object object = new Usuar(3, "Usuario 3", "usuar3@gmail.com");
        GenericoDaoImp instance = new GenericoDaoImp();
        instance.excluir(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of totalRegistros method, of class GenericoDaoImp.
     */
    public void testTotalRegistros() {
        System.out.println("totalRegistros");
        GenericoDaoImp instance = new GenericoDaoImp();
        Integer expResult = 2;
        Integer result = instance.totalRegistros(Usuar.class);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of todos method, of class GenericoDaoImp.
     */
    public void testTodos() {
        System.out.println("todos");
        GenericoDaoImp instance = new GenericoDaoImp();
        List<Usuar> expResult = new ArrayList<Usuar>();
        expResult.add(new Usuar(1, "Usuario 1", "usuar1@gmail.com"));
        expResult.add(new Usuar(2, "Usuario 2", "usuar2@gmail.com"));
        List result = instance.todos(Usuar.class);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class GenericoDaoImp.
     */
    public void testGetById() {
        System.out.println("getById");
        GenericoDaoImp instance = new GenericoDaoImp();
        Object expResult = new Livro(4,"Senhor dos Anéis, O - A sociedade do anel - Vol.I",
                "Numa cidadezinha indolente do Condado, um jovem hobbit é encarregado de uma imensa tarefa.","lori.jpg");
        Object result = instance.getById(Livro.class,4);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxValue method, of class GenericoDaoImp.
     */
    public void testGetMaxValue() {
        System.out.println("getMaxValue");
        GenericoDaoImp instance = new GenericoDaoImp();
        Object expResult = 5;
        Object result = instance.getMaxValue(Livro.class);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListQuery method, of class GenericoDaoImp.
     */
    public void testGetListQuery() {
        System.out.println("getListQuery");
        String sql = "";
        GenericoDaoImp instance = new GenericoDaoImp();
        List expResult = null;
        List result = instance.getListQuery(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConnection method, of class GenericoDaoImp.
     */
    public void testGetConnection() {
        System.out.println("getConnection");
        String sql = "Select * from Livro";
        GenericoDaoImp instance = new GenericoDaoImp();
        Connection expResult = HibernateUtil.getSession().connection();
        Connection result = instance.getConnection(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listUser method, of class GenericoDaoImp.
     */
    public void testListUser() {
        System.out.println("listUser");
        GenericoDaoImp instance = new GenericoDaoImp();
        List expResult = null;
        List result = instance.listUser(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listPesqParam method, of class GenericoDaoImp.
     */
    public void testListPesqParam_String_Map() {
        System.out.println("listPesqParam");
        String query = "";
        Map<String, Object> params = null;
        GenericoDaoImp instance = new GenericoDaoImp();
        List expResult = null;
        List result = instance.listPesqParam(query, params);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listPesqParam method, of class GenericoDaoImp.
     */
    public void testListPesqParam_4args() {
        System.out.println("listPesqParam");
        String query = "";
        Map<String, Object> params = null;
        int maximo = 0;
        int atual = 0;
        GenericoDaoImp instance = new GenericoDaoImp();
        List expResult = null;
        List result = instance.listPesqParam(query, params, maximo, atual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
