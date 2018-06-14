<%--
  Created by IntelliJ IDEA.
  User: Dm
  Date: 28.05.2018
  Time: 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add task</title>
    <meta charset="UTF-8">
</head>
<body>
<div>
    <div>
        <h3>New task</h3>
    </div>
    <div>
        <form action="/tasks/addTask" method="post">
            <div>
                <input type="text" name="title" placeholder="Title">
            </div>
            <div>
                <input type="text" name="description" placeholder="Description">
            </div>
            <div>
                <input type="datetime-local" name="endDate" placeholder="Reminder">
            </div>
            <div>
                <button type="submit">Add task</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
