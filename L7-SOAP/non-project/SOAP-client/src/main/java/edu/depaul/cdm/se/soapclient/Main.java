package edu.depaul.cdm.se.soapclient;

import edu.depaul.cdm.se.addressedgreetings.AddressedGreeterService;
import edu.depaul.cdm.se.addressedgreetings.AddressedGreeterService_Service;
import edu.depaul.cdm.se.soap.GreeterService;
import edu.depaul.cdm.se.soap.GreeterService_Service;

public class Main {
    public static void main(String[] args) {
        Main client = new Main();
//        client.doGreet();
        client.doAddressedGreet();
    }
    
    public void doGreet() {
        GreeterService service = new GreeterService_Service().getGreeterServicePort();
        System.out.println(service.hello("Dave"));
    }
    
    public void doAddressedGreet() {
        AddressedGreeterService service = new AddressedGreeterService_Service().getAddressedGreeterServicePort();
        System.out.println(service.hello("Dave"));
    }
}
