<%-- 
    Document   : Addp
    Created on : 10/12/2024, 10:17:28 a. m.
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
            <h1>Agregar Producto</h1>
            <form action"Controladorp">
                NOMBRE: <br>
                <input type="text" name="txtnombre"><br>
                INVENTARIO: <br>
                <input type="text" name="txtinventario"><br>
                <br>
                <input class="btn" type="submit" name="accion" value="Agregar Producto"><br>
                <br>
                <a class="btn" href="Controladorp?accion=listar">Regresar</a><br>
            </form>
        </div>
    </body>
</html>
