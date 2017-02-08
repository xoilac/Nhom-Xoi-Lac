<%-- 
    Document   : dangky
    Created on : Jan 18, 2017, 9:15:37 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng ký</title>
        <%@include file="includes/headtag.jsp" %>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <section class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="heading-row">
                        <h3 style="color: #269abc"><b>Thêm Nhân Viên</b></h3>
                    </div>
                    <form class="form-horizontal" name="fUser" onsubmit="return validateFormUser()" action="RegsisterServlet" method="post" id="fregister">

                        <div class="form-group">
                            <label class="control-label col-sm-2 col-md-3" for="username">Họ tên <em>*</em> </label>
                            <div class="col-md-7">
                                <input type="text" name="username" onkeyup='loadXMLUserName()' class="form-control" id="username">
                                <span id="errUserName"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3" for="birthday">Ngày sinh <em>*</em></label>
                            <div class="col-md-7">
                                <input type="date" name="birthday"  class="form-control"  id="birthday">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3" for="dienthoai">Điện thoại <em>*</em> </label>
                            <div class="col-md-7"> 
                                <input type="text" name="dienthoai"  class="form-control"  id="dienthoai">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3" for="address">Địa chỉ </label>
                            <div class="col-md-7"> 
                                <input type="text" name="address"  class="form-control"  id="address">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3" for="email">Email <em>*</em> </label>
                            <div class="col-md-7">
                                <input type="email" name="email"  class="form-control"  id="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Giới Tính:</label>
                            <div class="col-md-7">
                                <input type="radio" name="gender" value="Nam" checked="checked" />Nam
                                <input type="radio" name="gender" value="Nữ"/>Nữ
                            </div>
                        </div>

                        <div class="form-group">

                            <input type="file" name="file" size="50" onchange="loadFile(event)" style="margin-top: 20px;    margin-left: 306px;"/>
                            <img id="output" src="" style="    margin-left: 306px;">
                            <script type="text/javascript">
                                var loadFile = function (event) {
                                    var ouput = document.getElementById('ouput');
                                    output.src = URL.createObjectURL(event.target.files[0]);
                                }

                            </script>
                        </div>



                        <div class="form-group">
                            <div class="col-md-2">
                            </div>
                            <div class="col-md-3">
                                <input required="" type="checkbox" name="rememberMe" value="Y">Đồng ý! 
                            </div>
                        </div>
                        <div class="form-group" >
                            <div class="col-md-2">
                            </div>
                            <button type="submit"  class="btn btn-twitter">Đăng Ký</button>
                        </div>

                    </form>
                </div>
            </div>
        </section>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
