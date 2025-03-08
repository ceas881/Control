package Controlador;

import Modelo.Consultae;
import Modelo.Producto;
import ModeloDAO.ConsultaDAO;
import ModeloDAO.RegistroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AMAF
 */
public class HIngreso extends HttpServlet {

    Consultae consultae = new Consultae();
    ConsultaDAO consultaDAO = new ConsultaDAO();
    private String Listar;
    String Agregar = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        // Obtener la fecha y hora del sistema
        String acceso = "";
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        // Enviar los valores al JSP
        request.setAttribute("fecha", dateFormat.format(date));
        request.setAttribute("hora", timeFormat.format(date));

        // Obtiene el parámetro 'accion'
        String accion = request.getParameter("accion");

        // Verificar si 'accion' es nulo para evitar errores
        if (accion == null) {
            accion = "";
        }
        System.out.println("Acción recibida: " + accion); // Debug para ver qué acción llega

        if (accion != null && accion.equals("Consultas")) {
            // Redirigir a la vista de consulta
            request.getRequestDispatcher("Vistas/Consulta.jsp").forward(request, response);
            return;  // Evita continuar ejecutando más código
        }

        if (accion != null && accion.equals("Consulta")) {
            // Redirigir a mostrarEmpleado.jsp
            request.getRequestDispatcher("Vistas/mostrarEmpleado.jsp").forward(request, response);
            // Enviar los valores al JSP
            request.setAttribute("fecha", dateFormat.format(date));
            request.setAttribute("hora", timeFormat.format(date));

            // Procesar los parámetros de la consulta
            String dni = request.getParameter("txtdni");
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            consultae.setDni(dni);
            consultae.setNombre(nombre);
            consultae.setApellido(apellido);

            // Aquí no es necesario el response.getWriter(), ya que rediriges a un JSP
            return;  // Evita continuar ejecutando más código
        }

        if (accion != null && accion.equals("Listar")) {
            // Lógica para la acción Listar
            ConsultaDAO dao = new ConsultaDAO();
            List<Consultae> lista = dao.Listar();
            request.setAttribute("listaConsultas", lista);
            request.getRequestDispatcher("Vistas/Historico.jsp").forward(request, response);
            return;  // Evita continuar ejecutando más código
        }

        if (accion.equalsIgnoreCase("Registrar Ingreso")) {
            // Lógica para registrar ingreso
            String dni = request.getParameter("dni");
            ConsultaDAO dao = new ConsultaDAO();
            dao.Agregar(dni);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            /*response.sendRedirect("mostrarEmpleado.jsp?mensaje=Nuevo registro exitoso para DNI: " + dni);*/
            return;  // Evita continuar ejecutando más código
        }

        if (accion.equalsIgnoreCase("Registrar Salida")) {
            System.out.println("Ejecutando acción: Registrar Salida"); // Debug

            // Obtener lista de productos para el desplegable
            RegistroDAO dao = new RegistroDAO();
            List<Producto> listaProductos = dao.listarProductos();

            // Verificar que la lista tiene productos
            System.out.println("Total productos enviados al JSP: " + listaProductos.size());

            // Enviar la lista de productos a la vista
            request.setAttribute("listaProductos", listaProductos);

            // Redirigir al JSP
            request.getRequestDispatcher("Vistas/registrar_salida.jsp").forward(request, response);
            return; // Importante para evitar que continúe ejecutando código innecesario
        }

        if (accion.equalsIgnoreCase("Guardar Salida")) {
            System.out.println("Ejecutando acción: Guardar Salida"); // Debug

            String dni = request.getParameter("dni");
            int producto_id = Integer.parseInt(request.getParameter("producto"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));

            System.out.println("Datos recibidos -> DNI: " + dni + ", Producto: " + producto_id + ", Cantidad: " + cantidad); // Debug

            // Registrar salida y actualizar inventario
            RegistroDAO dao = new RegistroDAO();
            dao.registrarSalida(dni, producto_id, cantidad);
            acceso = "HIngreso?accion=Listar";

            // Redirigir a la vista de histórico
            request.getRequestDispatcher(acceso).forward(request, response);
            return; // Importante para evitar que se ejecute más código
        }

        // Si no se encontró ninguna acción válida, redirigir a la página principal
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
