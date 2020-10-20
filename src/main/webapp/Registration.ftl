<#--<!doctype html>-->
<#--<html lang="en">-->
<#--<head>-->
<#--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
<#--    <title>Login</title>-->
<#--</head>-->
<#--<body>-->
<#--<div style="text-align:center">Привет</div>-->
<#--<br>-->
<#--<form name="form" action="RegistrationServlet" method="post">-->
<#--    <table align="center">-->
<#--        <tr>-->
<#--            <td>Lodin</td>-->
<#--            <td>-->
<#--                <label>-->
<#--                    <input type="text" name="login"/>-->
<#--                </label>-->
<#--            </td>-->
<#--        </tr>-->
<#--        <tr>-->
<#--            <td>Password</td>-->
<#--            <td><label>-->
<#--                    <input type="password" name="password"/>-->
<#--                </label></td>-->
<#--        </tr>-->
<#--        <tr>-->
<#--            <td>Name</td>-->
<#--            <td><label>-->
<#--                    <input type="password" name="name"/>-->
<#--                </label></td>-->
<#--        </tr>-->
<#--        <tr>-->
<#--            <td>Surname</td>-->
<#--            <td><label>-->
<#--                    <input type="password" name="surname"/>-->
<#--                </label></td>-->
<#--        </tr>-->
<#--        <tr>-->
<#--            <td>Gender</td>-->
<#--            <td><label>-->
<#--                    <input type="password" name="gender"/>-->
<#--                </label></td>-->
<#--        </tr>-->
<#--        <tr>-->
<#--            <td><span style="color:red"><#if errMessage??>${errMessage}</#if></span></td>-->
<#--        </tr>-->
<#--        <tr>-->
<#--            <td></td>-->
<#--            <td><input type="submit" value="Registration"><input-->
<#--                        type="reset" value="Reset"></td>-->
<#--        </tr>-->
<#--    </table>-->
<#--</form>-->
<#--</body>-->
<#--</html>-->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="SpaceDrive/css/login.css">
    <title>Registration</title>
</head>
<body>
<div class="wrapper">
    <header class="header">

    </header>
    <div class="page">
        <div class="page__image">
            <img src="SpaceDrive/img/space-shuttle.jpg">
        </div>
        <div class="page__login">
            <div class="login_container">
                <div class="login__welcome">
                    <div class="login__welcome__text">Sign up</div>
                </div>

                <div class="login__form">
                    <div id="error_text" class="error_text"></div>
                    <form id="form" method="post">

                        <div class="form__input">
                            <div class="input__icon">
                                <div class="white_icon">
                                    <img src="SpaceDrive/img/dot.png">
                                </div>
                                <div class="yellow_icon">
                                    <img src="SpaceDrive/img/dot-active.png">
                                </div>
                            </div>
                            <div class="input__div">
                                <div class="input__text">Name</div>
                                <input name="first_name" id="first_name" class="input" type="text">
                            </div>
                        </div>
                        <div class="form__input">
                            <div class="input__icon">
                                <div class="white_icon">
                                    <img src="SpaceDrive/img/dot.png">
                                </div>
                                <div class="yellow_icon">
                                    <img src="SpaceDrive/img/dot-active.png">
                                </div>
                            </div>
                            <div class="input__div">
                                <div class="input__text">Second name</div>
                                <input name="second_name" id="second_name" class="input" type="text">
                            </div>
                        </div>
                        <div class="form__input">
                            <div class="input__icon">
                                <div class="white_icon">
                                    <img src="SpaceDrive/img/dot.png">
                                </div>
                                <div class="yellow_icon">
                                    <img src="SpaceDrive/img/dot-active.png">
                                </div>
                            </div>
                            <div class="input__div">
                                <div class="input__text">Email</div>
                                <input name="email" id="login" class="input" type="text">
                            </div>
                        </div>
                        <div class="form__radio">
                            <div class="radio__gender">Gender:</div>
                            <div class="radio__gender">
                                <input type="radio" name="gender" value="man" checked>
                                <div class="gender__text">Man</div>
                            </div>
                            <div class="radio__gender">
                                <input type="radio" name="gender" value="woman">
                                <div class="gender__text">Woman</div>
                            </div>
                        </div>
                        <div class="form__input">
                            <div class="input__icon">
                                <div class="white_icon">
                                    <img src="SpaceDrive/img/dot.png">
                                </div>
                                <div class="yellow_icon">
                                    <img src="SpaceDrive/img/dot-active.png">
                                </div>
                            </div>
                            <div class="input__div">
                                <div class="input__text">Password</div>
                                <input name="password1" id="password1" class="input" type="text">
                            </div>
                        </div>
                        <div class="form__input">
                            <div class="input__icon">
                                <div class="white_icon">
                                    <img src="SpaceDrive/img/dot.png">
                                </div>
                                <div class="yellow_icon">
                                    <img src="SpaceDrive/img/dot-active.png">
                                </div>
                            </div>
                            <div class="input__div">
                                <div class="input__text">Password</div>
                                <input name="password2" id="password2" class="input" type="text">
                            </div>
                        </div>
                        <div class="form__btn">
                            <input type="submit" class="button" value="Submit">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="SpaceDrive/js/registration.js"></script>
</body>
</html>