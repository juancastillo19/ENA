<%-- 
    Document   : index
    Created on : 15-06-2018, 16:08:45
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
         <form method="POST" action="Inicio">
             <h1>Autentificación</h1>
            <p>Usuario: <input type="text" name="txtUser" ></p>
            <p>Password: <input type="password" name="txtPass" ></p>
            <p><input type="checkbox" name="txtrecordar" value="Recordar"> Recordar</p>
            <p><input type="submit" name="btnButton"  value="Ingresar"></p>               
        </form>  

        <%
            HttpSession ses = request.getSession();
            String user = request.getParameter("txtUser");
            String pass = request.getParameter("txtPass");
            //ses.removeAttribute("usuario");
            try {
                String dato = request.getParameter("d");
                switch (Integer.parseInt(dato)) {
                    case 0:
                        out.println("<p>Debe ingresar datos</p>");
                        break;
                    case 1:
                        out.println("<p>Debe ingresar Usuario</p>");
                        break;
                    case 2:
                        out.println("<p>Debe ingresar Password</p>");
                        break;
                    case 3:
                        out.println("<p>Usuario no existe</p>");
                        break;
                    case 4:
                        out.println("<p>Sesion cerrada exitosamente</p>");
                        break;

                }

            } catch (Exception ex) {

            }


        %>
    </body>
</html>
