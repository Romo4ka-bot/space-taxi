<%--
  Created by IntelliJ IDEA.
  User: romanleontev
  Date: 05.10.2020
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <script>
        function validate() {
            var username = document.form.username.value;
            var password = document.form.password.value;

            if (username == null || username === "") {
                alert("Username cannot be blank");
                return false;
            } else if (password == null || password === "") {
                alert("Password cannot be blank");
                return false;
            }
        }
    </script>
</head>
<body>
<div style="text-align:center">Привет</div>
<br>
<form name="form" action="LoginServlet" method="post" onsubmit="return validate()">
    <table align="center">
        <tr>
            <td>Username</td>
            <td><label>
                <input type="text" name="username"/>
            </label></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><label>
                <input type="password" name="password"/>
            </label></td>
        </tr>
        <tr>
            <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
                    : request.getAttribute("errMessage")%></span></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login"/><input
                    type="reset" value="Reset"/></td>
        </tr>
    </table>
</form>
</body>
</html>
