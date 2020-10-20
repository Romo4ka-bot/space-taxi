<#import "Base.ftl" as base>

<@base.main>
    <div class="settings">
        <form method="post">
            <div class="change_photo">
                <img src="SpaceDrive/img/icon-spaceman.jpg">
            </div>
            <div class="union">
                <div class="change_photo">
                    <p>Сменить аватарку</p>
                    <input type="file" accept=".jpg, .jpeg, .png">
                </div>
                <div class="change_name">
                    <p>Иванов Иван Иванович</p>
                    <input placeholder="Сменить имя">
                </div>
                <div class="change_birth_date">
                    <p>16.10.2020</p>
                    <input type="date">
                </div>
                <div class="change_gender">
                    <p>Пол:</p>
                    <label><input type="radio" name="gender" checked>Mужской</label>
                    <label><input type="radio" name="gender">Женский</label>
                </div>
            </div>
            <div class="change_about_me">
                <textarea placeholder="Напиши тут о себе"></textarea>
                <button type="submit">Применить</button>
            </div>
        </form>
    </div>

    <div class="bottom">
        <div class="bottom__div">
        </div>
    </div>

    <link rel="stylesheet" href="/SpaceDrive/css/profile_edit.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</@base.main>