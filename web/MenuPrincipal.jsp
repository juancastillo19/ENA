<%-- 
    Document   : MenuPrincipal
    Created on : 15-06-2018, 23:41:19
    Author     : Juanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <form class="caja" method="POST" action="">
            <h1>Menu principal</h1>
            <p>Usuario: <input type="text" name="txtUser" ></p>
            <p>Password: <input type="password" name="txtPass" ></p>
            <p><input type="checkbox" name="txtrecordar" value="Recordar"> Recordar</p>
            <p><input type="submit" name="btnButton"  value="Ingresar"></p>
        </form>
    </center>
</body>
</html>
