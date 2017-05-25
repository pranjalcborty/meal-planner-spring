<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>

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
        <s:form action="addPlan" method="POST" commandName="meal">
            <div class="jumbotron">
                <div class="btn-group" data-toggle="buttons">
                    <s:radiobuttons path="type" items="${types}" itemLabel="label" element="span class='btn btn-primary'"/>
                </div>
                <br/>
                <br/>

                <div class="btn-group" data-toggle="buttons">
                    <s:radiobuttons path="day" items="${days}" itemLabel="label" element="span class='btn btn-primary'"/>
                </div>

            </div>

            <div class="jumbotron">
                <s:checkboxes path="items" items="${items}" itemLabel="name" itemValue="id" delimiter="<br/>"/>
            </div>

            <input type="submit" class="btn btn-success" value="Add plan">

        </s:form>

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