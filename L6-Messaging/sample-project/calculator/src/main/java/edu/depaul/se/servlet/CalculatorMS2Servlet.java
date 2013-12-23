package edu.depaul.se.servlet;

import edu.depaul.se.xml.CalculatorRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@WebServlet(name = "CalculatorMS2Servlet", urlPatterns = {"/CalculatorMS2Servlet"})
public class CalculatorMS2Servlet extends HttpServlet {
    @Inject
    private JMSContext jmsContext;

    @Resource(mappedName = "jms/CalculatorQ")
    private Destination calcQ;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String lhs = request.getParameter("lhs");
            String rhs = request.getParameter("rhs");
            char operator = request.getParameter("operator").charAt(0);

            int lhsNum = 0;
            int rhsNum = 0;

            try {
                lhsNum = Integer.parseInt(lhs);
                rhsNum = Integer.parseInt(rhs);
            } catch (NumberFormatException nfe) {
                out.println("<html>");
                out.println("<h1>");
                out.println("One or more values were not numeric, please enter only numeric values");
                out.println("</html>");
                return;
            }


            CalculatorRequest.CalculatorOperation operation;
            // Send message
            if (operator == '+') {
                operation = CalculatorRequest.CalculatorOperation.ADD;
            } else if (operator == '-') {
                operation = CalculatorRequest.CalculatorOperation.SUBTRACT;
            } else if (operator == '*') {
                operation = CalculatorRequest.CalculatorOperation.MULTIPLY;
            } else {
                operation = CalculatorRequest.CalculatorOperation.DIVIDE;
            }

            CalculatorRequest c = new CalculatorRequest(lhsNum, rhsNum, operation);

            StringWriter writer = new StringWriter();


            JAXBContext context = JAXBContext.newInstance(CalculatorRequest.class);
            Marshaller m = context.createMarshaller();
            m.marshal(c, writer);

            String msg = writer.toString();
            if (jmsContext == null) System.out.println("jmsContext is null");
            JMSProducer producer = jmsContext.createProducer();
            if (producer == null) System.out.println("producer is null");
            jmsContext.createProducer().send(calcQ, msg);
            out.println("<html>");
            out.println("<h1>");
            out.print("Message sent: ");
            out.print(msg);
            out.println(" will be handled later");
            out.println("</html>");

        } catch (JAXBException  e) {
            out.println("<html>");
            out.println("<h1>");
            out.println("Error processing request: " + e.toString());
            out.println("</html>");
            throw new RuntimeException(e);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
