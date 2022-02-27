<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Header Page</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="<c:url value="/assets/css/style.css" /> " rel="stylesheet" />
</head>

<body>
<div class="header" th:fragment="headerfrag">
	<!-- -----------------HEADER-------------------- -->
	<%@include file="/WEB-INF/views/user/student/header.jsp"%>
	<!-- -----------------END OF HEADER-------------------- -->
	
	<!-- -----------------MENU BAR-------------------- -->
	<%@include file="/WEB-INF/views/user/student/menubar.jsp"%>
	<!-- -----------------END OF MENU BAR-------------------- -->
	</div>










	<!-- -----------------FOOTER-------------------- -->
	<%@include file="/WEB-INF/views/user/student/footer.jsp"%>
	<!-- -----------------END OF FOOTER-------------------- -->
</body>
</html>