package edu.depaul.cdm.se.soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * Reliable Message sample
 * Special note to wsit file in WEB-INF directory wsp policy element
 */
@WebService(serviceName = "ReliableGreetingService")
public class ReliableGreetingService {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
