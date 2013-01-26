package edu.depaul.cdm.se.ejb.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class StatelessCounter {
    private int counter = 0;
    
    public void increment() {
        counter++;
    }
    
    public int count() {
        return counter;
    }
    
    @PostConstruct
    public void postConstruct() {
        Logger.getLogger(StatelessCounter.class.getName()).log(Level.INFO, "post construct");
    }
    
    @PreDestroy
    public void preDestory() {
        Logger.getLogger(StatelessCounter.class.getName()).log(Level.INFO, "pre destroy");
    }

}
