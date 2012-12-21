/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.se.soap;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author ubuntu
 */
@Stateless
@WebService(serviceName="GreeterSBService")
public class GreeterSBService {

    public String sayGreet(String name) {
        return "Greetings " + name;
    }

}
