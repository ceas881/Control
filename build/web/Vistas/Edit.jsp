<%-- 
    Document   : Edit
    Created on : 10/12/2024, 11:00:58 a. m.
    Author     : AMAF
--%>

<%@page import="Modelo.Empleado"%>
<%@page import="ModeloDAO.EmpleadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="./css/styles.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
    </head>
    <body>
        <div>
            <%
                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                int id = Integer.parseInt((String)request.getAttribute("id_empleado"));
                Empleado empleado = (Empleado)empleadoDAO.list(id);
            %>
            <section class="containerE">
        <h1>Editar Empleado</h1>
        <form action="Controlador">
            NOMBRE: <br>
            <input type="text" name="txtnombre" value="<%= empleado.getnombre()%>"><br>
            APELLIDO: <br>
            <input type="text" name="txtapellido" value="<%= empleado.getapellido()%>"><br>
            DNI: <br>
            <input type="text" name="txtdni" value="<%= empleado.getdni()%>"><br>
            TELEFONO: <br>
            <input type="text" name="txttelefono" value="<%= empleado.gettelefono()%>"><br>
            EMAIL: <br>
            <input type="text" name="txtEmail" value="<%= empleado.getEmail()%>"><br>
            ID DEPARTAMENTO: <br>
            <input type="text" name="txtid_departamento" value="<%= empleado.getid_departamento()%>"><br>
            <br>
            <input type="hidden" name="txtid_empleado" value="<%= empleado.getid_empleado()%>"><br>
            <input class="btn" type="submit" name="accion" value="Actualizar"><br><br>
            <a class="btn" href="Controlador?accion=Listar">Regresar</a>
        </form>
            </section>
        </div>
    </body>
</html>
