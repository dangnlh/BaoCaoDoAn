<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- MENU BAR -->
<div class="menubar">
	<div class="dropdown" style="margin-left: 50px;">
		<a href="/BaoCaoDoAn/dang-nhap#" target="_top"><button
				class="dropbtn">
				<i class="fa fa-home"></i>
			</button></a>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Báo Cáo</button>
		<div class="dropdown-content">
			<a href="/addreport">Nộp báo cáo</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Nhóm</button>
		<div class="dropdown-content">
			<a th:href="@{'/detail/' + ${ inforAccount.group_id }}" href="#">Thông
				tin nhóm</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Lịch nộp báo cáo</button>
		<div class="dropdown-content">
			<a
				th:href="@{'dang-nhap/reportSchedule/byAccountID' + ${ inforAccount.id }}"
				href="#">Xem lịch</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Meeting</button>
		<div class="dropdown-content">
			<a
				th:href="@{'dang-nhap/reportSchedule/byAccountID' + ${ inforAccount.id }}"
				href="#">Xem lịch</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Đồ án</button>
		<div class="dropdown-content">
			<a
				th:href="@{'dang-nhap/project/byGroupID/' + ${ inforAccount.group_id }}"
				href="#">Link</a>
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