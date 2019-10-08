<%-- 
    Document   : UserHome
    Created on : 07-10-2019, 17:02:11
    Author     : Benjamin
--%>

<%@page import="core.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/uikit.min.css"/>
        <title>Home</title>
    </head>
    <body>
        <%@include file="NavBar.jsp"%>
        <%
            Member member = (Member)session.getAttribute("user");
            String fullName = member.getFirstName() + " " + member.getLastName();
        %>
        <form class="uk-grid-small" uk-grid>
            <div class="uk-width-1-1">
                <input class="uk-input" type="text" placeholder="100" value="<%=fullName%>">
            </div>
            <div class="uk-width-1-2">
                <input class="uk-input" type="text" placeholder="50" value="${sessionScope.user.getUsername()}">
            </div>
            <div class="uk-width-1-4">
                <input class="uk-input" type="text" placeholder="25" value="<%=member.getGender().getText()%>">
            </div>
            <div class="uk-width-1-4">
                <input class="uk-input" type="text" placeholder="25">
            </div>
            <div class="uk-width-1-2">
                <input class="uk-input" type="text" placeholder="50">
            </div>
            <div class="uk-width-1-2">
                <input class="uk-input" type="text" placeholder="50">
            </div>
        </form>
        <script src="js/jquery.js"></script>
        <script src="js/uikit.min.js"></script>
    </body>
</html>
