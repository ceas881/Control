<%-- 
    Document   : registrar_salida
    Created on : 25/02/2025, 2:16:38 p. m.
    Author     : AMAF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
    </head>
    <body>
        <h1>Registro de Producción!</h1>
        <form action="HIngreso" method="POST">
            <input type="hidden" name="accion" value="Guardar Salida">
            <input type="hidden" name="dni" value="${dni}">

            <label for="producto">Producto:</label>
            <select name="producto" id="producto">
                <c:forEach var="prod" items="${listaProductos}">
                    <option value="${prod.codigo}">${prod.nombre}</option>
                </c:forEach>
            </select>

            <label for="cantidad">Cantidad:</label>
            <input type="number" name="cantidad" id="cantidad" min="1">
            <br><br>
            <button type="submit">Guardar Salida</button>
        </form>

    </body>
</html>