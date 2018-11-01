<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>洋服shop</title>
</head>
<body>
<table border="1"><tr><td><h1>洋服shop</h1></td></tr></table>

<p>
好きな色を選択してください
<form:form modelAttribute="clothesShopForm" action="${pageContext.request.contextPath}/clothesShop/serch">
<table><tr><td>
<form:radiobutton path="gender" value="0"/>男<br>
<form:radiobutton path="gender" value="1"/>女
</td><td>
<form:select path="color" items="${colorList}"/>
</td><td>
<input type="submit" name="検索">
</td></tr></table>
</form:form>
</p>

<c:forEach var="clothes" items="${clothesList}">
<table border="1"><tr>
<td>ジャンル</td>
<td><c:out value="${clothes.genre}"/></td>
</tr><tr>
<td>サイズ</td>
<td><c:out value="${clothes.size}"/></td>
</tr><tr>
<td>価格</td>
<td><c:out value="${clothes.price}"/></td>
</tr></table>
</c:forEach>

</body>
</html>