package edu.depaul.cdm.se.account.service;

import edu.depaul.cdm.se.account.persistence.Account;
import edu.depaul.cdm.se.account.service.AccountServiceRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("account")
public class AccountREST  {

    @EJB
    private AccountServiceRemote accountRemote;    
    
    @GET
    @Produces({"application/xml", "application/json"})
    public List<Account> findAll() {
        return accountRemote.getAllAccounts();
    }

}
