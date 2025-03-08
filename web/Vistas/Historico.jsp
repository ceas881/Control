<%-- 
    Document   : Historico
    Created on : 23/12/2024, 9:14:08 a. m.
    Author     : AMAF
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ConsultaDAO"%>
<%@page import="Modelo.Consultae"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historico</title>
    </head>
    <body>
        <br>
        <a class="btn" href="index.jsp">Inicio</a><br>
        <form action="HIngreso">
        <input class="btn" type="submit" name="accion" value="Consulta"><br><br>
        <from>
        <div>
            <h1>HISTORICO</h1>
        <table border="1">
            <thead>
            <tr>
                <th>DNI</th>
                <th>Fecha</th>
                <th>Hora Ingreso</th>
                <th>Hora Salida</th>
            </tr>
            </thead>
                <%
                    ConsultaDAO dao = new ConsultaDAO();
                    List<Consultae> list = dao.Listar();
                    Iterator<Consultae> iter = list.iterator();
                    Consultae consultae = null;

                    while (iter.hasNext()) {
                        consultae = iter.next();
                %> 
                <tbody>
                <tr>
                    <td><%=consultae.getDni()%></td>
                    <td><%=consultae.getfecha()%></td>
                    <td><%=consultae.gethora_ingreso()%></td>
                    <td><%=consultae.gethora_salida()%></td>
                </tr>
                <%}%>
                </tbody>
        </table>
        </div>
    </body>
</html>