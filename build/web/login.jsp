<%-- 
    Document   : login
    Created on : 25/04/2025, 8:15:54 p. m.
    Author     : AMAF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticación - Fijaciones Torres</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="containerB">
            <h2>Autenticación requerida</h2>
            <%
                String error = request.getParameter("error");
                if(error != null && error.equals("1")) {
                    out.println("<p style='color:red'>Usuario o contraseña incorrectos</p>");
                }
            %>
            <form action="AuthController" method="POST">
                <input type="hidden" name="redirect" value="<%= request.getParameter("redirect") %>">
                <div>
                    <label for="username">Usuario:</label>
                    <br>
                    <input type="text" id="username" name="username" required>
                </div>
                <br>
                <div>
                    <label for="password">Contraseña:</label>
                    <br>
                    <input type="password" id="password" name="password" required>
                </div>
                <br>
                <button type="submit" class="btn">Ingresar</button>
            </form>
                <br>
                <form action="Hingreso" method="POST">
                            <a class="btn" href="index.jsp"><b>Regresar</b></a>
                </form>
        </div>
    </body>
</html>