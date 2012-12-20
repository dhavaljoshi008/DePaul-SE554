package edu.depaul.cdm.se.asynch.client.p2p;

import java.util.Date;
import javax.jms.*;
import javax.naming.*;

public class Sender {

    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        sender.sendSimpleMessage();
        //sender.sendSimpleMessageWithResponseQueue();
    }

    private void sendSimpleMessageWithResponseQueue() throws Exception {
        // Get JNDI context
        Context jndiContext = new InitialContext();

        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee6/ConnectionFactory");
        Queue queue = (Queue) jndiContext.lookup("jms/javaee6/Queue");

        // Connect to queue to send message
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(queue);
        Destination replyQueue = session.createTemporaryQueue();
        MessageConsumer responseConsumer = session.createConsumer(replyQueue);

        // Send message
        TextMessage message = session.createTextMessage();
        System.out.println(".....About to send message to Watson");
        message.setText("Watson... come quickly... and reply to " + replyQueue.toString());
        message.setJMSReplyTo(replyQueue);
        producer.send(message);
        System.out.print("Reply Q: ==>");
        System.out.print(replyQueue.toString());
        System.out.println("<==");
        System.out.println(".....message sent to Watson");

        System.out.println("waiting on response from Watson");

        TextMessage reply = (TextMessage) responseConsumer.receive(10000);
        
        System.out.println("=================");
        if (reply == null)
            System.out.println("Nothing received");
        else
            System.out.println(reply.getText());
        System.out.println("=================");
        //String correlationId = reply.getJMSCorrelationID();

        // Clean up
        producer.close();
        session.close();
        connection.close();
    }

    private void sendSimpleMessage() throws Exception {
        // Get JNDI context
        Context jndiContext = new InitialContext();

        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee6/ConnectionFactory");
        Queue queue = (Queue) jndiContext.lookup("jms/javaee6/Queue");

        // Connect to queue to send message
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(queue);

        // Send message
        TextMessage message = session.createTextMessage();
        System.out.println(".....About to send message to Watson");
        message.setText("Watson... come quickly..." + new Date());
        producer.send(message);
        System.out.println(".....message sent to Watson");

        // Clean up
        connection.close();
    }
}
