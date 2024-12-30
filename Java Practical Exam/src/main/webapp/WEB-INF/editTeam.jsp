<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Manager</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <h1>Edit Team</h1>
            <h3>${sessionScope.loggedUser.userName}</h3>
        </div>
        <div class="col-md-4">
            <div class="my-nav-container">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/dashboard">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <hr>
    <div class="row">
        <div>
            <form:form method="POST" action="/team/editTeam" modelAttribute="team">
                <form:input path="id" value="${team.id}" type="hidden"/>
                <form:input path="user" value="${sessionScope.loggedUser.id}" type="hidden"/>
                <div class="mb-3">
                    <form:label path="teamName" cssClass="form-label" for="teamName">Team Name</form:label>
                    <form:input path="teamName" id="teamName" class="form-control" placeholder="Enter Team Name" />
                    <form:errors path="teamName" cssClass="error-message" />
                </div>
                <div class="mb-3">
                    <form:label path="skillLevel" cssClass="form-label" for="skillLevel">Slill Level</form:label>
                    <form:input path="skillLevel" id="skillLevel" class="form-control" type="number" min="1" max="5" />
                    <form:errors path="skillLevel" cssClass="error-message" />
                </div>
                <div class="mb-3">
                    <form:label path="gameDay" cssClass="form-label" for="gameDay">Game Day</form:label>
                    <form:input path="gameDay" id="gameDay" class="form-control" placeholder="Enter Game Day" />
                    <form:errors path="gameDay" cssClass="error-message" />
                </div>
                <hr>
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form:form>
        </div>
    </div>

</div>





<script src="/webjars/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>

