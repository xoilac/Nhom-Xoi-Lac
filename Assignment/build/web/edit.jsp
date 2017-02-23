<%-- 
    Document   : edit.jsp
    Created on : Feb 13, 2017, 8:57:22 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="edit" style="margin-top: -65px;" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 style=" color: #05B2D2;   text-align: center;" class="modal-title"><i class="glyphicon glyphicon-user"></i> Sửa nhân viên</h4>
            </div>
            <form class="form-horizontal" name="fUser" onsubmit="return validateFormUser()" action="" method="post" id="fregister">

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

                    <input type="file" name="file" size="50" onchange="loadFile(event,'suanv')" style="margin-top: 20px;    margin-left: 149px;border:none;"/>
                    <img id="outputsuanv" src="" style="width:100px;height:100px;    margin-left: 223px;">
<!--                    <script type="text/javascript">
                        var loadFile = function (event) {
                            var ouput = document.getElementById('ouput');
                            output.src = URL.createObjectURL(event.target.files[0]);
                        }

                    </script>-->
                </div>



                <div class="form-group">
                    <div class="col-md-2">
                    </div>
                    
                </div>
                <div class="form-group" >
                    <div class="col-md-2">
                    </div>
                    <button type="submit"  class="btn btn-twitter">Sửa</button>
                </div>

            </form>
        </div>
    </div>
</div>
