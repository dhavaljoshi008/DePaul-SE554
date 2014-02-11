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
        System.out.println("openAccount");
        String name = "Dave";
        float initialBalance = 100.0F;
        AccountServiceRemote instance = (AccountServiceRemote)ec.getContext().lookup("java:global/classes/AccountService");
        long expResult = 100L;
        long result = instance.openAccount(name, initialBalance);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deposit method, of class AccountService.
     */
    @org.junit.Test
    public void testDeposit() throws Exception {
        System.out.println("deposit");
        long accountNumber = 0L;
        float amount = 0.0F;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AccountServiceRemote instance = (AccountServiceRemote)container.getContext().lookup("java:global/classes/AccountService");
        float expResult = 0.0F;
        float result = instance.deposit(accountNumber, amount);
        assertEquals(expResult, result, 0.0);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of withdraw method, of class AccountService.
     */
    @org.junit.Test
    public void testWithdraw() throws Exception {
        System.out.println("withdraw");
        long accountNumber = 0L;
        float amount = 0.0F;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AccountServiceRemote instance = (AccountServiceRemote)container.getContext().lookup("java:global/classes/AccountService");
        float expResult = 0.0F;
        float result = instance.withdraw(accountNumber, amount);
        assertEquals(expResult, result, 0.0);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class AccountService.
     */
    @org.junit.Test
    public void testClose() throws Exception {
        System.out.println("close");
        long accountNumber = 0L;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AccountServiceRemote instance = (AccountServiceRemote)container.getContext().lookup("java:global/classes/AccountService");
        float expResult = 0.0F;
        float result = instance.close(accountNumber);
        assertEquals(expResult, result, 0.0);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transferFunds method, of class AccountService.
     */
    @org.junit.Test
    public void testTransferFunds() throws Exception {
        System.out.println("transferFunds");
        long fromAccountNumber = 0L;
        long toAccountNumber = 0L;
        float amount = 0.0F;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AccountServiceRemote instance = (AccountServiceRemote)container.getContext().lookup("java:global/classes/AccountService");
        instance.transferFunds(fromAccountNumber, toAccountNumber, amount);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAccounts method, of class AccountService.
     */
    @org.junit.Test
    public void testGetAllAccounts() throws Exception {
        System.out.println("getAllAccounts");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AccountServiceRemote instance = (AccountServiceRemote)container.getContext().lookup("java:global/classes/AccountService");
        List expResult = null;
        List result = instance.getAllAccounts();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
