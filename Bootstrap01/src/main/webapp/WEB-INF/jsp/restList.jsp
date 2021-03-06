<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Blank</title>

    <!-- Custom fonts for this template-->
    <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- fontawsome kit css code -->
	<script src="https://kit.fontawesome.com/7ee5571815.js" crossorigin="anonymous"></script>
    <!-- Custom styles for this template-->
    <link href="../css/sb-admin-2.min_yuna.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar" 
        	style="background-color:yellow; background-image:linear-gradient(180deg,#3f3f3f 10%,#ffc800 100%);">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index">
                
                <div class="sidebar-brand-text mx-3">Admin</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>My page</span>
                </a>
            </li>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Member Management</span>
                </a>
            </li>

            <!-- Nav Item - mypage -->
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Notice</span>
                </a>
            </li>

            <!-- Nav Item - ???????????? -->
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Community</span>
                </a>
            </li>

            <!-- Nav Item - ???????????? -->
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Vote</span>
                </a>
            </li>

            <!-- Nav Item - ???????????? -->
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-comments fa-2x"></i>
                    <span>FAQ</span>
                </a>
            </li>

            <!-- Nav Item - ???????????? -->
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-exclamation-triangle"></i>
                    <span>REST List</span>
                </a>
            </li>
            
           <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    
                    <!-- Topbar Navbar -->
                    

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="card shadow mb-4">
                	<!-- content header ?????? -->
                	<div class="card-header py-3">
                	REST LIST
                	</div>
                	
                	<!-- content body ?????? -->
                	<div class="card-body">
                		<div class="container">
                			<div class="row">
                				<table class="table" style="text-align: center; border: 1px solid #dddddd;">
                					<thead>
                						<tr>
                							<th style="background-color: #eeeeee; text-align: center;">No</th>
                							<th style="background-color: #eeeeee; text-align: center;">?????????</th>
                							<!-- 
                							<th style="background-color: #eeeeee; text-align: center;">??????</th>
                							 -->
                							<th style="background-color: #eeeeee; text-align: center;">?????????</th>
                							<th style="background-color: #eeeeee; text-align: center;">??????</th>
                							<th style="background-color: #eeeeee; text-align: center;">????????????</th>                							 
                							<th style="background-color: #eeeeee; text-align: center;">????????????</th>                							 
                							<th style="background-color: #eeeeee; text-align: center;">????????????</th>
                							<th style="background-color: #eeeeee; text-align: center;">??????</th>
                							
                						</tr>
                					</thead>
                					<tbody>
                					<c:forEach var="dto" items="${restList}" varStatus="status">
	               						<tr>
	               							<th>${dto.restNo}</th>
	                						<th>${dto.memberId}</th>
	                						<th>${dto.noticeNo}</th>
	                						<th>${dto.reason}</th>
	                						<th>${dto.restEnroll}</th>
	                						<th>${dto.restConfirm}</th>
	                						<!-- 
	                						<th>2020-05-11</th>
	                						<th>2020-11-20</th>
	                						 -->
	                						<th>
	                							<c:choose>
	                								<c:when test="${dto.restCheck eq 'F'}">????????????</c:when>
	                								<c:when test="${dto.restCheck eq 'T'}">????????????</c:when>
	                							</c:choose>
	                						</th>
	                						<th><a href="restMenagement"><i class="fas fa-fw fa-cog"></i></a></th>
	                					</tr>
                					</c:forEach>
                					</tbody>
                				</table>
                			</div>
                		</div>
                	</div>
                	
                    <!-- Page Heading -->
                    <!-- 
                    <h1 class="h3 mb-4 text-gray-800">Blank Page</h1>
                     -->

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Team2 Project 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">??</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="../js/sb-admin-2.min_yuna.js"></script>

</body>

</html>