<#import "Base.ftl" as base>

<@base.main>
    <#if feed??>
        <div class="ticket_container">
            <div class="ticket_div">
                <div class="ticket__image">
                    <img src="SpaceDrive/img/mars_image.jpg">
                </div>
                <div class="ticket__information">
                    <div class="information__head">
                        Travel information
                    </div>
                    <div class="information__text">
                        <p>${feed.content}</p>
                    </div>
                    <div class="ticket__prise">
                        <div class="prise__day">
                            <div class="count__date">${feed.dateTo} - ${feed.dateFrom}</div>
                            <div class="count__inf">${feed.description}</div>
                        </div>
                        <div class="prise__buy">
                            <div class="prise__count">${feed.price}₽</div>
                            <div class="prise__btn"><a href="#">Забронировать</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="comments_div">
            <div class="comment_us">

            </div>
            <div class="comments_heading">${feed.countReview} Отзывов</div>
            <form action="ReviewServlet" method="post">
                <div class="comment_us">
                    <div class="comment_us__input">
                        <input type="hidden" name="id" value="${feed.id}">
                        <textarea name="comment" placeholder="Оставьте свой отзыв..."></textarea>
                    </div>
                    <div class="comment_us__btn">
                        <button type="submit">Send</button>
                    </div>
                </div>
            </form>
            <div class="comments_holder">
                <div class="comment">
                    <div class="comment__image">
                        <img src="SpaceDrive/img/space-shuttle.jpg">
                    </div>
                    <div class="comment__inform">
                        <div class="comment__author">
                            <div class="author__name">Roman</div>
                            <div class="author__day">22.10.2020</div>
                        </div>
                        <div class="comment__text">
                            <p>Donec id est facilisis, tempor mi eu, auctor neque. Quisque ut porttitor lectus.
                                Morbi sit amet venenatis nulla. Mauris accumsan venenatis orci non rutrum.
                                Donec id est facilisis, tempor mi eu, auctor neque. Quisque ut porttitor lectus.
                                Morbi sit amet venenatis nulla. Mauris accumsan venenatis orci non rutrum.</p>
                        </div>
                    </div>
                </div>
                <div class="comment">
                    <div class="comment__image">
                        <img src="SpaceDrive/img/space-shuttle.jpg">
                    </div>
                    <div class="comment__inform">
                        <div class="comment__author">
                            <div class="author__name">Roman</div>
                            <div class="author__day">22.10.2020</div>
                        </div>
                        <div class="comment__text">
                            <p>Donec id est facilisis, tempor mi eu, auctor neque. Quisque ut porttitor lectus.
                                Morbi sit amet venenatis nulla. Mauris accumsan venenatis orci non rutrum.
                                Donec id est facilisis, tempor mi eu, auctor neque. Quisque ut porttitor lectus.
                                Morbi sit amet venenatis nulla. Mauris accumsan venenatis orci non rutrum.</p>
                        </div>
                    </div>
                </div>
                <div class="comment">
                    <div class="comment__image">
                        <img src="SpaceDrive/img/space-shuttle.jpg">
                    </div>
                    <div class="comment__inform">
                        <div class="comment__author">
                            <div class="author__name">Roman</div>
                            <div class="author__day">22.10.2020</div>
                        </div>
                        <div class="comment__text">
                            <p>Donec id est facilisis, tempor mi eu, auctor neque. Quisque ut porttitor lectus.
                                Morbi sit amet venenatis nulla. Mauris accumsan venenatis orci non rutrum.
                                Donec id est facilisis, tempor mi eu, auctor neque. Quisque ut porttitor lectus.
                                Morbi sit amet venenatis nulla. Mauris accumsan venenatis orci non rutrum.</p>
                        </div>
                    </div>
                </div>
                <div class="comment">
                    <div class="comment__image">
                        <img src="SpaceDrive/img/space-shuttle.jpg">
                    </div>
                    <div class="comment__inform">
                        <div class="comment__author">
                            <div class="author__name">Roman</div>
                            <div class="author__day">22.10.2020</div>
                        </div>
                        <div class="comment__text">
                            <p>Donec id est facilisis, tempor mi eu, auctor neque. Quisque ut porttitor lectus.
                                Morbi sit amet venenatis nulla. Mauris accumsan venenatis orci non rutrum.
                                Donec id est facilisis, tempor mi eu, auctor neque. Quisque ut porttitor lectus.
                                Morbi sit amet venenatis nulla. Mauris accumsan venenatis orci non rutrum.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="bottom">
            <div class="bottom__div">
            </div>
        </div>
    </#if>

    <link rel="stylesheet" href="/SpaceDrive/css/ticket_page.css">
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