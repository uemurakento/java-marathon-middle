<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>参照画面</title>
</head>
<body>
<p>
球団名<br>
<c:out value="${baseballTeam.teamName}"></c:out>
</p>
<p>
本拠地<br>
<c:out value="${baseballTeam.headquarters}"></c:out>
</p>
<p>
発足<br>
<c:out value="${baseballTeam.inauguration}"></c:out>
<p>
歴史<br>
<pre>
<c:out value="${baseballTeam.history}"></c:out>
</pre>
<form action="${pageContext.request.contextPath}/baseballTeam/" method="post">
<input type="submit" value="戻る">
</form>
</body>
</html>