<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第一個在SpringBoot環境下執行的JSP檔案</title>
</head>
<body>
	<div align="center">
		<%--thymeleaf寫法--%>
		<%-- <h2 th:text="${helloMessage}">Defualt Value</h2>  --%>
		<%-- jsp寫法 --%>
		<h2>${helloMessage}</h2>
		<hr>
		<a href="<c:url value='/' />">回首頁</a>
		
	</div>
</body>
</html>