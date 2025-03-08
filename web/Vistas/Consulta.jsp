<%-- 
    Document   : Consulta
    Created on : 14/12/2024, 8:13:21 a. m.
    Author     : AMAF
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta</title>
    </head>
    <body>
        <div>
            <!-- Formulario para ingresar el número de DNI -->
            <form action="HIngreso"> <!--action="Controlador"-->
                <label for="dni">Por Favor Ingrese su Número de Documento:</label><br><br>
                <input type="text" name="dni" id="dni" required><br><br>
                <input class="btn" type="submit" name="accion" value="Consulta"><br><br>
                <input class="btn" type="submit" name="accion" value="Listar"><br><br>
            </form>
        </div>
    </body>
</html>