<#import "Base.ftl" as base>

<@base.main>
    <#if user??>
        <div class="settings">
            <form action="ProfileEditServlet" method="post" enctype="multipart/form-data">
                <div class="change_photo">
                    <img src="/img?filename=${user.photo}">
                </div>
                <div class="union">
                    <div class="change_photo">
                        <p>Сменить аватарку</p>
                        <input name="filename" type="file" accept=".jpg, .jpeg, .png">
                    </div>
                    <div class="change_name">
                        <div class="first_name">
                            <p>${user.name}</p>
                            <input name="name" placeholder="Сменить Фамилию">
                        </div>
                        <div class="last_name">
                            <p>${user.surname}</p>
                            <input name="surname" placeholder="Сменить имя">
                        </div>
                    </div>
                    <div class="change_birth_date">
                        <p><#if user.dateBirthday??>${user.dateBirthday}
                            <#else>
                                Дата рождения:
                            </#if></p>
                        <input name="date" type="date">
                    </div>
                    <div class="change_gender">
                        <p>Пол:</p>
                        <#if user.gender == 'man'>
                            <label><input type="radio" value="man" name="gender" checked>Mужской</label>
                            <label><input type="radio" value="woman" name="gender">Женский</label>
                        <#else>
                            <label><input type="radio" value="man" name="gender">Mужской</label>
                            <label><input type="radio" value="woman" name="gender" checked>Женский</label>
                        </#if>
                    </div>
                </div>
                <div class="change_about_me">
                    <#if user.info??>
                        <textarea name="info">${user.info}</textarea>
                    <#else>
                        <textarea name="info" placeholder="Напиши тут о себе"></textarea>
                    </#if>
                    <button type="submit">Применить</button>
                </div>
            </form>
        </div>

        <div class="bottom">
            <div class="bottom__div">
            </div>
        </div>
        <#else>
            Чтобы редактировать профиль <a href="LoginServlet">авторизируйтесь</a>.
    </#if>

    <link rel="stylesheet" href="/SpaceDrive/css/profile_edit.css">
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