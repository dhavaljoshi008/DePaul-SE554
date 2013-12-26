
package edu.depaul.cdm.se.ejb.impl;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MonitoredGreeterTest {
    
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
    
    @Test
    public void testGreeter() throws Exception {
       MonitoredGreeter instance = (MonitoredGreeter) ctx.lookup("java:global/classes/MonitoredGreeter");
        String expResult = "EJB Greetings, Tester";
        String result = instance.getGreet("Tester");
        assertEquals(expResult, result);
        
    }
}
