<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add item</title>
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
            <form action="addItem" method="POST">
                Item Name: <input class="form-control" type="text" name="item_name">
                <button
                        class="btn btn-success" type="submit" role="button">Add
                </button>
            </form>
            <c:if test="${messageAddItem != null}">
                <div><strong><c:out value="${messageAddItem}"/></strong></div>
            </c:if>
            <a href="home" class="btn btn-info" role="button">Return to main page</a>
        </div>
    </div>
</div>
<script src="<c:url value='/assets/js/jquery.min.js'/>"></script>
<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
</body>
</html>
