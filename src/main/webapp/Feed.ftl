<#import "Base.ftl" as base>

<@base.main>
    <div class="search">
        <form action="FeedServlet" method="post">
            <div class="search__bar">
                <input type="text" class="search_term" placeholder="What are you looking for?">
                <button type="button" id="btn_open" class="btn_open_more">
                    <i class="fa fa-caret-down"></i>
                </button>
                <button type="submit" id="btn_search" class="btn_search">
                    <i class="fa fa-search"></i>
                </button>
            </div>
            <div id="search__div" class="search__div">
                <div class="search__config">
                    <div class="config__sort_by">
                        <div class="form-group ">
                            <label for="sort_by__select">Сортировать по:</label>
                            <select class="form-control" id="sort_by__select">
                                <option>Цене по убыванию</option>
                                <option>Цене по возрастанию</option>
                                <option>Популярности</option>
                            </select>
                        </div>
                    </div>
                    <div class="config__prise_interval">
                        <div class="prise_interval">
                            <div class="prise_interval__text">Цена от</div>
                            <div class="prise_interval__input">
                                <input type="text" class="form-control" placeholder="0">
                            </div>
                            <div class="prise_interval__text">до</div>
                            <div class="prise_interval__input">
                                <input type="text" class="form-control" placeholder="*">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="card_holder">
        <div class="card_item">
            <div class="card__image">
                <img src="img/icon-spaceman.jpg">
            </div>
            <div class="card__info">
                <div class="card__text">
                    <div class="text__heading">
                        <div class="heading__review"><a href="#">7 отзывов</a></div>
                        <div class="heading__name"><a href="#">Hotel Kolumbus</a></div>
                    </div>
                    <div class="text__cont">
                        <div class="cont__date">22.10.2020 - 05.11.2020</div>
                        <div class="cont__inf">2 ночи | 2-x мест.</div>
                    </div>
                </div>
                <div class="card__prise">
                    <div class="prise__count">29990₽</div>
                    <div class="prise__btn"><a href="#">Подробнее</a></div>
                </div>
            </div>
        </div>

        <div class="card_item">
            <div class="card__image">
                <img src="img/icon-spaceman.jpg">
            </div>
            <div class="card__info">
                <div class="card__text">
                    <div class="text__heading">
                        <div class="heading__review"><a href="#">7 отзывов</a></div>
                        <div class="heading__name"><a href="#">Hotel Kolumbus</a></div>
                    </div>
                    <div class="text__cont">
                        <div class="cont__date">22.10.2020 - 05.11.2020</div>
                        <div class="cont__inf">2 ночи | 2-x мест.</div>
                    </div>
                </div>
                <div class="card__prise">
                    <div class="prise__count">29990₽</div>
                    <div class="prise__btn"><a href="#">Подробнее</a></div>
                </div>
            </div>
        </div>

        <div class="card_item">
            <div class="card__image">
                <img src="img/icon-spaceman.jpg">
            </div>
            <div class="card__info">
                <div class="card__text">
                    <div class="text__heading">
                        <div class="heading__review"><a href="#">7 отзывов</a></div>
                        <div class="heading__name"><a href="#">Hotel Kolumbus</a></div>
                    </div>
                    <div class="text__cont">
                        <div class="cont__date">22.10.2020 - 05.11.2020</div>
                        <div class="cont__inf">2 ночи | 2-x мест.</div>
                    </div>
                </div>
                <div class="card__prise">
                    <div class="prise__count">29990₽</div>
                    <div class="prise__btn"><a href="#">Подробнее</a></div>
                </div>
            </div>
        </div>

        <div class="card_item">
            <div class="card__image">
                <img src="img/icon-spaceman.jpg">
            </div>
            <div class="card__info">
                <div class="card__text">
                    <div class="text__heading">
                        <div class="heading__review"><a href="#">7 отзывов</a></div>
                        <div class="heading__name"><a href="#">Hotel Kolumbus</a></div>
                    </div>
                    <div class="text__cont">
                        <div class="cont__date">22.10.2020 - 05.11.2020</div>
                        <div class="cont__inf">2 ночи | 2-x мест.</div>
                    </div>
                </div>
                <div class="card__prise">
                    <div class="prise__count">29990₽</div>
                    <div class="prise__btn"><a href="#">Подробнее</a></div>
                </div>
            </div>
        </div>

        <div class="card_item">
            <div class="card__image">
                <img src="img/icon-spaceman.jpg">
            </div>
            <div class="card__info">
                <div class="card__text">
                    <div class="text__heading">
                        <div class="heading__review"><a href="#">7 отзывов</a></div>
                        <div class="heading__name"><a href="#">Hotel Kolumbus</a></div>
                    </div>
                    <div class="text__cont">
                        <div class="cont__date">22.10.2020 - 05.11.2020</div>
                        <div class="cont__inf">2 ночи | 2-x мест.</div>
                    </div>
                </div>
                <div class="card__prise">
                    <div class="prise__count">29990₽</div>
                    <div class="prise__btn"><a href="#">Подробнее</a></div>
                </div>
            </div>
        </div>
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

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="SpaceDrive/js/feed.js"></script>
</@base.main>