<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add plans here</title>
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
        <form method="POST">
            <div class="jumbotron">
                <div class="btn-group" data-toggle="buttons">
                    <label class="btn btn-primary">
                        <input type="radio" value="1" name="type" checked>Breakfast
                    </label>
                    <label class="btn btn-primary">
                        <input type="radio" value="2" name="type">Lunch
                    </label>
                </div>
                <br/>
                <br/>

                <div class="btn-group" data-toggle="buttons">
                    <label class="btn btn-primary">
                        <input type="radio" value="1" name="day" checked>Sunday
                    </label>
                    <label class="btn btn-primary">
                        <input type="radio" value="2" name="day">Monday
                    </label>
                    <label class="btn btn-primary">
                        <input type="radio" value="3" name="day">Tuesday
                    </label>
                    <label class="btn btn-primary">
                        <input type="radio" value="4" name="day">Wednesday
                    </label>
                    <label class="btn btn-primary">
                        <input type="radio" value="5" name="day">Thursday
                    </label>
                    <br>
                </div>
            </div>

            <div class="jumbotron">
                <c:forEach var="item" items="${items}">
                    <input type="checkbox" value="${item.id}" name="items">
                    <c:out value="${item.name}"/><br/>
                </c:forEach>
            </div>

            <input type="submit" class="btn btn-success" value="Add plan">

        </form>

        <c:if test="${messageAddPlan != null}">
            <strong><c:out value="${messageAddPlan}"/></strong><br/>
        </c:if>

        <a href="home" class="btn btn-info" role="button">Return to main page</a>

    </div>
</div>
<script src="<c:url value='/assets/js/jquery.min.js'/>"></script>
<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
</body>
</html>