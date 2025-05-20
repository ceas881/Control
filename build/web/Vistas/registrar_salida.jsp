<%-- 
    Document   : registrar_salida
    Created on : 25/02/2025, 2:16:38 p. m.
    Author     : AMAF
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/styles.css" rel="stylesheet" type="text/css"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
    </head>
    <body>
        <div class="containerB">
        <h1>Registro de Producción!</h1>
        <form action="HIngreso" method="get">
    <label>Producto:
        <select name="codigo">
            <c:forEach var="producto" items="${productos}">
                <option value="${producto.codigo}">${producto.nombre}</option>
            </c:forEach>
        </select>
    </label>
    <label>Cantidad:
        <input type="number" name="cantidad">
    </label>
    <input type="hidden" name="accion" value="GuardarSalida">
    <button type="submit">Guardar Salida</button>
</form>
        </div>
                <!-- Tabla Productos -->
                <div class="container">
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
    </body>
</html>