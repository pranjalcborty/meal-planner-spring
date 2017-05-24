<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Plans</title>
    <link rel="icon" href="<c:url value='/assets/images/logo.ico'/>">
    <meta name="viewport" content="width = device-width, initial-scale = 1">
    <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/>">
    <style>
        .jumbotron {
            align-content: center;
            align-items: center;
            text-align: center;
            background-color: rgba(85, 139, 2, 0.55);
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
        <h1>Current plans</h1>

        <div class="jumbotron">
            <table class="table">
                <c:forEach var="meal" items="${meals}">
                    <tr>
                        <td><c:out value="${meal.day}"/></td>
                        <td><c:out value="${meal.type}"/></td>
                        <td>
                            <c:forEach var="item" items="${meal.items}">
                                <c:out value="${item.name}"/> <br/>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
            <a href="home" class="btn btn-info" role="button">Return to main page</a>
        </div>
    </div>
</div>
<script src="<c:url value='/assets/js/jquery.min.js'/>"></script>
<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
</body>
</html>
