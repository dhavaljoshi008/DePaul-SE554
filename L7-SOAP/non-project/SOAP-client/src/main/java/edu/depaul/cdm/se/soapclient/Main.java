package edu.depaul.cdm.se.soapclient;

import edu.depaul.cdm.se.soap.GreeterService;
import edu.depaul.cdm.se.soap.GreeterService_Service;

public class Main {
    public static void main(String[] args) throws Exception {
        GreeterService service = new GreeterService_Service().getGreeterServicePort();
        System.out.println(service.hello("Dave"));
    }
}
