package edu.depaul.cdm.se.ejb.impl;

import java.io.File;
import java.util.Properties;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractContainerTest {
    private static EJBContainer ec;
    private static Context ctx;

    @Before
    public void instanceSetup() {
        
    }
    
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
            ec.close();
        }
    }

    protected Context getContext() {
        return ctx;
    }
}
