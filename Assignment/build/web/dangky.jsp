<%-- 
    Document   : dangky
    Created on : Jan 18, 2017, 9:15:37 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="register" style="margin-top: -65px;" class="modal fade" role="dialog"><!--Mở modal đăng ký-->
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 style=" color: #05B2D2;   text-align: center;" class="modal-title"><i class="glyphicon glyphicon-user"></i> Thêm nhân viên</h4>
            </div>
            <form class="form-horizontal" name="fUser"  action="AddEmployee" method="post" id="" enctype="multipart/form-data">

                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="fullname">Họ tên <em>*</em> </label>
                    <div class="col-md-7">
                        <input type="text" name="fullname" class="form-control" id="fullname">
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
                    <label class="control-label col-md-3" for="ngayVaoLam">Ngày vào làm </label>
                    <div class="col-md-7">
                        <input type="date" name="ngayVaoLam"  class="form-control"  id="ngayVaoLam">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3" for="cmnd">Chứng minh nhân dân </label>
                    <div class="col-md-7"> 
                        <input type="text" name="cmnd"  class="form-control"  id="cmnd">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3" for="ngayCap">Ngày cấp </label>
                    <div class="col-md-7">
                        <input type="date" name="ngayCap"  class="form-control"  id="ngayCap">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3" for="noiCap">Nơi cấp </label>
                    <div class="col-md-7"> 
                        <input type="text" name="noiCap"  class="form-control"  id="noiCap">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3" for="ghiChu">Ghi chú</label>
                    <div class="col-md-7">
                        <textarea rows="4" id="prod-describe" cols="10" class="form-control" name="ghiChu"></textarea>
                    </div>
                </div>


                <div class="form-group">
                    <input type="file" name="hinhAnh" size="50" onchange="loadFile(event, 'themnv')" style="margin-top: 20px;    margin-left: 149px;border:none;"/>
                    <img id="outputthemnv" src="" style="width:100px;height:100px;    margin-left: 223px;">
                </div>

                <div class="form-group">
                    <div class="col-md-2">
                    </div>
                </div>
                <div class="form-group" >
                    <div class="col-md-2">
                    </div>
                    <button type="submit"  class="btn btn-twitter">Thêm</button>
                </div>

            </form><!--Đóng form thêm-->
        </div>
    </div>
</div><!--Đóng modal đăng ký-->
