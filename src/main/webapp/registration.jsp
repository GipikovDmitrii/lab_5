<%--
  Created by IntelliJ IDEA.
  User: Dm
  Date: 01.05.2018
  Time: 5:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
    <form action="/registration" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td><input class="button" type="submit" value="Registration"></td>
            </tr>
        </table>
    </form>

</body>
</html>
