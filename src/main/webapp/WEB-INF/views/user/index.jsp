
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

  <%@include file="/WEB-INF/views/user/teacher/linkHeader.jsp" %>
<body>

  <div class="container-scroller" style="margin-top: -75px;">


  <%@include file="/WEB-INF/views/user/teacher/Header.jsp" %>



    <div class="container-fluid page-body-wrapper">
    

        <%@include file="/WEB-INF/views/user/teacher/sidebar.jsp" %>
    
    


   
      <div class="main-panel">
        <div class="content-wrapper">

         


          <div class="row">
            <div class="col-md-12 stretch-card">
                  <div class="card profile-card bg-gradient-primary">
                    <div class="card-body">
                      <div class="row align-items-center h-100">
                        <div class="col-md-4">
                          <figure class="avatar mx-auto mb-4 mb-md-0">
                            <img src="images/faces/face20.jpg" >
                          </figure>
                        </div>
                        <div class="col-md-8">
                          <h5 class="text-white text-center text-md-left">${ InforAccount.name }</h5>
                          <p class="text-white text-center text-md-left">${ InforAccount.mail }</p>
                          <div class="d-flex align-items-center justify-content-between info pt-2">
                            <div>
                              <p class="text-white font-weight-bold">Birth date</p>
                              <p class="text-white font-weight-bold">Birth city</p>
                            </div>
                            <div>
                              <p class="text-white">16 Sep 2019</p>
                              <p class="text-white">Netherlands</p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
          </div>

        </div>
       
         <%@include file="/WEB-INF/views/user/teacher/Footer.jsp" %>
      
      </div>
     
    </div>
    
  </div>

 
</body>

</html>

