<%-- 
    Document   : addcalam
    Created on : Mar 1, 2017, 10:41:31 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="addcalam" style="margin-top: -65px;" class="modal fade" role="dialog"><!--Modal nhan vien-->
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 style=" color: #05B2D2;   text-align: center;" class="modal-title"><i class="glyphicon glyphicon-user"></i> Thêm Ca Làm</h4>
            </div>

            <form class="form-horizontal" name="fCalamviec" onsubmit="return validateFormCalamviec()"  action="AddcalamviecServlet" method="post" id="fAddCalamviec" >
                <input style="display: none;" name="idcalamviec" value="" />
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="tenca">Tên Ca <em>*</em> </label>
                    <div class="col-md-7">
                        <input type="text" name="tenca"value="" onkeyup='loadXMLCalamviec()'class="form-control" id="tenca" placeholder="">
                        <span id="errTenca"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="giobatdau">Giờ Bắt Đầu <em>*</em> </label>
                    <div class="col-md-7">
                        <input type="text" name="giobatdau"value=""class="form-control" id="fullname" placeholder="">
                        <span id="errUserName"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="gioketthuc">Giờ Kết Thúc <em>*</em> </label>
                    <div class="col-md-7">
                        <input type="text" name="gioketthuc"value=""class="form-control" id="fullname" placeholder="">
                        <span id="errUserName"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3" for="ghichu">Ghi Chú <em>*</em></label>
                    <div class="col-md-7">
                        <input type="text" name="ghichu" value="" class="form-control"  id="birthday">
                    </div>
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

            </form>
        </div>
    </div>
</div>
