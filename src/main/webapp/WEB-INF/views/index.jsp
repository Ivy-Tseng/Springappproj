<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session='true' import='javax.servlet.*, javax.servlet.http.*'%>
	
<%-- <% HttpSession session1 = request.getSession(); %>	 --%>
	
	
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value='/webjars/jquery/3.6.0/jquery.js'/>"></script>
<meta charset="UTF-8">
<link rel="stylesheet"
	href='${pageContext.request.contextPath}/css/style.css' />

<title>Spring Boot</title>

</head>
<body>
	<div align="center">
		<h2>Spring Boot範例</h2>
		<hr>
		<a href="<c:url value='/des/sdsd/asa'/>">第一個Spring Boot程式</a><br>
		<a href="<c:url value='/springmvc/members'/>">會員資料列表(SpringMVC)</a><br>
		<hr>
		<a href="<c:url value='/ajax/addMemberForm'/>">新增會員資料(Ajax)</a><br>
		<a href="<c:url value='/ajax/memberForm'/>">會員資料列表(Ajax)</a><br>
		
		<a href="<c:url value='/springmvc/classpathResource'/>">讀取類別路徑資料</a><br>
		
		<hr>
		Context Path(上下文路徑):${pageContext.request.contextPath}<br>
<!-- 		<hr> -->
<%-- 		<img width='60' src='${pageContext.request.contextPath}/images/PDF.png' /> --%>
		<hr>
		${myKitty}
		
	</div>
	<hr>
	<c:forEach var='cbean' items='${companys}'>
		${cbean.companyId}&nbsp;${cbean.companyName}&nbsp;${cbean.phone}
	
	</c:forEach>
</body>
</html>