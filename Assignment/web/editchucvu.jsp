<%-- 
    Document   : editchucvu.jsp
    Created on : Feb 26, 2017, 7:40:52 PM
    Author     : Admin
--%>

<%@page import="com.javaweb.model.Chucvu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javaweb.services.ChucVuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ChucVuServices nvs = new ChucVuServices();
    ArrayList<Chucvu> listchucvu = null;

    listchucvu = nvs.GetAllChucvu();

    for (int i = 0; i < listchucvu.size(); i++) {
        Chucvu nv = listchucvu.get(i);
%>
<div id="edit<%=nv.getIdchucvu()%>" style="margin-top: -65px;" class="modal fade" role="dialog"><!--Modal nhan vien-->
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 style=" color: #05B2D2;   text-align: center;" class="modal-title"><i class="glyphicon glyphicon-user"></i> Sửa nhân viên</h4>
            </div>

            <form class="form-horizontal" name="fUser"  action="EditchucvuServlet" method="post" id="fEditEmp" enctype="multipart/form-data">
                <input style="display: none;" name="idchuvu" value="<%=nv.getIdchucvu()%>" />
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="tenchucvu">Họ tên <em>*</em> </label>
                    <div class="col-md-7">
                        <input type="text" name="tenchucvu"value="<%=nv.getTenchucvu()%>"class="form-control" id="fullname" placeholder="Họ và tên">
                        <span id="errUserName"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3" for="mota">Ngày sinh <em>*</em></label>
                    <div class="col-md-7">
                        <input type="date" name="mota" value="<%=nv.getMota()%>" class="form-control"  id="birthday">
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
