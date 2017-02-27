<%-- 
    Document   : addchucvu
    Created on : Feb 27, 2017, 4:06:31 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="addchucvu" style="margin-top: -65px;" class="modal fade" role="dialog"><!--Modal nhan vien-->
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 style=" color: #05B2D2;   text-align: center;" class="modal-title"><i class="glyphicon glyphicon-user"></i> Sửa nhân viên</h4>
            </div>

            <form class="form-horizontal" name="fUser"  action="AddChucVuServlet" method="post" id="fEditEmp" >
                <input style="display: none;" name="idchucvu" value="" />
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="tenchucvu">Chức vụ <em>*</em> </label>
                    <div class="col-md-7">
                        <input type="text" name="tenchucvu"value=""class="form-control" id="fullname" placeholder="">
                        <span id="errUserName"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3" for="mota">Mô tả <em>*</em></label>
                    <div class="col-md-7">
                        <input type="text" name="mota" value="" class="form-control"  id="birthday">
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