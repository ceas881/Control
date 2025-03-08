package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Consultae;
import Modelo.Producto;
import ModeloDAO.ConsultaDAO;
import java.util.List;

/**
 *
 * @author AMAF
 */
public class Controlador2 extends HttpServlet {

    /*Consultae consultae = new Consultae();
    ConsultaDAO consultaDAO = new ConsultaDAO();
    private String Listar;
    String Agregar = "";*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        /*/ Obtiene el parámetro 'accion'
        String accion = request.getParameter("accion");
        String acceso = "";

        if (accion != null && accion.equals("Consultas")) {
            request.getRequestDispatcher("Vistas/Consulta.jsp").forward(request, response);
        } else if (accion != null && accion.equals("Consulta")) {
            request.getRequestDispatcher("Vistas/mostrarEmpleado.jsp").forward(request, response);
            String dni = request.getParameter("txtdni");
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            consultae.setDni(dni);
            consultae.setNombre(nombre);
            consultae.setApellido(apellido);
            // Lógica para la acción "List"
            response.getWriter().println("Acción Listar ejecutada correctamente.");
        } else if (accion != null && accion.equals("Listar")) {
            ConsultaDAO dao = new ConsultaDAO();
            List<Consultae> lista = dao.Listar();

            // ✅ Establece la lista como atributo en la solicitud
            request.setAttribute("listaConsultas", lista);

            // ✅ Reenvía a la vista JSP
            request.getRequestDispatcher("Vistas/Historico.jsp").forward(request, response);

        } else if (accion.equalsIgnoreCase("Registrar Ingreso")) {
            // Captura el DNI desde la solicitud
            String dni = request.getParameter("dni");

            // Llama al método Agregar del DAO
            ConsultaDAO dao = new ConsultaDAO();
            dao.Agregar(dni);

            // Redirige a la lista de registros después de agregar
            acceso = Listar;
            System.out.println("Nuevo registro exitoso para DNI: " + dni);
        } else {
            response.getWriter().println("Acción no especificada.");
        }
        if (accion.equalsIgnoreCase("Registrar Salida")) {
            // Obtener lista de productos para el desplegable
            ConsultaDAO dao = new ConsultaDAO();
            List<Producto> listaProductos = dao.listarProductos();
            request.setAttribute("listaProductos", listaProductos);
            acceso = "registrar_salida.jsp";
        } else if (accion.equalsIgnoreCase("Guardar Salida")) {
            String dni = request.getParameter("dni");
            int productoId = Integer.parseInt(request.getParameter("producto"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));

            // Registrar salida y actualizar inventario
            ConsultaDAO dao = new ConsultaDAO();
            dao.registrarSalida(dni, productoId, cantidad);
            acceso = "Controlador2?accion=Listar";
        }

        request.getRequestDispatcher("Vistas/Historico.jsp").forward(request, response);*/
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
