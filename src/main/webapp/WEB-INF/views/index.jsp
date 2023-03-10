<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Log in</title>
    <link rel="icon" href="<c:url value='/assets/images/logo.ico'/>">
    <meta name="viewport" content="width = device-width, initial-scale = 1">
    <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/>">
    <style>
        .jumbotron {
            align-content: center;
            align-items: center;
            text-align: center;
            color: white;
            background-color: darkslateblue;
        }

        .absolute-center {
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
        }

        .absolute-center.is-responsive {
            width: 50%;
            min-width: 200px;
            padding: 40px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="absolute-center is-responsive">
        <div class="jumbotron">
            <strong><c:out value="${name}"/></strong>

            <form action="login" method="POST">
                Enter username: <input class="form-control" type="text" name="userName"><br/>
                Enter password: <input class="form-control" type="password" name="password"><br/><br/>

                <button class="btn btn-success" type="submit" role="button">Login</button>
                <a href="register" class="btn btn-info" role="button">Register</a>
            </form>
            <c:if test="${failureMessage != null}">
                <strong><c:out value="${failureMessage}"/></strong><br/>
            </c:if>
        </div>
    </div>
</div>
<script src="<c:url value='/assets/js/jquery.min.js'/>"></script>
<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
</body>
</html>
