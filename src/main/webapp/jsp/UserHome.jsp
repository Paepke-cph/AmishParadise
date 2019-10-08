<%-- 
    Document   : UserHome
    Created on : 07-10-2019, 17:02:11
    Author     : Benjamin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="uk-grid-small uk-child-width-1-1 uk-text-center" uk-grid>
            <div class="uk-card uk-card-default">
                <div class="uk-card-media-top">
                    <c:if test="${sessionScope.user.getProfilePicture() != null}">
                        <img data-src="${sessionScope.user.getProfilePicture()}" width="300" height="300" alt="" uk-img>
                    </c:if>
                    <c:if test="${sessionScope.user.getProfilePicture() == null}">
                        <img data-src="/images/missingProfilePic.jpg" width="300" height="300" alt="" uk-img>
                    </c:if>
                </div>
                <div class="uk-card-body">
                    <h3 class="uk-card-title">${sessionScope.user.getUsername()}</h3>
                    <p>${sessionScope.user.getFirstName()} ${sessionScope.user.getLastName()}</p>
                    <p>${sessionScope.user.getGender().getText()}</p>
                    <p>Age: ${sessionScope.user.getAge()}</p>
                </div>
                <c:if test="${sessionScope.user.getBio() != null || sessionScope.user.getBio().length() == 0}">
                    <div class="uk-card-footer">
                        <p>${sessionScope.user.getBio()}</p>
                    </div>
                </c:if>
            </div>
            <form action="UploadServlet" method="post"
                  enctype="multipart/form-data">
                <div class="uk-margin">
                    <input type="file" name="file" size="50" />
                </div>
                <br/>
                <button class="uk-button uk-button-default" name="cmd" value="Upload">Upload Picture</button>
            </form>
            <form action="FrontController">
                <div class="uk-margin">
                    <label class="uk-form-label" for="form-stacked-text">Biography</label>
                    <input class="uk-textarea" type="text" name="bio">
                </div>
                <br/>
                <button class="uk-button uk-button-default" name="cmd" value="updateMember">Update Bio</button>
            </form>
        </div>
        <script src="js/jquery.js"></script>
        <script src="js/uikit.min.js"></script>
    </body>
</html>
