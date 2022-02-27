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

					<!-- -----------------HEADER-------------------- -->
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

				<!-- Nút Facebook -->
				<a href="https://www.facebook.com/FPTU.HCM" target="_blank"><button
						class="socialbtn">
						<i class="fa fa-facebook"
							style="color: white; background-color: #00687c;"></i>
					</button></a>
					<!-- Nút Youtube -->
					<a href="https://www.youtube.com/channel/UCfNrlxNgcTZDJ3jZeSSSJxg"
					target="_blank"><button class="socialbtn">
						<i class="fa fa-youtube"
							style="color: white; background-color: #00687c;"></i>
					</button></a>
					<!-- Nút Instagram -->
					<a href="https://www.instagram.com/accounts/login/?next=/fptuniversityhcm/"
					target="_blank"><button class="socialbtn">
						<i class="fa fa-instagram"
							style="color: white; background-color: #00687c;"></i>
					</button></a>  

			</div>
		</div>
		
				<!-- MENU BAR -->
		<div class="menubar">
			<div class="dropdown" style="margin-left: 50px;">
				<a href="/BaoCaoDoAn/dang-nhap#" target="_top"><button class="dropbtn">
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
					<a th:href="@{'/detail/' + ${ inforAccount.group_id }}" href="#">Thông tin nhóm</a>
				</div>
			</div>

			<div class="dropdown">
				<button class="dropbtn">Lịch nộp báo cáo</button>
				<div class="dropdown-content">
					<a th:href="@{'dang-nhap/reportSchedule/byAccountID' + ${ inforAccount.id }}" href="#">Xem lịch</a>
				</div>
			</div>
			
			<div class="dropdown">
				<button class="dropbtn">Meeting</button>
				<div class="dropdown-content">
					<a th:href="@{'dang-nhap/reportSchedule/byAccountID' + ${ inforAccount.id }}" href="#">Xem lịch</a>
				</div>
			</div>
			
			<div class="dropdown">
				<button class="dropbtn">Đồ án</button>
				<div class="dropdown-content">
					<a th:href="@{'dang-nhap/project/byGroupID/' + ${ inforAccount.group_id }}" href="#">Link</a>
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
		<!-- end of MENU BAR -->
	</div>
							<!-- -----------------END OF HEADER-------------------- -->
	
	
	
	
	
	
	
	
							<!-- -----------------FOOTER-------------------- -->
	<div class="footer" th:fragment="footerfrag">
	<div class="top">
		<div class="column">
			<table class="t1">
				<tr>
					<th>LIÊN HỆ</th>
					<th>NGÀNH ĐÀO TẠO</th>
					<th> </th>
				</tr>
				<tr>
					<td>TRƯỜNG ĐẠI HỌC FPT</td>
					<td><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/nganh-quan-tri-kinh-doanh"
					target="_top">Quản trị kinh doanh</a></td>
					<td class="color"><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/nganh-kinh-doanh-quoc-te"
					target="_top">Kinh doanh quốc tế</a></td>
				</tr>
				<tr>
					<td>Lô E2a-7, Đường D1, Khu Công nghệ cao, P.Long Thạnh Mỹ, Tp. Thủ Đức, TP.HCM.</td>
					<td><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/digital-marketing"
					target="_top">Digital Marketing</a></td>
					<td class="color"><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/nganh-ky-thuat-phan-mem"
					target="_top">Kỹ thuật phần mềm</a></td>
				</tr>
				<tr>
					<td> (028) 7300 5588</td>
					<td><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/nganh-an-toan-thong-tin"
					target="_top">An toàn thông tin</a></td>
					<td class="color"><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/tri-tue-nhan-tao"
					target="_top">Trí tuệ nhân tạo</a></td>
				</tr>
				<tr>
					<td>daihoc.hcm@fpt.edu.vn</td>
					<td><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/nganh-truyen-thong-da-phuong-tien"
					target="_top">Truyền thông đa phương tiện</a></td>
					<td class="color"><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/tri-tue-nhan-tao"
					target="_top">Thiết kế Mỹ thuật số</a></td>
				</tr>
				<tr>
					<td><a href="#"
					target="_top"> </a></td>
					<td><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/nganh-quan-tri-khach-san"
					target="_top">Quản trị khách sạn</a></td>
					<td class="color"><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/nganh-ngon-ngu-nhat"
					target="_top">Ngôn ngữ Nhật</a></td>
				</tr>
			</table>
		</div>
		<div class="column">
			<table class="t2">
				<tr>
					<th> </th>
				</tr>
				<tr>
					<td><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/he-thong-thong-tin"
					target="_top">Hệ thống thông tin</a></td>
				</tr>
				<tr>
					<td><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/nganh-quan-tri-dich-vu-du-lich-lu-hanh"
					target="_top">Quản trị dịch vụ du lịch & lữ hành</a></td>
				</tr>
				<tr>
					<td><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/nganh-ngon-ngu-anh"
					target="_top">Ngôn ngữ Anh</a></td>
				</tr>
				<tr>
					<td><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/nganh-ngon-ngu-han-quoc"
					target="_top">Ngôn ngữ Hàn Quốc</a></td>
				</tr>
				<tr>
					<td><a href="https://hcmuni.fpt.edu.vn/nganh-dao-tao/iot-internet-of-things"
					target="_top">IoT (Internet of Things)</a></td>
				</tr>
			</table>
		</div>
	</div>
	
	<div class="bot">
	<p>© Bản quyền thuộc về Đại học FPT.</p>
	<p><img
				src="https://hcmuni.fpt.edu.vn/Data/Sites/1/media/logo-footer.png"
				alt="footer_logo"
				style="max-width: 160px; margin-top: -10px; margin-left: 0px; margin-top: 0px; margin-bottom: 0px;"></p>
	<a href="https://hcmuni.fpt.edu.vn/" target="_blank"><p><button style="background-color: #009900;"><b>DMCA</b></button ><button style="background-color: #6f705b;"><b>PROTECTED</b></button></p></a>
	</div>
	</div>
	<!-- -----------------END OF FOOTER-------------------- -->
</body>
</html>