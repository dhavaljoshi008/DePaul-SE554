package edu.depaul.cdm.se.soap;

import javax.jws.WebService;
/**
 * Implementation using web service interface rather than class
 * sayItAgain does not show up in the webservice definition
 */
@WebService(endpointInterface="edu.depaul.cdm.se.soap.IGreeterService", serviceName = "GreeterImplService")
public class GreeterServiceImpl implements IGreeterService{

    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
    
    public String sayItAgain(String name) {
        return null;
    }
    
}
