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
            <h1>New Team</h1>
            <h3>you are ${sessionScope.loggedUser.userName}</h3>
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
            <p>Team Name: ${team.teamName}</p>
            <p>Added By: ${team.user.userName}</p>
            <p>Skill Level: ${team.skillLevel}</p>
            <p>Game Day: ${team.gameDay}</p>
            <h3>Players:</h3>
            <ul>
                <c:forEach items="${team.players}" var="player">
                    <li>${player.playerName}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <hr>
    <div class="row">
        <div>
            <h3>Add Player (Any User can Add Players)</h3>
            <c:if test="${team.players.size() < 9}">
                <form method="POST" action="/addPlayer">
                    <div class="mb-3">
                        <label Class="form-label" for="title">Player Name</label>
                        <input type="hidden" name="teamId" value="${team.id}">
                        <input name="playerName" id="title" class="form-control" placeholder="Enter Player Name" />
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">Add</button>
                    </div>
                </form>
            </c:if>
            <c:if test="${team.players.size() >= 9}">
                <p>The team is full!</p>
            </c:if>

        </div>
    </div>

    <hr>
    <c:if test="${team.user.id == sessionScope.loggedUser.id}" >
        <h2>Team Actions</h2>
        <div class="row justify-content-center margin-top">
            <div class="col-md-3">
                <a href="/teams/${team.id}/edit" class="btn btn-primary">Edit</a>
            </div>
            <div class="col-md-3 justify-content-center align-items-center align-items-center">
                <form:form action="/teams/deleteTeam" method="post" modelAttribute="team" cssClass="justify-content-center align-items-center align-items-center">
                    <form:input path="id" type="hidden" name="id" value="${team.id}" />
                    <button type="submit" class="btn btn-danger justify-content-center align-items-center align-items-center">Delete</button>
                </form:form>
            </div>
        </div>
        <hr>
    </c:if>

</div>





<script src="/webjars/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>

