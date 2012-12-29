package edu.depaul.cdm.se.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

/**
 * WS-Addressed example
 */
@WebService(serviceName="AddressedGreeterService")
@Addressing(required=true)
public class AddressedGreeterService {
    @WebMethod(action="hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }    
}
