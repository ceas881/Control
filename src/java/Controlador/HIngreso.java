package Controlador;

import Modelo.Consultae;
import ModeloDAO.ConsultaDAO;
import ModeloDAO.RegistroDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        if (accion == null) accion = "";
        
        // 🔐 Verificación de sesión activa
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("authenticated") == null) {
        response.sendRedirect("login.jsp?redirect=" + accion);
        return;
    }
        
        System.out.println("Acción recibida: " + accion); // Debug para ver qué acción llega

        if (accion != null && accion.equals("Consultas")) {
            // Redirigir a la vista de consulta
            request.getRequestDispatcher("Vistas/Consulta.jsp").forward(request, response);
            return;  // Evita continuar ejecutando más código
        }
        
        /*String dni = request.getParameter("dni");
        //String accion = request.getParameter("accion");

        if (accion.equals("Consulta")) { //por validar para verificar documento ingresado--------------------------------------
        // Verificar en la BD si el DNI existe
        boolean existeDNI = verificardniEnBD(dni); // Método hipotético que verifica en la BD
    
        if (existeDNI) {
        // Redirigir al siguiente módulo
        request.getRequestDispatcher("Vistas/mostrarEmpleados.jsp").forward(request, response);
        } else {
        // Redirigir de vuelta al formulario con mensaje de error
        request.setAttribute("error", "El DNI ingresado no existe.");
        request.getRequestDispatcher("Vistas/consulta.jsp").forward(request, response);
        }*/

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
            request.getRequestDispatcher("Vistas/Consulta.jsp").forward(request, response);
            /*response.sendRedirect("mostrarEmpleado.jsp?mensaje=Nuevo registro exitoso para DNI: " + dni);*/
            return;  // Evita continuar ejecutando más código
        }

        if (accion.equalsIgnoreCase("Registrar Salida")) {
            //System.out.println("Ejecutando acción: Registrar Salida"); // Debug
            String dni = request.getParameter("dni");
            ConsultaDAO dao = new ConsultaDAO(); // <-- Instanciación del DAO
            dao.actualizarHoraSalida(dni); // Actualizas la hora de salida
            request.setAttribute("productos", dao.obtenerProductos()); // Lista productos para el form
            acceso = "Vistas/registrar_salida.jsp"; // Redirige al JSP para seleccionar producto
              
            } else if(accion.equalsIgnoreCase("GuardarSalida")){
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                RegistroDAO dao = new RegistroDAO();
                dao.actualizarInventario(codigo, cantidad);
                acceso = "Vistas/Consulta.jsp"; // o donde desees enviar
            }

        // Si no se encontró ninguna acción válida, redirigir a la página principal
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean verificardniEnBD(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
