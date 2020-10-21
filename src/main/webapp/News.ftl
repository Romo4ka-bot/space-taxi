<#import "Base.ftl" as base>

<@base.main>
    <div class="news">
        <div class="news_holder">
            <#list list as list>
                <div class="post">
                    <div class="post__image">
                        <img src="SpaceDrive/img/palnet_photo.jpg">
                    </div>
                    <div class="post__text">
                        <div class="text__heading">$(list.title)</div>
                        <div class="text__content">
                            <p>$(list.content)</p>
                        </div>
                        <div class="text__day">
                            <div class="day">$(list.date)</div>
                        </div>
                    </div>
                </div>
            </#list>

            <#--            <div class="post">-->
            <#--                <div class="post__image">-->
            <#--                    <img src="SpaceDrive/img/palnet_photo.jpg">-->
            <#--                </div>-->
            <#--                <div class="post__text">-->
            <#--                    <div class="text__heading">Как сделать цветную горизонтальную линию?</div>-->
            <#--                    <div class="text__content">-->
            <#--                        <p>Равным образом рамки и место обучения кадров обеспечивает широкому кругу (специалистов)-->
            <#--                            участие в формировании дальнейших направлений развития. Разнообразный и богатый опыт-->
            <#--                            новая модель организационной деятельности в значительной степени обуславливает создание-->
            <#--                            новых предложений. Разнообразный и богатый опыт новая модель организационной-->
            <#--                            деятельности в значительной степени.</p>-->
            <#--                    </div>-->
            <#--                    <div class="text__day">-->
            <#--                        <div class="day">12.10.2020</div>-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--            </div>-->

            <#--            <div class="post">-->
            <#--                <div class="post__image">-->
            <#--                    <img src="SpaceDrive/img/palnet_photo.jpg">-->
            <#--                </div>-->
            <#--                <div class="post__text">-->
            <#--                    <div class="text__heading">Как сделать цветную горизонтальную линию?</div>-->
            <#--                    <div class="text__content">-->
            <#--                        <p>Равным образом рамки и место обучения кадров обеспечивает широкому кругу (специалистов)-->
            <#--                            участие в формировании дальнейших направлений развития. Разнообразный и богатый опыт-->
            <#--                            новая модель организационной деятельности в значительной степени обуславливает создание-->
            <#--                            новых предложений. Разнообразный и богатый опыт новая модель организационной-->
            <#--                            деятельности в значительной степени.</p>-->
            <#--                    </div>-->
            <#--                    <div class="text__day">-->
            <#--                        <div class="day">12.10.2020</div>-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--            </div>-->

            <#--            <div class="post">-->
            <#--                <div class="post__image">-->
            <#--                    <img src="SpaceDrive/img/palnet_photo.jpg">-->
            <#--                </div>-->
            <#--                <div class="post__text">-->
            <#--                    <div class="text__heading">Как сделать цветную горизонтальную линию?</div>-->
            <#--                    <div class="text__content">-->
            <#--                        <p>Равным образом рамки и место обучения кадров обеспечивает широкому кругу (специалистов)-->
            <#--                            участие в формировании дальнейших направлений развития. Разнообразный и богатый опыт-->
            <#--                            новая модель организационной деятельности в значительной степени обуславливает создание-->
            <#--                            новых предложений. Разнообразный и богатый опыт новая модель организационной-->
            <#--                            деятельности в значительной степени.</p>-->
            <#--                    </div>-->
            <#--                    <div class="text__day">-->
            <#--                        <div class="day">12.10.2020</div>-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--            </div>-->
        </div>
    </div>
    <div class="bottom">
        <div class="pagination">
            <nav>
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="bottom__div">
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