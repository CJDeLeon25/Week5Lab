<%-- 
    Document   : login
    Created on : 12-Oct-2020, 10:35:08 PM
    Author     : 798676
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method = "post">
            Username: <input type ="text" value ="${username}" name ="username"><br>
            Password: <input type ="text" value ="${password}" name ="password"><br>
            <input type ="submit" value ="Login">
            
        </form>
    </body>
</html>
