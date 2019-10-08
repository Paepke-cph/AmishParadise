<%-- 
    Document   : SearchResult
    Created on : 05-10-2019, 17:03:28
    Author     : Benjamin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/uikit.min.css"/>
        <title>Members</title>
    </head>
    <body>
        <%@include file="NavBar.jsp"%>
        <c:if test="${requestScope.allMembers.isEmpty()}">
            <h1>No members found</h1>
        </c:if>
        <div class="uk-grid-small uk-child-width-1-2 uk-text-center" uk-grid>
            <c:forEach items="${requestScope.allMembers}" var="member">
                <div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-media-top">
                            <img data-src="${member.getProfilePicture()}" width="300" height="300" alt="" uk-img>
                        </div>
                        <div class="uk-card-body">
                            <h3 class="uk-card-title">${member.getUsername()}</h3>
                            <p>${member.getFirstName()} ${member.getLastName()}</p>
                            <p>${member.getGender().getText()}</p>
                            <p>Age: ${member.getAge()}</p>
                        </div>
                        <c:if test="${member.getBio() != null || member.getBio().length() == 0}">
                            <div class="uk-card-footer">
                                <p>${member.getBio()}</p>
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </div>
        <script src="js/jquery.js"></script>
        <script src="js/uikit.min.js"></script>
    </body>
</html>
