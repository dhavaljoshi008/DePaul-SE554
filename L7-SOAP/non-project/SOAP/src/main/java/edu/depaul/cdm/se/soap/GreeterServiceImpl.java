package edu.depaul.cdm.se.soap;

import javax.jws.WebService;

@WebService(endpointInterface="edu.depaul.cdm.se.soap.IGreeterService")
public class GreeterServiceImpl implements IGreeterService{

    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
    
    public String sayItAgain(String name) {
        return null;
    }
    
}
