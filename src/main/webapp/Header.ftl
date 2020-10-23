<div class="content">
    <nav class="navbar navbar-expand-lg navbar-dark">
        <a class="navbar-brand" href="#">SpaceDrive</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="HomeServlet">Домашняя</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FeedServlet">Путевки</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ProfileServlet">Профиль</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="NewsServlet">Новости</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="InfoServlet">Про нас</a>
                </li>
            </ul>
            <#if user??>
                <ul class="navbar-nav navbar-right">
                    <li class="nav-item active">
                        <a class="nav-link" href="LogoutServlet">Выйти</a>
                    </li>
                </ul>
                <#else>
                    <ul class="navbar-nav navbar-right">
                        <li class="nav-item active">
                            <a class="nav-link" href="LoginServlet">Войти</a>
                        </li>
                    </ul>
            </#if>
        </div>
    </nav>
</div>
