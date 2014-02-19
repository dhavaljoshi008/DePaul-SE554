/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.depaul.cdm.se.account.service.ejb;

import edu.depaul.cdm.se.account.service.AccountServiceRemote;
import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usza7o0
 */
public class AccountServiceTest {
    
    public AccountServiceTest() {
    }
    
    private static EJBContainer ec;
    private static Context ctx;
    
    @BeforeClass
    public static void setUp() {
        Properties props = new Properties();
        props.put(EJBContainer.MODULES, new File("target/classes"));

        ec = EJBContainer.createEJBContainer(props);

        // ec = EJBContainer.createEJBContainer();
        ctx = ec.getContext();
    }

    @AfterClass
    public static void tearDown() {
        if (ec != null) {
            try {
                ctx.close();
                ctx = null;
            } catch (NamingException ex) {
                Logger.getLogger(AccountServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            ec.close();
            ec = null;
        }

    }
    
    /**
     * Test of openAccount method, of class AccountService.
     */
    @org.junit.Test
    public void testOpenAccount() throws Exception {
        String name = "Dave";
        float initialBalance = 100.0F;
        AccountServiceRemote instance = (AccountServiceRemote)ec.getContext().lookup("java:global/classes/AccountService");
        long result = instance.openAccount(name, initialBalance);
        System.out.println(result);
        assertNotNull(result);
        
        float afterDeposit = instance.deposit(result, 10);
        assertEquals(110, afterDeposit, 0);
        
        float afterWithdraw = instance.withdraw(result, 10);
        assertEquals(100, afterWithdraw, 0);
    }

}
