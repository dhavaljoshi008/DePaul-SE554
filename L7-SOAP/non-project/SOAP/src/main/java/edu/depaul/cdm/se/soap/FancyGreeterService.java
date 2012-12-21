package edu.depaul.cdm.se.soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName="FancyGreeterService")
public class FancyGreeterService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sayIt")
    public GreeterResponse sayIt(@WebParam(name = "request") GreeterRequest request) {
        //TODO write your implementation code here:
        return null;
    }
    
    public GreeterResponse saySomethingElse(GreeterRequest request) {
        return null;
    }
}
