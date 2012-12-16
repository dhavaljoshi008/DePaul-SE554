package edu.depaul.cdm.se.sbejb.impl;

import edu.depaul.cdm.se.sbejb.RGreeterBeanRemote;
import javax.ejb.Stateless;

@Stateless
public class RGreeterBean implements RGreeterBeanRemote {

    @Override
    public String greetMe(String name) {
        return "Remote hello: " + name;
    }
}
