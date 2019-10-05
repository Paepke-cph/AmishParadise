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
        <title>Members</title>
    </head>
    <body>
        <c:if test="${requestScope.allMembers.isEmpty()}">
            <h1>No members found</h1>
        </c:if>
        <c:forEach items="${requestScope.allMembers}" var="member">
            <ul>
                <li>Username: ${member.getUsername()}</li>
                <li>First name: ${member.getFirstName()}</li>
                <li>Last name: ${member.getLastName()}</li>
                <li>Gender: ${member.getGender()}</li>
                <li>Age; ${member.getAge()}</li>

                <img src="${member.getProfilePicture()}" alt="Profile Picture">
            </ul>
        </c:forEach>
    </body>
</html>
