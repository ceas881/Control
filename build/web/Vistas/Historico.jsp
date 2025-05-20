<%-- 
    Document   : Historico
    Created on : 23/12/2024, 9:14:08 a. m.
    Author     : AMAF
--%>

<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ConsultaDAO"%>
<%@page import="Modelo.Consultae"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/styles.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Historico</title>
    <style>
        .container {
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
        }
        table {
            border-collapse: collapse;
            margin: 10px;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
        }
    </style>
                        <a class="btn" href="index.jsp">Inicio</a>
                        <a class="btn" href="HIngreso?accion=Consultas">Registro</a>
</head>
<body>
    <div class="container">
        <!-- Tabla Historial -->
        <div>
            <h1>HISTORICO</h1>
            <table>
                <thead>
                    <tr>
                        <th>DNI</th>
                        <th>Fecha</th>
                        <th>Hora Ingreso</th>
                        <th>Hora Salida</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ConsultaDAO historialDao = new ConsultaDAO();
                        List<Consultae> historial = historialDao.Listar();
                        for (Consultae c : historial) {
                    %>
                    <tr>
                        <td><%=c.getDni()%></td>
                        <td><%=c.getfecha()%></td>
                        <td><%=c.gethora_ingreso()%></td>
                        <td><%=c.gethora_salida()%></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <!-- Tabla Productos -->
        <div>
            <h1>INVENTARIO</h1>
            <table>
                <thead>
                    <tr>
                        <th>NOMBRE</th>
                        <th>INVENTARIO</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ProductoDAO productoDao = new ProductoDAO();
                        List<Producto> productos = productoDao.listar();
                        for (Producto p : productos) {
                    %>
                    <tr>
                        <td><%=p.getnombre()%></td>
                        <td><%=p.getinventario()%></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>