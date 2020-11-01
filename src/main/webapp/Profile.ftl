<#import "Base.ftl" as base>

<@base.main>
    <#if user??>
        <div class="users_profile">
            <div class="edit">
                <img class="users_photo" src="/img?filename=${user.photo}"><br>
                <p><a href="ProfileEditServlet"><img src="SpaceDrive/img/settings.png">Редактировать</a></p>
            </div>
            <div class="users_information">
                <p class="fio"><span>${user.name} ${user.surname}</span></p>
                <p class="email"><span>E-mail: </span>${user.login}</p>
                <p class="birth_date"><span>Дата рождения: </span><#if user.dateBirthday??>${user.dateBirthday}</#if></p>
                <p class="register_date"><span>Дата регистрации: </span><#if user.dateRegistration??>${user.dateRegistration}</#if></p>
                <p class="gender"><span>Пол: </span>${user.gender}</p>
            </div>
            <div class="about_me">
                <p><span>Обо мне: </span><#if user.info??>${user.info}</#if></p>
            </div>
        </div>

        <div class="bottom">
            <div class="bottom__div">
            </div>
        </div>
    </#if>

    <link rel="stylesheet" href="/SpaceDrive/css/profile.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</@base.main>