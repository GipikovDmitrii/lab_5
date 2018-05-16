<%--
  Created by IntelliJ IDEA.
  User: Dm
  Date: 07.05.2018
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tasks</title>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Created date</th>
            <th>End date</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.taskList}" var="task">
            <tr>
                <td>${task.id}</td>
                <td>${task.title}</td>
                <td>${task.description}</td>
                <td>${task.createdDate}</td>
                <td>${task.endDate}</td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
