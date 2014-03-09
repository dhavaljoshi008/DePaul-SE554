package edu.depaul.cdm.se.account.service;

import edu.depaul.cdm.se.account.persistence.Account;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Stateless
@Path("account")
public class AccountREST  {

    @EJB
    private AccountServiceRemote accountRemote;
    
    @POST
    @Path("/add")
    public Response openAccount(@FormParam("name") String name, 
            @FormParam("init_bal") float initialBalance) throws NegativeBalanceException {
        long accntNbr =  accountRemote.openAccount(name, initialBalance);
        
        return Response.status(Response.Status.OK)
                .entity("account_num: " + accntNbr).build();
    }
    
    @GET
    @Produces({"application/xml", "application/json"})
    public List<Account> findAll() {
        return accountRemote.getAllAccounts();
    }

}
