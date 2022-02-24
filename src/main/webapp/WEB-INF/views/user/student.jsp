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
	
<link
	href="<c:url value="/assets/css/style.css" /> "
	rel="stylesheet" />
</head>

<body>
	<div class="header" th:fragment="headerfrag">
		<div class="top-header">
		
		</div>
		<div class="middle-header">
			<a href="/" target="_top"><img
				src="https://daihoc.fpt.edu.vn/media/2021/12/Logo-FU-01-200.png"
				alt="FPT"
				style="max-width: 160px; margin-top: -10px; margin-left: 50px; margin-top: 20px; margin-bottom: 20px;"></a>
			<div class="search-container">
				<input type="text" placeholder="Search.." name="search">
				<button type="submit"
					style="margin-left: -10px; margin-right: 20px;">
					<i class="fa fa-search"></i>
				</button>

				<a href="https://www.facebook.com/freetuts/" target="_blank"><button
						class="socialbtn">
						<i class="fa fa-facebook"
							style="color: white; background-color: #00687c;"></i>
					</button></a> <a href="https://www.youtube.com/channel/UC0jGwW2AfbsGbuY_Z3jtkAg"
					target="_blank"><button class="socialbtn">
						<i class="fa fa-youtube"
							style="color: white; background-color: #00687c;"></i>
					</button></a> <a href="https://twitter.com/freetuts_net" target="_blank"><button
						class="socialbtn">
						<i class="fa fa-twitter"
							style="color: white; background-color: #00687c;"></i>
					</button></a>
				<button class="socialbtn">
					<i class="fa fa-skype"
						style="color: white; background-color: #00687c;"></i>
				</button>

			</div>
		</div>

		<div class="menubar">
			<div class="dropdown" style="margin-left: 50px;">
				<a href="/" target="_top"><button class="dropbtn">
						<i class="fa fa-home"></i>
					</button></a>
			</div>

			<div class="dropdown">
				<button class="dropbtn">Group</button>
				<div class="dropdown-content">
					<a th:href="@{'/detail/' + ${ inforAccount.group_id }}" href="#"/>
				</div>
			</div>

			<div class="dropdown">
				<button class="dropbtn">Report Schedule</button>
				<div class="dropdown-content">
					<a th:href="@{'dang-nhap/reportSchedule/byAccountID' + ${ inforAccount.id }}" href="#">View</a>
				</div>
			</div>
			
			<div class="dropdown">
				<button class="dropbtn">Project</button>
				<div class="dropdown-content">
					<a th:href="@{'dang-nhap/project/byGroupID/' + ${ inforAccount.group_id }}" href="#"/>
				</div>
			</div>
			
		
			<div class="dropdown">
				<button class="dropbtn">
					<i class="fa fa-bars"></i>
				</button>
				<div class="dropdown-content">
					<a href="#" th:href="@{'/detail/' + '18'}">Link 1</a>
					<a href="#" th:href="@{'/detail/' + '41'}">Link 2</a> 
				</div>
			</div>
		</div>
	</div>
</body>
</html>