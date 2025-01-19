package Controlador;

import Modelo.Empleado;
import Modelo.Producto;
import ModeloDAO.EmpleadoDAO;
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
public class Controlador extends HttpServlet {
    
    String Listar = "Vistas/Listar.jsp";
    String Add = "Vistas/Add.jsp";
    String Edit = "Vistas/Edit.jsp";
    String listar = "Vistas/Productos.jsp";
    String Agregar = "Vistas/Addp.jsp";
    String editar = "Vistas/Editp.jsp";
    
    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    
    int id;
    int codigo;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
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
        
        if (action.equalsIgnoreCase("Listar")){
            acceso = Listar;
        }else if(action.equalsIgnoreCase("Add")){
            acceso = Add;
        }else if(action.equalsIgnoreCase("Agregar Empleado")){
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            String dni = request.getParameter("txtdni");
            String telefono = request.getParameter("txttelefono");
            String Email = request.getParameter("txtEmail");
            int id_departamento = Integer.parseInt(request.getParameter("txtid_departamento"));
            //String id_departamento = request.getParameter("id_departamento");
            empleado.setnombre(nombre);
            empleado.setapellido(apellido);
            empleado.setdni(dni);
            empleado.settelefono(telefono);
            empleado.setEmail(Email);
            empleado.setid_departamento(id_departamento);
            empleadoDAO.Add(empleado);
            acceso = Listar;
            //System.out.println("Nuevo objeto nombre: " + empleado.getnombre() + ", apellido: " + empleado.getapellido() + ", dni: " + empleado.getdni() + ", telefono: " + empleado.gettelefono() + ", Email: " + empleado.getEmail() + ",id_departamento: " + empleado.getid_departamento());
            
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("id_empleado", request.getParameter("id"));
            acceso=Edit;
            System.out.println("Pasando por editar el doget");
        }else if(action.equalsIgnoreCase("Actualizar")){
            id = Integer.parseInt(request.getParameter("txtid_empleado"));
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            String dni = request.getParameter("txtdni");
            String telefono = request.getParameter("txttelefono");
            String Email = request.getParameter("txtEmail");
            int id_departamento = Integer.parseInt(request.getParameter("txtid_departamento"));
            //String id_departamento = request.getParameter("id_departamento");
            empleado.setid_empleado(id);
            empleado.setnombre(nombre);
            empleado.setapellido(apellido);
            empleado.setdni(dni);
            empleado.settelefono(telefono);
            empleado.setEmail(Email);
            empleado.setid_departamento(id_departamento);
            empleadoDAO.Edit(empleado);
            acceso = Listar;
        }else if(action.equalsIgnoreCase("Eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            empleado.setid_empleado(id);
            empleadoDAO.eliminar(id);
            acceso = Listar;
        }else if (action.equalsIgnoreCase("listar")){
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
