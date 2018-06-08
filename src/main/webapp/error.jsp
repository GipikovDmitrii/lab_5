<%--
  Created by IntelliJ IDEA.
  User: Dm
  Date: 11.05.2018
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
    <div>
    <% if(response.getStatus() == 500){ %>
        <div>
            <p>Error: <%=exception.getMessage() %></p>
        </div>
    <%} else {%>
        <div>
            <p>Hi There, error code is <%=response.getStatus() %></p>
            <p>Please go to <a href="/">home page</a></p>
        </div>
    <%} %>
    </div>
</body>
</html>
