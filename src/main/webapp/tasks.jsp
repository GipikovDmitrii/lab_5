<%--
  Created by IntelliJ IDEA.
  User: Dm
  Date: 21.05.2018
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
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
            <div><a href="/addTask"><button>Add task</button></a></div>
            <ul>
                <c:forEach items="${requestScope.taskList}" var="task">
                    <li>
                        <div>Title:${task.title}</div>
                        <div>Description:${task.description}</div>
                        <div>Create date:<fmt:formatDate value="${task.createdDate}" pattern="MM/dd/yy HH:mm"/></div>
                        <div>End date:<fmt:formatDate value="${task.endDate}" pattern="MM/dd/yy HH:mm"/></div>
                        <div><a href="/editTask?taskId=${task.id}"><button>Edit</button></a></div>
                        <div>
                            <form action="/tasks" method="post">
                                <input type="hidden" name="taskId" value="<c:out value="${task.id}"/>"/>
                                <input type="submit" value="Delete">
                            </form>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</body>
</html>
