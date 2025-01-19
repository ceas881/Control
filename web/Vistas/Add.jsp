<%-- 
    Document   : Add
    Created on : 10/12/2024, 10:16:46 a. m.
    Author     : AMAF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="./css/styles.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar</title>
    </head>
    <body>
        <div class="containerE">
            <h1>Agregar Empleado</h1>
            <form action"Controlador">
                NOMBRE: <br>
                <input type="text" name="txtnombre"><br>
                APELLIDO: <br>
                <input type="text" name="txtapellido"><br>
                DNI: <br>
                <input type="text" name="txtdni"><br><%--No puede replicarse el documento porque genera error o no se agregar--%>
                TELEFONO: <br>
                <input type="text" name="txttelefono"><br>
                EMAIL: <br>
                <input type="text" name="txtEmail"><br>
                ID DEPARTAMENTO: <br>
                <input type="text" name="txtid_departamento"><br>
                <br>
                <input class="btn" type="submit" name="accion" value="Agregar Empleado"><br>
                <br>
                <a class="btn" href="Controlador?accion=Listar">Regresar</a><br>
            </form>
        </div>
    </body>
</html>
