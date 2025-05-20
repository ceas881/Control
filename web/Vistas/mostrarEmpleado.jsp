<%-- 
    Document   : mostrarEmpleado
    Created on : 17/12/2024, 11:42:53 a. m.
    Author     : AMAF
--%>

<%@page import="ModeloDAO.ConsultaDAO"%>
<%@page import="Modelo.Consultae"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/styles.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleado</title>
    </head>
    <body>
        <div class="containerB">
            <script src="script.js"></script>
            <%
                ConsultaDAO consultaDAO = new ConsultaDAO();
                String dni = request.getParameter("dni");
                Consultae consultae = (Consultae) consultaDAO.list(dni);
            %>
            <h2>Datos del Auxiliar</h2>
            <form action="HIngreso">
                <label for="fecha">Fecha:</label><br>
                <input type="text" name="fecha" value="${requestScope.fecha}" readonly><br><br>
                <label for="hora">Hora:</label><br>
                <input type="text" name="hora" value="${requestScope.hora}" readonly><br><br>
                <label for="dni">DNI:</label><br>
                <input type="text" name="dni" value="<%=consultae.getDni()%>" readonly><br><br>
                <label for="nombre">Nombre:</label><br>
                <input type="text" name="nombre" value="<%=consultae.getNombre()%>" readonly><br><br>
                <label for="apellido">Apellido:</label><br>
                <input type="text" name="apellido" value="<%=consultae.getApellido()%>" readonly><br><br><br>
                <!--<input type="submit" value="Registrar Hora">-->
                <input class="btn" type="submit" name="accion" value="Registrar Ingreso"><br><br>
                <input class="btn" type="submit" name="accion" value="Registrar Salida"><br><br>
                <input class="btn" type="submit" name="accion" value="Listar"><br><br>
            </form>
        </div>
        <!--script>
            var mensaje = "<!--%= request.getParameter("mensaje") %>";
            if (mensaje) {
            alert(mensaje);<!--mensaje de alerta-->
         <!--   }
        </script-->
    </body>
</html>