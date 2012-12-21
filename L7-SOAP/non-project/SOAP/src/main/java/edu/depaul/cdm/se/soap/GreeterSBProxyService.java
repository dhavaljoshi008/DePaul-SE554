package edu.depaul.cdm.se.soap;

import edu.depaul.cdm.se.sb.GreeterSB;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "GreeterSBProxyService")
public class GreeterSBProxyService {
    @EJB
    private GreeterSB ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "greet")
    public String greet(@WebParam(name = "name") String name) {
        return ejbRef.greet(name);
    }
    
}
