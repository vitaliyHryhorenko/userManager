<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>

</head>
<body>
    <h1>Add user</h1>
    <form action="/user/add" method="post">
        <span>Name:</span><input type="text" name="name"/><br>
        <span>Email:</span><input type="text" name="email"/><br>
        <span>Address:</span><br>
        <span>Street:</span><input type="text" name="street"/><br>
        <span>City:</span><input type="text" name="city"/><br>
        <span>Role:</span><input type="text" name="roleName"/><br>
        <input type="submit" value="Submit" class = "button"/>
    </form>
    <br>
    <c:if test="${empty users}">
        <h3>List is empty</h3>
    </c:if>
    <c:if test="${!empty users}">
        <h1>User list</h1>
        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Role</th>
                <th>Edit</th>
                <th>Remove</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.address}</td>
                    <td>
                        <ul>
                            <c:forEach var="role" items="${user.roles}">
                                <li>${role.name}</li>
                            </c:forEach>
                        </ul>
                    </td>
                    <td><a href="<c:url value="/edit/${user.userId}"/>">Edit</a></td>
                    <td><a href="<c:url value="/remove/${user.userId}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>