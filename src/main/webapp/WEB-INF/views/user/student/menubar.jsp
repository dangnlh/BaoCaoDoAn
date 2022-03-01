<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- MENU BAR -->
<div class="menubar">
	<div class="dropdown" style="margin-left: 50px;">
		<a href="<c:url value=""/>" target="_top"><button
				class="dropbtn">
				<i class="fa fa-home"></i>
			</button></a>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Báo Cáo</button>
		<div class="dropdown-content">
			<a href="<c:url value=""/>">Nộp báo cáo</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Nhóm</button>
		<div class="dropdown-content">
			<a href="<c:url value="/studentGroupByteacher_id"/>">Thông
				tin nhóm</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Lịch nộp báo cáo</button>
		<div class="dropdown-content">
			<a href="<c:url value=""/>">Xem lịch</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Meeting</button>
		<div class="dropdown-content">
			<a
				href="<c:url value=""/>">Xem lịch</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Đồ án</button>
		<div class="dropdown-content">
			<a href="<c:url value=""/>">Thông tin đồ án</a>
		</div>
	</div>


	<div class="dropdown">
		<button class="dropbtn">
			<i class="fa fa-bars"></i>
		</button>
		<div class="dropdown-content">
			<a href="#" th:href="@{'/detail/' + '18'}">Link 1</a> <a href="#"
				th:href="@{'/detail/' + '41'}">Link 2</a>
		</div>
	</div>
</div>
<!-- end of MENU BAR -->