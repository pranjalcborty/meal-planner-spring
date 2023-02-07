<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Register</title>
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

            <s:form method="POST">
                Enter full name: <input class="form-control" type="text" name="fullName"><br/>
                Enter username: <input class="form-control" type="text" name="uname"><br/>
                Enter password: <input class="form-control" type="password" name="pass"><br/><br/>
                <button class="btn btn-success" type="submit" role="button">Register</button>
            </s:form>

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
