package cosa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juanka
 */
@WebServlet(urlPatterns = {"/Inicio"})
public class ValidarDatosUserServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession ses = request.getSession();
            String user = request.getParameter("txtUser");
            String pass = request.getParameter("txtPass");

            if (user.equals("") && pass.equals("")) {
                request.getRequestDispatcher("index.jsp?d=0").forward(request, response);

            } else if (user.equals("")) {
                request.getRequestDispatcher("index.jsp?d=1").forward(request, response);

            } else if (pass.equals("")) {
                request.getRequestDispatcher("index.jsp?d=2").forward(request, response);

            } else {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/requerimientos", "root", "");
                    PreparedStatement ps = null;
                    ResultSet rs = null;
                    ps = conn.prepareStatement("SELECT * FROM user WHERE user.user='" + user + "'");
                    rs = ps.executeQuery();
                    rs.next();
                    //Statement st = conn.createStatement();
                    //String query="INSERT INTO USER VALUES(2,'admin2','nombre2','apellido2')";
                    if (rs.getString("user").equals(user)) {
                        if (rs.getString("pass").equals(pass)) {
                            Usuario us = new Usuario(user, pass,rs.getString("user"),rs.getString("pass"));
                            ses.setAttribute("usuario", us);
                            conn.close();
                            request.getRequestDispatcher("MenuPrincipal.jsp").forward(request, response);

                        } else {
                            
                        }
                    }
                } catch (SQLException ex) {
                    request.getRequestDispatcher("index.jsp?d=3").forward(request, response);
                    throw new SQLException(ex);
                }
                /*
                if (user.equals("admin") && pass.equals("admin")) {
                    Usuario us = new Usuario(user, pass);
                    ses.setAttribute("usuario", us);
                    request.getRequestDispatcher("Formulario.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("index.jsp?d=3").forward(request, response);
                }*/
            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidarDatosUserServlet2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ValidarDatosUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidarDatosUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ValidarDatosUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidarDatosUserServlet.class.getName()).log(Level.SEVERE, null, ex);
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
