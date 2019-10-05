<%-- 
    Document   : index
    Created on : 05-10-2019, 16:32:33
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Armish Paradise</title>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/uikit.min.css"/>
    </head>
    <body>
        <h1>Armish Paradise</h1>
        <form action="FrontController">
            <button class="uk-button uk-button-default">Search Members</button>
            <input type="hidden" name="cmd" value="testSearch">
        </form>

        <script src="js/jquery.js"></script>
        <script src="js/uikit.min.js"></script>
    </body>
</html>
