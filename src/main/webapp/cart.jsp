<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/cabinet.css">
    <link rel="stylesheet" href="css/cart.css">
    <title>My Bucket</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="welcome-to-the-cabinet">My Shopping Cart
    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
    <div class="container-fluid">
        <div class="row">
            <table id="myTable">
            </table>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Try Other</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Bootstrap 4.0.0 Snippet by pradeep330</h6>
                    <p class="card-text">You can also try different version of Bootstrap V4 side menu. Click below link
                        to view all Bootstrap Menu versions.</p>
                    <a href="https://bootsnipp.com/pradeep330" class="card-link">link</a>
                    <a href="http://websitedesigntamilnadu.com" class="card-link">Another link</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Try Other</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Bootstrap 4.0.0 Snippet by pradeep330</h6>
                    <p class="card-text">You can also try different version of Bootstrap V4 side menu. Click below link
                        to view all Bootstrap Menu versions.</p>
                    <a href="https://bootsnipp.com/pradeep330" class="card-link">link</a>
                    <a href="http://websitedesigntamilnadu.com" class="card-link">Another link</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Try Other</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Bootstrap 4.0.0 Snippet by pradeep330</h6>
                    <p class="card-text">You can also try different version of Bootstrap V4 side menu. Click below link
                        to view all Bootstrap Menu versions.</p>
                    <a href="https://bootsnipp.com/pradeep330" class="card-link">link</a>
                    <a href="http://websitedesigntamilnadu.com" class="card-link">Another link</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Try Other</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Bootstrap 4.0.0 Snippet by pradeep330</h6>
                    <p class="card-text">You can also try different version of Bootstrap V4 side menu. Click below link
                        to view all Bootstrap Menu versions.</p>
                    <a href="https://bootsnipp.com/pradeep330" class="card-link">link</a>
                    <a href="http://websitedesigntamilnadu.com" class="card-link">Another link</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Try Other</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Bootstrap 4.0.0 Snippet by pradeep330</h6>
                    <p class="card-text">You can also try different version of Bootstrap V4 side menu. Click below link
                        to view all Bootstrap Menu versions.</p>
                    <a href="https://bootsnipp.com/pradeep330" class="card-link">link</a>
                    <a href="http://websitedesigntamilnadu.com" class="card-link">Another link</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/header.js"></script>
<script src="js/serverCalls.js"></script>
<script src="js/cart.js"></script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>