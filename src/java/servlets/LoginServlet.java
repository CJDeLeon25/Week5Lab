package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import application.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 798676
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if(action != null && action.equals("logout")){
            session.invalidate();
            session = request.getSession();
            }
        if(session.getAttribute("username") != null){
            response.sendRedirect("home");
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username != null && password != null){
            AccountService service = new AccountService();
            if(service.login(username,password) != null){
                session.setAttribute("username", username);
                response.sendRedirect("home");
            }
            else{
               request.setAttribute("username",username);
               request.setAttribute("password",password);
               getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }
      
        
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
