package edu.depaul.se.firstsb;

import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class GreeterBeanContainerTest {
    private EJBContainer ec;
    private Context ctx;

    @Before
    public void setUp() {
        ec = EJBContainer.createEJBContainer();
        ctx = ec.getContext();
    }

    @After
    public void tearDown() {
        if (ec != null) {
            ec.close();
        }
    }

    /**
     * Test of returnMessage method, of class StandaloneBean.
     */
    @Test
    public void testGreeting() throws Exception {
        GreeterBean instance = (GreeterBean) ctx.lookup("java:global/classes/GreeterBean");
        String expResult = "EJB Greetings, Tester";
        String result = instance.getGreet("Tester");
        assertEquals(expResult, result);
    }
    
}