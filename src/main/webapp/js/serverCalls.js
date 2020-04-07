function showAlertAfterRegistration() {
    $('div.alert.alert-success').show();
}

$("button.createProduct").click(function () {
    let name = $("form.createProduct input.name").val();
    let description = $("form.createProduct input.description").val();
    let price = $("form.createProduct input.price").val();

    let product = {
        name: name,
        description: description,
        price: price
    };

    $.post("product", product, function (data) {
        if (data == 'Success') {
            $("form")[0].reset();
            showAlertAfterRegistration();
        }
    });
});