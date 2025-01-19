<%-- 
    Document   : Productos
    Created on : 10/12/2024, 11:12:09 a. m.
    Author     : AMAF
--%>

<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="./css/styles.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        <br>
        <h1 class="content">Productos</h1>
        <div class="containerP"><%--listar producto--%>
            <table border="1">
                <thead>
                    <tr>
                        <th>CODIGO</th>
                        <th>NOMBRE</th>
                        <th>INVENTARIO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    ProductoDAO dao = new ProductoDAO();
                    List<Producto> list = dao.listar();
                    Iterator<Producto> iter = list.iterator();
                    Producto producto = null;

                    while (iter.hasNext()) {
                        producto = iter.next();
                %>                
                <tbody>
                    <tr>
                        <td><%=producto.getcodigo()%></td>
                        <td><%=producto.getnombre()%></td>
                        <td><%=producto.getinventario()%></td>
                        <td>
                            
                            <a class="btn1" href="Controladorp?accion=Editar&codigo=<%= producto.getcodigo()%>">Editar</a>
                            <a class="btn1" href="Controladorp?accion=Eliminar&codigo=<%= producto.getcodigo()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <br>
            <%--<a class="btn" href="Condex?accion=Addp">Agregar Producto</a>--%>
        <%--agregar producto--%>
        <aside class="sidebar">
            <h2>Agregar Producto</h2>
            <form action"Controladorp">
                NOMBRE: <br>
                <input type="text" name="txtnombre"><br>
                INVENTARIO: <br>
                <input type="text" name="txtinventario"><br>
                <br>
                <input class="btn" type="submit" name="accion" value="Agregar Producto"><br>
                <br>
                <a class="btn" href="index.jsp">Regresar</a><br>
            </form>
        </aside>
        </div>
    </body>
</html>
