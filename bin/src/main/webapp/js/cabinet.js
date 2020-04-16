let products = null;

$.get("products", function (data) {
    if (data != '') {
        products = data;
    }
}).done(function () {
    let cardsContent = "";
    jQuery.each(products, function (i, value) {
        cardsContent += "<div class='col' style='text-align: center;'>" +
            "<div class='card'>" +
            "<div class='card-body'>" +
            "<h5 class='card-title'>" + value.name + "</h5>" +
            "<h6 class='card-subtitle mb-2 text-muted'>" + value.price + "</h6>" +
            "<p class='card-text'>" + value.description + "</p>" +
            "<a href='product?id=" + value.id + "' class='card-link productCardElement'>link</a>" +
            "</div>" +
            "</div>" +
            "</div>"
    });

    $('#productCards').html(cardsContent);


}).done(function () {
    $.get("user-role", function (data) {
        if (data !== '') {
            userRole = data;
        }
    }).done(function () {
        if (userRole === 'ADMINISTRATOR') {
            $('a.productCardElement').hide();
        }
    });
});


