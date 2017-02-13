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
        <script type="text/javascript">
            $(window).load(function () {
                $('#myModal').modal('show');
            });
        </script>
        <div id="myModal" style="margin-top: 130px;" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 style=" color: #05B2D2;   text-align: center;" class="modal-title"><i class="glyphicon glyphicon-user"></i> Đăng nhập</h4>
                    </div>

                    <form class="form-horizontal"action="loginServlet" method="post">

                        <div class="form-group">
                            <!--                            <label class="control-label col-sm-3" for="email"> Tên đăng nhập</label>-->
                            <div class="col-sm-8" style="    margin-left: 82px;">
                                <input type="text" name="email" class="form-control" id="email" placeholder="Nhập tên đăng nhập">
                            </div>
                        </div>
                        <div class="form-group">
                            <!--                            <label class="control-label col-sm-3" for="pwd">Mật khẩu</label>-->
                            <div class="col-sm-8" style="    margin-left: 82px; "> 
                                <input type="password" name="pw" class="form-control" id="pwd" placeholder="Nhập mật khẩu">
                            </div>
                        </div>

                        <div class="form-group"> 
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-info" style="margin-left: 82px;">Đăng nhập</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>

                        </div>
                    </form>
                </div>

            </div>
        </div>
    </body>
</html>
