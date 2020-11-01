$(function () {
    $('#btn_search').click(function (event) {
        var search = $('#search').val();
        var checkboxes = document.getElementsByName('stars');
        var tags = [];
        i = 0;
        for (var index = 0; index < checkboxes.length; index++) {
            if (checkboxes[index].checked) {
                tags[i] = checkboxes[index].value;
                i++;
            }
        }
        var select = document.getElementById("sort_by__select");
        var value = select.value;
        var priceFrom = $('#priceFrom').val();
        var priceTo = $('#priceTo').val();

        $.ajax({
            type: "POST", url: "FeedServlet",
            data: {
                search: search,
                tags: JSON.stringify(tags),
                value: value,
                priceFrom: priceFrom,
                priceTo: priceTo
            },
            dataType: 'json',
            success: function (result) {
                $("#child").detach();
                $("<div id=\"child\" class=\"card_holder\" style=\"width: 100%;\">").appendTo($("#parent"));
                for (var i = 0; i < result.length; i++) {
                    $('#child').append($(' <div class="card_item"> ' +
                        '<div class="card__image"> <img src="SpaceDrive/img/icon-spaceman.jpg"> ' +
                        '</div> ' +
                        '<div class="card__info"> ' +
                        '<div class="card__text"> ' +
                        '<div class="text__heading"> ' +
                        '<div class="heading__review"><a href="TicketServlet?id=' + result[i]['id'] + '">Отзывы</a></div> ' +
                        '<div class="heading__name"><a href="TicketServlet?id=' + result[i]['id'] + '">' + result[i]['title'] + '</a></div> ' +
                        '<div>' +
                         + result[i]['stars'] + ' звезд(ы)' +
                        '</div>' +
                        '</div>\n' +
                        '<div class="text__cont">\n' +
                        '<div class="cont__date">' + result[i]['dateFrom'] + ' - ' + result[i]['dateTo'] + '</div> ' +
                        '<div class="cont__inf">' + result[i]['description'] + '</div> ' +
                        '</div>' +
                        '</div>' +
                        '<div class="card__prise">' +
                        '<div class="prise__count">' + result[i]['price'] + '₽</div> ' +
                        '<div class="prise__btn"><a href="TicketServlet?id=' + result[i]['id'] + '">Подробнее</a></div> ' +
                        '</div> ' +
                        '</div> ' +
                        '</div> '
                    ))
                }
            }
        });
    });
});