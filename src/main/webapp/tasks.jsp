<%--
  Created by IntelliJ IDEA.
  User: Dm
  Date: 21.05.2018
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tasks</title>
</head>
<body>
    <div>
        <div>
            <h3>Tasks list</h3>
        </div>
        <div>
            <ul>
                <c:forEach items="${requestScope.taskList}" var="task">
                    <li>
                        <div>Title:       ${task.title}</div>
                        <div>Description: ${task.description}</div>
                        <div>Create date: ${task.createdDate}</div>
                        <div>End date:    ${task.endDate}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div>
            <div>
                <h3>New task</h3>
            </div>
            <div>
                <form action="/tasks" method="post">
                    <div>
                        <input type="text" placeholder="Title">
                    </div>
                    <div>
                        <input type="text" placeholder="Description">
                    </div>
                    <div>
                        <button type="submit">Add</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
