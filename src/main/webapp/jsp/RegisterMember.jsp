<%-- 
    Document   : RegisterMember
    Created on : 06-10-2019, 19:32:49
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/uikit.min.css"/>
        <title>Register Member</title>
    </head>
    <body>
        <%@include file="NavBar.jsp"%>
        <form class="form-horizontal-text uk-width-1-2" action="FrontController" method="post">
            <div class="uk-margin">
                <label class="uk-form-label" for="form-horizontal-text">First name</label>
                <div class="uk-form-controls">
                    <input class="uk-input" id="form-horizontal-text" type="text" placeholder="..." name="firstName">
                </div>
            </div>
            <div class="uk-margin">
                <label class="uk-form-label" for="form-horizontal-text">Last name</label>
                <div class="uk-form-controls">
                    <input class="uk-input" id="form-horizontal-text" type="text" placeholder="..." name="lastName">
                </div>
            </div>
            <div class="uk-margin">
                <label class="uk-form-label" for="form-horizontal-text">Gender</label>
                <div class="uk-form-controls">
                    <select class="uk-select" id="form-horizontal-text" name="gender">
                        <option>Female</option>
                        <option>Male</option>
                    </select>
                </div>
            </div>

            <div class="uk-margin">
                <label class="uk-form-label" for="form-stacked-text">Username</label>
                <div class="uk-inline">
                    <span class="uk-form-icon" uk-icon="icon: user"></span>
                    <input class="uk-input" type="text" name="username">
                </div>
            </div>
            <div- class="uk-margin">
                <label class="uk-form-label" for="form-stacked-text">Password</label>
                <div class="uk-inline">
                    <span class="uk-form-icon uk-form-icon-flip" uk-icon="icon: lock"></span>
                    <input class="uk-input" type="password" name="password">
                </div>
            </div>
            <button class="uk-button uk-button-default" name="cmd" value="createMember">Register</button>
        </form>
        <script src="js/jquery.js"></script>
        <script src="js/uikit.min.js"></script>
    </body>
</html>
