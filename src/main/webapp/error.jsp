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
    <title>Error</title>
    <meta charset="UTF-8">
</head>
<body>
    <div>
        <h3>Error</h3>
        <h4><b>Exception:</b><br></h4>
        <p><i>${pageContext.exception.message}</i><p>
    </div>
</body>
</html>
