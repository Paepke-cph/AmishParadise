<%-- 
    Document   : NavBar
    Created on : 08-10-2019, 08:20:21
    Author     : Benjamin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/uikit.min.css"/>
    </head>
    <body>
        <form action="FrontController" method="post">            
            <nav class="uk-navbar-container" uk-navbar>
                <div class="uk-navbar-left">
                    <ul class="uk-navbar-nav">
                        <li>
                            <button class="uk-button uk-button-default" name="cmd" value="home">Home</button>
                        </li>
                        <li> 
                            <button class="uk-button uk-button-default" name="cmd" value="testSearch">Search Members</button>
                        </li>
                    </ul>
                </div>
                <c:if test="${sessionScope.user == null}">
                    <div class="uk-navbar-right">
                        <ul class="uk-navbar-nav">
                            <li>
                                <div class="uk-margin">
                                    <div class="uk-inline">
                                        <span class="uk-form-icon" uk-icon="icon: user"></span>
                                        <input class="uk-input" type="text" name="username">
                                    </div>
                                </div> 
                            </li>
                            <li>
                                <div class="uk-margin">
                                    <div class="uk-inline">
                                        <span class="uk-form-icon uk-form-icon-flip" uk-icon="icon: lock"></span>
                                        <input class="uk-input" type="password" name="password">
                                    </div>
                                </div>
                            </li>
                            <li> <button class="uk-button uk-button-default" name="cmd" value="login">Login</button> </li>
                            <li> <button class="uk-button uk-button-default" name="cmd" value="register">Register</button> </li>
                        </ul>
                    </div>
                </c:if>
                <c:if test="${sessionScope.user != null}" >
                    <div class="uk-navbar-right">
                        <ul class="uk-navbar-nav">
                            <li> <button class="uk-button uk-button-default" name="cmd" value="userHome">Profile</button> </li>
                            <li> <button class="uk-button uk-button-default" name="cmd" value="logout">Logout</button> </li>
                        </ul>
                    </div>
                </c:if>
            </nav>
        </form>
        <script src="js/jquery.js"></script>
        <script src="js/uikit.min.js"></script>
        <script src="js/uikit-icons.min.js"></script>
    </body>
</html>
