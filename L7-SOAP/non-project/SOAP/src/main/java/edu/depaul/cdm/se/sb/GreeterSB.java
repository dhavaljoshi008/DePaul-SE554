package edu.depaul.cdm.se.sb;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
public class GreeterSB {

    public String greet(String name) {
        return "Hello " + name;
    }

}
