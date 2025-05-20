package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *
 * @author AMAF
 */
public class AuthController extends HttpServlet {
    
    // Configura tus credenciales de BD aquí
    private static final String DB_URL = "jdbc:mysql://localhost:3306/control_acceso";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Gohengy1";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AuthController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String username = request.getParameter("username");
        String password = request.getParameter("password");
        String redirect = request.getParameter("redirect");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                String storedHash = rs.getString("password");
                
                // Aquí deberías implementar la verificación de contraseña
                // Por ejemplo, usando BCrypt:
                // if(BCrypt.checkpw(password, storedHash)) {
                if(password.equals(storedHash)) { // Esto es solo temporal - NO seguro para producción---------------------------------
                    
                    HttpSession session = request.getSession();
                    session.setAttribute("authenticated", true);
                    
                    if("productos".equals(redirect)) {
                        response.sendRedirect("Controladorp?accion=listar");
                    } else if("empleados".equals(redirect)) {
                        response.sendRedirect("Controlador?accion=Listar");
                    }
                    return;
                }
            }
            
            // Autenticación fallida
            response.sendRedirect("login.jsp?error=1&redirect=" + redirect);
            
        } catch(Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
