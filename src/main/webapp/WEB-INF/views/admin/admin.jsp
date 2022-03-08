<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin Page</title>
<%@include file="/WEB-INF/views/admin/linkheader.jsp"%>
</head>

<body id="page-top">
	<div id="wrapper">
	
		<!-- Sidebar -->
		<%@include file="/WEB-INF/views/admin/sidebar.jsp"%>
		<!-- End of Sidebar -->


		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content" >
			
					<!-- Header Navbar -->
					<%@include file="/WEB-INF/views/admin/header.jsp"%>
					<!-- End of Header -->

					<!--  Main Content -->
					
					<!--  End of Main Content -->

					<!-- Footer -->
					<%@include file="/WEB-INF/views/admin/footer.jsp"%>
					<!-- End of Footer -->
					
			</div>
			<!-- End of Content Wrapper -->
		</div>
	</div>

	<!-- Scripts -->
	<%@include file="/WEB-INF/views/admin/adminscript.jsp"%>
	<!-- End of Scripts -->
</body>

</html>