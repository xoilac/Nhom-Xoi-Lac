<%-- 
    Document   : editluong.jsp
    Created on : Feb 26, 2017, 7:16:41 PM
    Author     : Admin
--%>

<%@page import="com.javaweb.services.LuongServices"%>
<%@page import="com.javaweb.model.Luongnv"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javaweb.services.NhanVienServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    LuongServices nvs = new LuongServices();
    ArrayList<Luongnv> eListLuong = null;

    eListLuong = nvs.GetAllluongnv();

    for (int i = 0; i < eListLuong.size(); i++) {
        Luongnv nv = eListLuong.get(i);
%>
<div id="editluong<%=nv.getIdluongnv()%>" style="margin-top: -65px;" class="modal fade" role="dialog"><!--Modal nhan vien-->
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 style=" color: #05B2D2;   text-align: center;" class="modal-title"><i class="glyphicon glyphicon-user"></i> Sửa nhân viên</h4>
            </div>

            <form class="form-horizontal" name="fUser"  action="EditluongServlet" method="post" id="fEditEmp">
                <input style="display: none;" name="idluongnv" value="<%=nv.getIdluongnv()%>" />
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="chucvu">Chức vụ <em>*</em> </label>
                    <div class="col-md-7">
                        <input type="text" name="chucvu"value="<%=nv.getChucvu()%>"class="form-control" id="fullname" placeholder="Họ và tên">
                        <span id="errUserName"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3" for="luongcoban">Lương cơ bản <em>*</em></label>
                    <div class="col-md-7">
                        <input type="text" name="luongcoban" value="<%=nv.getLuongcoban()%>" class="form-control"  id="birthday">
                    </div>
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
<%
    }
%>
