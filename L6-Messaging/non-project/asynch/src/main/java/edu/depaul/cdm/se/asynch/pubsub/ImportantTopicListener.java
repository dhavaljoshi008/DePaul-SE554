package edu.depaul.cdm.se.asynch.pubsub;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/javaee6/Topic", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "ImportantTopicListener"),
    @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JMSPriority > 5"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "ImportantTopicListener")
})
public class ImportantTopicListener implements MessageListener {
    
    public ImportantTopicListener() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
        System.out.println(message.getJMSPriority());
            System.out.println("This must be important message since I only care about important message: " 
                    + textMessage.getText());
        } catch (JMSException ex) {
            Logger.getLogger(TopicListener.class.getName()).log(Level.SEVERE, null, ex);
        }    }
}
