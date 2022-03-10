
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

  <%@include file="/WEB-INF/views/user/student/linkHeader.jsp" %>
<body>



<div class="header">
		<!-- -----------------HEADER-------------------- -->
		<%@include file="/WEB-INF/views/user/teacher/header.jsp"%>
		<!-- -----------------END OF HEADER-------------------- -->
		<!-- -----------------MENU BAR-------------------- -->
		<%@include file="/WEB-INF/views/user/teacher/menubar.jsp"%>
		<!-- -----------------END OF MENU BAR-------------------- -->
	</div>
    
    


   
      <div class="main-panel">
        <div class="content-wrapper">

         


	<div class="row">


						<div class="col-lg-10 grid-margin stretch-card">
							 <div class="card profile-card bg-gradient-primary">
                    <div class="card-body">
                      <div class="row align-items-center h-100">
                        <div class="col-md-4">
                          <figure class="avatar mx-auto mb-4 mb-md-0">
                            <img src="images/faces/face20.jpg" >
                          </figure>
                        </div>
                        <div class="col-md-6">
                          <h3 class="text-white text-center text-md-left">${ InforAccount.name }</h3>
                          <p class="text-white text-center text-md-left">${ InforAccount.mail }</p>
                          <div class="d-flex align-items-center justify-content-between info pt-2">
                            <div>
                              <p class="text-white font-weight-bold">Phone Number</p>
                              <p class="text-white font-weight-bold">Role</p>
                            </div>
                            <div>
                              <p class="text-white">${ InforAccount.phone }</p>
                              <p class="text-white">${ InforAccount.role }</p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
						</div>
						
						

					</div>

				</div>

        
      <%@include file="/WEB-INF/views/user/teacher/footer.jsp" %>
      </div>
 
</body>

</html>

