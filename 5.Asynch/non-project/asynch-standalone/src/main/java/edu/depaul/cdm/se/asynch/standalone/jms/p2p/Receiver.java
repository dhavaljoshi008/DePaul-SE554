package edu.depaul.cdm.se.asynch.standalone.jms.p2p;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Receiver {

    public static void main(String[] args) throws Exception {
        Context jndiContext = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/ConnectionFactory");
        Queue queue = (Queue) jndiContext.lookup("jms/Queue");

        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(queue);
        connection.start();
        System.out.println("P2P Dr. Fraiser is listening...");
        while (true) {
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println("Message received: " + message.getText());

            Destination replyDestination = message.getJMSReplyTo();

            // Check to see if reply was requested
            if (replyDestination != null) {
                session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer replyProducer = session.createProducer(message.getJMSReplyTo());
                TextMessage replyMessage = session.createTextMessage("Thank you");
                replyMessage.setJMSCorrelationID(message.getJMSMessageID());
                replyProducer.send(replyMessage);
                System.out.println("Message sent");
            }
        }

        //session.close();
        //connection.close();
    }
}
