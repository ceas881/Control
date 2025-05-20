<%-- 
    Document   : Hingreso
    Created on : 14/12/2024, 8:13:55 a. m.
    Author     : AMAF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/styles.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>H_Ingreso</title>
    </head>
    <body>
        <div class="containerB">
        <h1>Fecha y Hora del Sistema</h1>
    <form action="HIngreso">
        <label for="fecha">Fecha:</label><br>
        <input type="text" name="fecha" value="${requestScope.fecha}" readonly><br><br>
        <label for="hora">Hora de Ingreso:</label><br>
        <input type="text" name="hora" value="${requestScope.hora}" readonly><br><br>
            <!-- Formulario para ingresar el número de DNI -->
            <!--action="Controlador"-->
        <label for="dni">Por Favor Ingrese su Número de Documento:</label><br><br>
        <input type="text" name="dni" id="dni" required><br><br>
        <input class="btn" type="submit" name="accion" value="Consulta"><br><br>
    </form>
        </div>
</body>
</html>
