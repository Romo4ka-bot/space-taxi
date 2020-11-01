<#import "Base.ftl" as base>

<@base.main>
    <div>
        <span style="display: flex;  justify-content: center">Интересные новости от наших клиентов</span>
        <#if user??>
            <button type="button" class="btn btn-primary" data-toggle="modal"
                    data-target="#staticBackdrop" style="display: flex;  justify-content: center">
                Создать новость
            </button>
        <#else>
            Чтобы создать новость <a href="LoginServlet">авторизируйтесь</a>
        </#if>
    </div>
    <div class="news">
        <div class="news_holder">
            <#list list as list>
                <div class="post">
                    <div class="post__image">
                        <img src=/img?filename=${list.photo}>
                    </div>
                    <div class="post__text">
                        <div class="text__heading">${list.title}</div>
                        <div class="text__content">
                            <p>${list.content}</p>
                        </div>
                        <div class="text__day">
                            <div class="day">${list.date}</div>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
    <div class="bottom">
        <#--        <div class="pagination">-->
        <#--            <nav>-->
        <#--                <ul class="pagination">-->
        <#--                    <li class="page-item">-->
        <#--                        <a class="page-link" href="#" aria-label="Previous">-->
        <#--                            <span aria-hidden="true">&laquo;</span>-->
        <#--                            <span class="sr-only">Previous</span>-->
        <#--                        </a>-->
        <#--                    </li>-->
        <#--                    <li class="page-item"><a class="page-link" href="#">1</a></li>-->
        <#--                    <li class="page-item"><a class="page-link" href="#">2</a></li>-->
        <#--                    <li class="page-item"><a class="page-link" href="#">3</a></li>-->
        <#--                    <li class="page-item">-->
        <#--                        <a class="page-link" href="#" aria-label="Next">-->
        <#--                            <span aria-hidden="true">&raquo;</span>-->
        <#--                            <span class="sr-only">Next</span>-->
        <#--                        </a>-->
        <#--                    </li>-->
        <#--                </ul>-->
        <#--            </nav>-->
        <#--        </div>-->
        <div class="bottom__div">
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Напишите вашу новость</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="NewsServlet" method="post" enctype="multipart/form-data">
                    <div class="modal-body">
                            <div class="form-group">
                                <label for="title" class="col-form-label">Название:</label>
                                <textarea name="title" class="form-control" id="title" required></textarea>
                            </div>
                            <div class="form-group">
                                <label for="content" class="col-form-label">Содержание:</label>
                                <textarea name="content" class="form-control" id="content" required></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="photo" class="col-form-label">Фотография:</label>
                            <input name="photo" type="file" accept=".jpg, .jpeg, .png" class="form-control" id="photo">
                        </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                        <button type="submit" class="btn btn-primary">Отправить</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <link rel="stylesheet" href="/SpaceDrive/css/news.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="SpaceDrive/js/feed.js"></script>
</@base.main>