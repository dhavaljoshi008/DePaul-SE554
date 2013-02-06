package edu.depaul.se.mdb;

import edu.depaul.se.xml.CalculatorRequest;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@MessageDriven(mappedName = "jms/javaee6/CalculatorQ",
activationConfig = {
    @ActivationConfigProperty(propertyName="connectionFactoryJndiName",propertyValue="QCF"),
    @ActivationConfigProperty(
     propertyName = "destinationType", propertyValue = "javax.jms.Queue")})
public class CalculatorMDB implements MessageListener {

    Logger logger = Logger.getLogger("test");

    public void onMessage(Message message) {
        // Based on the Calculator operator, call the appropriate method
        CalculatorRequest c = null;
        try {
            c = convert(((TextMessage) message).getText());

            int result = 0;
            switch (c.getOperator()) {
                case MULTIPLY:
                    result = c.getRhs() * c.getLhs();
                    break;
                case SUBTRACT:
                    result = c.getRhs() - c.getLhs();
                    break;
                case ADD:
                    result = c.getRhs() + c.getLhs();
                    break;
            }

            if (message.getJMSReplyTo() == null) {
                System.out.println(c.getLhs() + " " + c.getOperator() + " " + c.getRhs() + " = " + result);
//            } else {
//                Session session = connectionFactory.createConnection().createSession(true, Session.AUTO_ACKNOWLEDGE);
//                MessageProducer producer = session.createProducer(message.getJMSReplyTo());
//                TextMessage reply = session.createTextMessage("Calculator result: " + result);
//                producer.send(reply);
            }
        } catch (JMSException ex) {
            Logger.getLogger(CalculatorMDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Convert xml to CalculatorRequest
     *
     * @param xml
     * @return
     */
    private CalculatorRequest convert(String xml) {
        StringReader reader = null;
        CalculatorRequest c = null;

        try {
            JAXBContext context = JAXBContext.newInstance(CalculatorRequest.class);
            Unmarshaller m = context.createUnmarshaller();
            reader = new StringReader(xml);
            c = (CalculatorRequest) m.unmarshal(reader);
        } catch (JAXBException ex) {
            Logger.getLogger(CalculatorMDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            reader.close();
        }

        return c;
    }
}
