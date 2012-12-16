package edu.depaul.cdm.se.sbejb;

import javax.ejb.Remote;

@Remote
public interface RGreeterBeanRemote {

    String greetMe(String name);
    
}
