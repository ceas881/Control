<%-- 
    Document   : Editp
    Created on : 10/12/2024, 11:01:12 a. m.
    Author     : AMAF
--%>

<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page import="java.util.List"%>
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
                ProductoDAO productoDAO = new ProductoDAO();
                int codigo = Integer.parseInt((String)request.getAttribute("codigo"));
                Producto producto = (Producto)productoDAO.list(codigo);
            %>
            <section class="containerE">
        <h1>Editar Producto</h1>
        <form action="Controladorp">
            NOMBRE: <br>
            <input type="text" name="txtnombre" value="<%= producto.getnombre()%>"><br>
            INVENTARIO: <br>
            <input type="text" name="txtinventario" value="<%= producto.getinventario()%>"><br>
            <br>
            <input type="hidden" name="txtcodigo" value="<%= producto.getcodigo()%>"><br>
            <input class="btn" type="submit" name="accion" value="Actualizar"><br><br>
            <a class="btn" href="Controladorp?accion=listar">Regresar</a>
        </form>
            </section>
        </div>
    </body>
</html>
