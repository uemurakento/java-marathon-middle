<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧画面</title>
</head>
<body>
<table border="1"><tr><td>
<h1>プロ野球</h1>
<h1>セントラルリーグ一覧</h1>
</td></tr></table>
<c:forEach var="baseballTeam" items="${baseballTeams}">
<a href="/baseballTeam/reference?id=${baseballTeam.id}"><c:out value="${baseballTeam.teamName}"/></a><br>
</c:forEach>
</body>
</html>