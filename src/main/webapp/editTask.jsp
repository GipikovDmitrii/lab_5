<%--
  Created by IntelliJ IDEA.
  User: Dm
  Date: 28.05.2018
  Time: 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit task</title>
    <meta charset="UTF-8">
</head>
<body>
    <div>
        <div>
            <h3>Edit task</h3>
        </div>
        <div>
            <form action="/editTask" method="post">
                <div>
                    <input type="text" name="title" placeholder="Title" value="${task.title}">
                </div>
                <div>
                    <input type="text" name="description" placeholder="Description" value="${task.description}">
                </div>
                <div>
                    <input type="datetime-local" name="endDate" placeholder="Reminder">
                </div>
                <div>
                    <button type="submit">Edit task</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>