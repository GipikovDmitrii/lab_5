<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dm
  Date: 29.05.2018
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
    <div>
        <div>
            <h3>Users list</h3>
        </div>
        <div>
            <table>
                <tr>
                    <th>User ID</th>
                    <th>Login</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Role</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${requestScope.userList}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.login}</td>
                        <td>${user.email}</td>
                        <td>${user.password}</td>
                        <td>${user.role.role}</td>
                        <td>
                            <form action="/admin" method="post">
                                <input type="hidden" name="userId" value="<c:out value="${user.id}"/>" />
                                <input type="submit" value="Delete">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
