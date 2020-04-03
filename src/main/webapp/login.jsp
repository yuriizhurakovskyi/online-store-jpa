<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Log in</title>
    <style>
        * {
            color: #254e77;
            font-family: 'Open Sans', sans-serif;
            text-align: center;
        }

        .container {
            width: 400px;
            text-align: center;
            margin: 0 auto;
        }

        .sendButton {
            line-height: 1.5;
            border-radius: 5px;
            margin: 15px;
            padding: 8px 40px;
            border: none;
            cursor: pointer;
            font-size: 18px;
            color: white;
            background: #254e77;
            font-weight: bold;
        }

        .sendButton:focus {
            outline: none
        }

        .sendButton:hover {
            box-shadow: 0 0 10px rgba(37, 78, 119, 0.5);
        }

        .sendButton:active {
            transform: translateY(3px);
        }

        .dataField {
            height: 15px;
            width: 200px;
            border-radius: 4px;
            border: 1px solid lightblue;
            background: white;
            padding: 11px 12px;
            border-radius: 4px;
            margin: 10px 5px;
            font-size: 16px
        }

        .dataField:focus {
            outline: none
        }

        label {
            font-size: 22px;
            display: inline-block;
            width: 200px;
            margin: 10px 5px;
        }

        .dataField:hover {
            border-color: lightblue;
            box-shadow: 0 0 4px lightblue;
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
    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <h1> Please enter login and password</h1>
    <form action="login" method="post">
        <label for="login" id="login">Email: </label> <input name="login" class="dataField"> <br>
        <label for="password" id="password">Password</label> <input name="password" type="password"
                                                                    class="dataField"><br>
        <input type="submit" value="submit" class="sendButton"><br>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>