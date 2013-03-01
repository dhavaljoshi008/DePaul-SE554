/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.se.account.service;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService// (wsdlLocation="GreeterService.wsdl")
public class Account {
    @EJB
    private AccountServiceRemote accountRemote;
    
    @WebMethod
    public float withdraw(long accountNumber, float amount) throws NegativeBalanceException, InsufficientBalanceException, AccountNotFoundException {
        return accountRemote.withdraw(accountNumber, amount);
    }

}