<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホテル検索</title>
</head>
<body>
<table><tr><td>ホテル検索</td></tr></table>
<form:form modelAttribute="hotelSerchForm" action="${pageContext.request.contextPath}/hotel/serch">
一泊料金<form:input path="price"/>円以下<br>
<input type="submit" name="検索">
</form:form>

<c:forEach var="hotel" items="${hotels}">
<table border="1">
<tr>
<td>ホテル名</td>
<td><c:out value="${hotel.hotelName}"/></td>
</tr>
<tr>
<td>最寄駅</td>
<td><c:out value="${hotel.nearestStation}"/></td>
</tr>
<tr>
<td>価格</td>
<td><fmt:formatNumber value="${hotel.price}" pattern="###,###円"/></td>
</tr>
</table>
</c:forEach>
</body>
</html>