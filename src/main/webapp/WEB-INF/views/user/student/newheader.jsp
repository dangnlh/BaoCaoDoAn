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