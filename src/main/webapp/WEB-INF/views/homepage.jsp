<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
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
            <h3>Hello <c:out value="${uname}"/></h3>
            <a href="viewPlans" class="btn btn-info" role="button">See current plans</a><br/>
            <a href="viewItems" class="btn btn-info" role="button">See current items</a><br/>
            <a href="addItem" class="btn btn-info" role="button">Add an item</a><br/>
            <a href="addPlan" class="btn btn-info" role="button">Add your own plan</a><br><br/>

            <form action="logout" method="POST">
                <button
                        class="btn btn-danger" type="submit" role="button">Logout
                </button>
            </form>
        </div>
    </div>
</div>
<script src="<c:url value='/assets/js/jquery.min.js'/>"></script>
<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
</body>
</html>