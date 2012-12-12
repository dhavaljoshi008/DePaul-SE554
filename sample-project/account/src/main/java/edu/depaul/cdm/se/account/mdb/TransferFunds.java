package edu.depaul.cdm.se.account.mdb;

import edu.depaul.cdm.se.account.service.AccountNotFoundException;
import edu.depaul.cdm.se.account.service.AccountService;
import edu.depaul.cdm.se.account.service.InsufficientBalanceException;
import edu.depaul.cdm.se.account.service.NegativeBalanceException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/transferFundsQ",
activationConfig = {
    @ActivationConfigProperty(
     propertyName = "destinationType", propertyValue = "javax.jms.Queue")})
public class TransferFunds implements MessageListener{

    @EJB
    private AccountService accountService;
    
    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            String msg2Process = msg.getText();
            System.out.println("Processing: " + msg2Process);
            StringTokenizer tokenizer = new StringTokenizer(msg2Process, ";");
            Long fromAccount = Long.parseLong(tokenizer.nextToken());
            Long toAccount = Long.parseLong(tokenizer.nextToken());
            Float amount = Float.parseFloat(tokenizer.nextToken());
            accountService.transferFunds(fromAccount, toAccount, amount);
        } catch (JMSException | AccountNotFoundException | NegativeBalanceException | InsufficientBalanceException ex) {
            Logger.getLogger(TransferFunds.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(message.toString() + " was processed");
    }
    
}
