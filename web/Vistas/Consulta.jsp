<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/styles.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Consulta</title>
</head>
<body>
    <div class="containerB">
        <!-- Mostrar mensaje de error si existe -->
        <% if (request.getAttribute("error") != null) { %>
            <p style="color: red;"><%= request.getAttribute("error") %></p>
        <% } %>

        <!-- Formulario para ingresar el número de DNI -->
        <form action="HIngreso">
            <label for="dni"><h1>Por Favor Ingrese su Número de Documento:</h1></label><br>
            <input type="text" name="dni" id="dni" required><br><br>
            <input class="btn" type="submit" name="accion" value="Consulta"><br><br>
            <input class="btn" type="submit" name="accion" value="Listar"><br><br>
            <a class="btn" href="index.jsp"><b>Inicio</b></a>
        </form>
    </div>
</body>
</html>