package edu.depaul.cdm.se.soap;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.wsaddressing.W3CEndpointReference;

/**
 * WS-Addressed example
 */
@WebService(serviceName = "AddressedGreeterService",
            targetNamespace = "http://addressedgreetings.se.cdm.depaul.edu")
@Addressing(required = true, enabled = true)
public class AddressedGreeterService {
    @Resource
    private WebServiceContext wsc;

    public W3CEndpointReference getEPR() {
        return (W3CEndpointReference) wsc.getEndpointReference();
    }

    @WebMethod
    @Action(input = "http://addressedgreetings.se.cdm.depaul.edu/input",
    output = "http://addressedgreetings.se.cdm.depaul.edu/output")
    public String hello(@WebParam(name = "name") String txt) {
        return "Addressed Hello " + txt + " !";
    }
}
