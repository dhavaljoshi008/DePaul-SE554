/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.se.servlet.ejb;

import edu.depaul.cdm.se.sbejb.IStatefulCounter;
import edu.depaul.cdm.se.sbejb.IStatelessCounter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ubuntu
 */
@WebServlet(name = "InstanceCounterServlet", urlPatterns = {"/InstanceCounterServlet"})
public class InstanceCounterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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

        final String sfLookupKey = "java:global/edu.depaul.cdm.se_sb-app-ear_ear_1.5-SNAPSHOT/sb-app-ejb-1.5-SNAPSHOT/StatefulCounter";
        final String slLookupKey = "java:global/edu.depaul.cdm.se_sb-app-ear_ear_1.5-SNAPSHOT/sb-app-ejb-1.5-SNAPSHOT/StatelessCounter";

        try {
            Context context = new InitialContext();
            IStatelessCounter statelessCounter = (IStatelessCounter) context.lookup(slLookupKey);
            IStatefulCounter statefulCounter = (IStatefulCounter) context.lookup(sfLookupKey);

            statefulCounter.increment();
            statelessCounter.increment();

            out.println("<h1>Servlet InstanceCounterServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2>StatelessCounter:" + statelessCounter.count() + "</h2>");
            out.println("<h2>StatefulCounter:" + statefulCounter.count() + "</h2>");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
