<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
<div style="text-align:center">Привет</div>
<br>
<form name="form" action="RegistrationServlet" method="post">
    <table align="center">
        <tr>
            <td>Lodin</td>
            <td>
                <label>
                    <input type="text" name="login"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><label>
                    <input type="password" name="password"/>
                </label></td>
        </tr>
        <tr>
            <td><span style="color:red"><#if errMessage??>${errMessage}</#if></span></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Registration"><input
                        type="reset" value="Reset"></td>
        </tr>
    </table>
</form>
</body>
</html>