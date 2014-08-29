/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.dao.imp;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author davi
 */
public class ImpSuite extends TestCase {
    
    public ImpSuite(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("ImpSuite");
        //suite.addTest(VotliDaoImpTest.suite());
        //suite.addTest(UsuarDaoImpTest.suite());
        suite.addTest(GenericoDaoImpTest.suite());
        //suite.addTest(VotadosDaoImpTest.suite());
        //suite.addTest(LivroDaoImpTest.suite());
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
}
