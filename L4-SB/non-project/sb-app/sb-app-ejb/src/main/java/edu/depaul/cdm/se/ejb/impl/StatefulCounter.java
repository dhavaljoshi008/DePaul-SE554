package edu.depaul.cdm.se.ejb.impl;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.StatefulTimeout;

@Stateful
//@StatefulTimeout(value=1, unit= TimeUnit.MILLISECONDS)
@LocalBean
public class StatefulCounter {
    private int counter = 0;
    
    public void increment() {
        counter++;
    }
    
    public int count() {
        return counter;
    }
    
    @PostConstruct
    public void postConstruct() {
        Logger.getLogger(StatefulCounter.class.getName()).log(Level.INFO, "post construct");
    }
    
    @PreDestroy
    public void preDestory() {
        Logger.getLogger(StatefulCounter.class.getName()).log(Level.INFO, "pre destroy");
    }
    
}
