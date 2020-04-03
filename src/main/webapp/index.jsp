<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <style>
        * {
            color: #254e77;
            text-align: center;
            font-family: 'Open Sans', sans-serif;
            text-align: center;
        }

        a {
            text-decoration: none;
            display: block;
            font-size: 33px;
            font-weight: bold;
        }

        header {
            min-width: 1000px;
            height: 208px;
            background: navy;
            box-sizing: border-box;
            border-bottom: 9px solid #254e77;
            box-sizing: border-box;
            padding: 60px;
            margin: 0 auto;
            color: white;
            font-size: 33px;
            font-weight: bold;
        }

        footer {
            min-width: 1000px;
            height: 208px;
            background: navy;
            box-sizing: border-box;
            border-top: 9px solid #254e77;
            box-sizing: border-box;
            margin: 0 auto;
            color: white;
            padding: 60px;
            font-size: 28px;
            font-weight: bold;
        }

        .center-block {
            width: 70%;
            height: 400px;
            min-width: 1000px;
            margin: 0 auto;
            overflow: hidden;
            padding: 60px;
            box-sizing: border-box;
        }
    </style>
    <meta charset="ISO-8859-1">
    <title>My online shop</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="center-block">
    <a href=registration.jsp>For a registration</a><br>
    <a href=login.jsp>For a login</a>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>