package Controlador;

import Modelo.Producto;
import ModeloDAO.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AMAF
 */
public class Controladorp extends HttpServlet {

    String listar = "Vistas/Productos.jsp";
    String Agregar = "Vistas/Addp.jsp";
    String editar = "Vistas/Editp.jsp";
    
    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    
    int codigo;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controladorp</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controladorp at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String acceso = "";
        String action = request.getParameter("accion");
        
        if (action.equalsIgnoreCase("listar")){
            acceso = listar;
        }else if(action.equalsIgnoreCase("Addp")){
            acceso = Agregar;
        }else if(action.equalsIgnoreCase("Agregar Producto")){
            String nombre = request.getParameter("txtnombre");
            int inventario = Integer.parseInt(request.getParameter("txtinventario"));

            producto.setnombre(nombre);
            producto.setinventario(inventario);
            productoDAO.Addp(producto);
            acceso = listar;
            System.out.println("Nuevo producto Nombre: " + producto.getnombre() + ", Inventario: " + producto.getinventario());
            
        }else if(action.equalsIgnoreCase("Editar")){
            request.setAttribute("codigo", request.getParameter("codigo"));
            acceso=editar;
            System.out.println("Pasando por editar el doget");
        }else if(action.equalsIgnoreCase("Actualizar")){
            codigo = Integer.parseInt(request.getParameter("txtcodigo"));
            String nombre = request.getParameter("txtnombre");
            int inventario = Integer.parseInt(request.getParameter("txtinventario"));
            producto.setcodigo(codigo);
            producto.setnombre(nombre);
            producto.setinventario(inventario);
            productoDAO.Editp(producto);
            acceso = listar;
        }else if(action.equalsIgnoreCase("Eliminar")){
            codigo = Integer.parseInt(request.getParameter("codigo"));
            producto.setcodigo(codigo);
            productoDAO.Eliminar(codigo);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
