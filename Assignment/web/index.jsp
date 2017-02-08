<%-- 
    Document   : index
    Created on : Jan 17, 2017, 3:50:19 PM
    Author     : tu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
        <%@include file="includes/headtag.jsp" %>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <div id="page-content" class="home-page">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Carousel -->
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <!-- Indicators -->
                            <ol class="carousel-indicators hidden-xs">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <!-- Wrapper for slides -->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="images/main-banner1-1903x600.jpg" alt="First slide">
                                    <!-- Static Header -->
                                    <div class="header-text hidden-xs">
                                        <div class="col-md-12 text-center">
                                        </div>
                                    </div><!-- /header-text -->
                                </div>
                                <div class="item">
                                    <img src="images/main-banner2-1903x600.jpg" alt="Second slide">
                                    <!-- Static Header -->
                                    <div class="header-text hidden-xs">
                                        <div class="col-md-12 text-center">
                                        </div>
                                    </div><!-- /header-text -->
                                </div>
                                <div class="item">
                                    <img src="images/main-banner3-1903x600.jpg" alt="Third slide">
                                    <!-- Static Header -->
                                    <div class="header-text hidden-xs">
                                        <div class="col-md-12 text-center">
                                        </div>
                                    </div><!-- /header-text -->
                                </div>
                            </div>
                            <!-- Controls -->
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div><!-- /carousel -->
                    </div>
                </div>
                <div class="row">
                    <div class="banner">
                        <div class="col-sm-4">
                            <img src="images/sub-banner1.png" alt=""/>
                        </div>
                        <div class="col-sm-4">
                            <img src="images/sub-banner2.png"alt="" />
                        </div>
                        <div class="col-sm-4">
                            <img src="images/sub-banner3.png"alt="" />
                        </div>
                    </div>
                </div>
                
                
                
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
