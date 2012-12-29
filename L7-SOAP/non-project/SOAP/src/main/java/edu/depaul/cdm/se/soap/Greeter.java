package edu.depaul.cdm.se.soap;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Simpliest example of Web Service 
 * Some enhancement opportunity
 * @Todo - what are different attributes on each of the annotation and the
 * impact on the wsdl?
 * 1) @WebServices
 * 2) @WebMethod 
 * 3) @WebParam
 * Web service as regular java object
 */
@WebService
public class Greeter {
    @WebMethod(action="hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

}
