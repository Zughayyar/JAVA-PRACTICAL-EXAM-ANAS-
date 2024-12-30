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
                <h1>Welcome, ${sessionScope.loggedUser.userName}</h1>
            </div>
            <div class="col-md-4">
                <div class="my-nav-container">
                    <ul class="nav flex-column">
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
                <table class="table text-center">
                    <thead>
                    <tr class="table-info">
                        <th scope="col">Team Name</th>
                        <th scope="col">Skill Level (1-5)</th>
                        <th scope="col">Players</th>
                        <th scope="col">Game Day</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="team" items="${teams}">
                    <tr>
                        <td><a href="/teams/${team.id}">${team.teamName}</a></td>
                        <td>${team.skillLevel}</td>
                        <td>${team.players != null ? team.players.size() : 0}/9</td>
                        <td>${team.gameDay}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <hr>
        <div class="row">
            <div>
                <a href="/teams/new" class="btn btn-primary">Create New Team</a>
            </div>
        </div>    
    </div>





    <script src="/webjars/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</body>
</html>

