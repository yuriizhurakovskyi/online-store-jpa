function myFunction() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}


var carts = null;
$.get("carts", function (data) {
    if (data != '') {
        carts = data;
    }
}).done(function () {

    var tableContent = "<tr class='header'>" +
        "<th style='width: 20%;'>Name</th>" +
        "<th style='width: 20%;'>Description</th>" +
        "<th style='width: 20%;'>Price</th>" +
        "<th style='width: 20%;'>PurchaseDate</th>" +
        "<th style='width: 20%;'>Options</th>" +
        "</tr>";

    jQuery.each(carts, function (i, value) {

        tableContent += "<tr>" +
            "<td>" + value.name + "</td>" +
            "<td>" + value.description + "</td>" +
            "<td>" + value.price + "</td>" +
            "<td>" + value.purchaseDate + "</td>" +
            "<td><button onclick='deleteOrderFromBucket(" + value.cartId + ")'>delete</button></td>" +
            "</tr>"

    });

    $('#myTable').html(tableContent);

});


function deleteOrderFromBucket(cartId) {
    let customUrl = '';
    let urlContent = window.location.href.split('/');
    for (let i = 0; i < urlContent.length - 1; i++) {
        customUrl += urlContent[i] + '/'
    }
    customUrl += 'cart?cartId=' + cartId;
    $.ajax({
        url: customUrl,
        type: 'DELETE',
        success: function (data) {
            if (data === 'Success') {
                location.reload();
            }
        }
    });
}