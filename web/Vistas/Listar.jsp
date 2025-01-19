<%-- 
    Document   : Listar
    Created on : 10/12/2024, 11:09:25 a. m.
    Author     : AMAF
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Empleado"%>
<%@page import="ModeloDAO.EmpleadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="./css/styles.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
    </head>
    <body>
        <div class="containerB">
            <h1>Empleados</h1>
            
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>APELLIDO</th>
                        <th>DNI</th>
                        <th>TELEFONO</th>
                        <th>CORREO</th>
                        <th>DEPARTAMENTO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    EmpleadoDAO dao = new EmpleadoDAO();
                    List<Empleado> list = dao.Listar();
                    Iterator<Empleado> iter = list.iterator();
                    Empleado empleado = null;

                    while (iter.hasNext()){
                        empleado = iter.next();

                %>
                <tbody>
                    <tr>
                        <td><%=empleado.getid_empleado()%></td>
                        <td><%=empleado.getnombre()%></td>
                        <td><%=empleado.getapellido()%></td>
                        <td><%=empleado.getdni()%></td>
                        <td><%=empleado.gettelefono()%></td>
                        <td><%=empleado.getEmail()%></td>
                        <td><%=empleado.getid_departamento()%></td>
                        <td>
                            <br>
                            <a class="btni" href="Controlador?accion=editar&id=<%= empleado.getid_empleado()%>">Editar</a>
                            <a class="btni" href="Controlador?accion=Eliminar&id=<%= empleado.getid_empleado()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                <br>
                <a class="btn" href="Controlador?accion=Add">Agregar Empleado</a>
                <br>
                <br>
                <a class="btn" href="index.jsp">Regresar</a><br>
        </div>
    </body>
</html>
