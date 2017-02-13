<%-- 
    Document   : header
    Created on : Jan 17, 2017, 3:42:06 PM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header class="container-fluid">
    
    <div class="row">
        <nav class="navbar navbar-inverse menu-bar" id="nav">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span> 
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav ">
                        <li><a href="index.jsp" class="menu active"><span class="glyphicon glyphicon-home"></span></a></li>
                        <!--<li><a href="addproduct.jsp" class="menu">Thêm sản phẩm</a></li>-->
<!--                        <
                            if (session.getAttribute("tenHo") != null) {
                        >-->
                        
<!--                            <                                }
                            >-->
                        
                        <li><a href="baodanh.jsp" class="menu">Báo Danh</a></li>
                        <li><a href="quanly.jsp" class="menu">Quản Lý</a></li>
                        
                    </ul>

                    
                    <ul class="nav navbar-nav navbar-right">
                        <li> <hr></li>
<!--                            
                                if (session.getAttribute("email") == null) {
                            -->
                        <li><a href="dangky.jsp">
                                <span class="glyphicon glyphicon-user"></span>Thêm Nhân Viên
                            </a>
                        </li>
                        <li>
                            <a href="#myModal" style="outline: none;" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a>

                            <div id="myModal" style="margin-top: 130px;" class="modal fade" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title"><i class="glyphicon glyphicon-user"></i> Đăng nhập</h4>
                                        </div>

                                        <form class="form-horizontal"action="LoginServlet" method="post">

                                            <div class="form-group">
                                                <label class="control-label col-sm-3" for="email"> Tên đăng nhập</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="email" class="form-control" id="email" placeholder="Nhập tên đăng nhập">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-sm-3" for="pwd">Mật khẩu</label>
                                                <div class="col-sm-8"> 
                                                    <input type="password" name="pw" class="form-control" id="pwd" placeholder="Nhập mật khẩu">
                                                </div>
                                            </div>

                                            <div class="form-group"> 
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <button type="submit" class="btn btn-info" style="margin-left: 150px;">Đăng nhập</button>

                                                </div>

                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </li>
                        <!--<ul id="login-dp" class="dropdown-menu">-->
<!--                        
                        } else {
                        -->
                        <li class="dropdown-submenu menu dropdown">
                            <a href="index.jsp" class="dropdown-toggle menu dropbtn">
<!--                                <i class="glyphicon glyphicon-user"> <strong style="color: white"><=session.getAttribute("fullname")> </strong></i>-->
                            </a>
                            <ul class="dropdown-menu menu dropdown-content">
                                
                                    <a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span>Thoát</a>
                                </li>
                            </ul>
                        </li>

<!--                        <
                            }
                        >-->
                        <!--</ul>-->
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>