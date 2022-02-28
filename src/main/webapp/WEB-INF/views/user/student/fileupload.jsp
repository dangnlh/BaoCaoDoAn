<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>File Upload</title>
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>

<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
<!-- <link -->
<%-- 	href="<c:url value="/assets/css/style.css" /> " --%>
<!-- 	rel="stylesheet" /> -->

</head>
<body>
<!-- partial:index.partial.html -->

<div class="container center">
	<div class="row">
		<div class="col-md-12">
			<h1 class="white">File Upload</h1>
			<p class="white">Sample Text</p>
		</div>
	</div>
	
	<form name="upload" method="post" action="#" enctype="multipart/form-data" accept-charset="utf-8">
		<div class="row">
			<div class="col-md-6 col-md-offset-3 center">
				<div class="btn-container">
					<!--the three icons: default, ok file (img), error file (not an img)-->
					<h1 class="imgupload"><i class="fa fa-file-image-o"></i></h1>
					<h1 class="imgupload ok"><i class="fa fa-check"></i></h1>
					<h1 class="imgupload stop"><i class="fa fa-times"></i></h1>
					<!--this field changes dinamically displaying the filename we are trying to upload-->
					<p id="namefile">Only these file types are allowed! (jpg,jpeg,bmp,png,docx,xls)</p>
					<!--our custom btn which which stays under the actual one-->
					<button type="button" id="btnup" class="btn btn-primary btn-lg">Add submission!</button>
					<!--this is the actual file input, is set with opacity=0 beacause we wanna see our custom one-->
					<input type="file" value="" name="fileup" id="fileup">
				</div>
			</div>
		</div>
			<!--additional fields-->
		<div class="row">			
			<div class="col-md-12">
				<!--the defauld disabled btn and the actual one shown only if the three fields are valid-->
				<input type="submit" value="Submit!" class="btn btn-primary" id="submitbtn">
				<button type="button" class="btn btn-default" disabled="disabled" id="fakebtn">Submit! <i class="fa fa-minus-circle"></i></button>
			</div>
		</div>
	</form>
</div>

<a href="http://www.emilianocostanzo.com" target="_blank" id="sign">EMI</a>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<script  src="assets/js/student.js"></script>

</body>
</html>