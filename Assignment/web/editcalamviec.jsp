<%-- 
    Document   : editcalamviec.jsp
    Created on : Mar 1, 2017, 10:21:51 AM
    Author     : Admin
--%>

<%@page import="com.javaweb.model.Calamviec"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javaweb.services.CaLamViecServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    CaLamViecServices nvs = new CaLamViecServices();
    ArrayList<Calamviec> listcalam = null;

    listcalam = nvs.GetAllCalamviec();

    for (int i = 0; i < listcalam.size(); i++) {
        Calamviec nv = listcalam.get(i);
%>
<div id="editcalamviec<%=nv.getIdcalamviec()%>" style="margin-top: -65px;" class="modal fade" role="dialog"><!--Modal nhan vien-->
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 style=" color: #05B2D2;   text-align: center;" class="modal-title"><i class="glyphicon glyphicon-user"></i> Sửa Ca Làm</h4>
            </div>

            <form class="form-horizontal" name="fCalamviec"onsubmit="return validateFormEditCalamviec('<%=nv.getIdcalamviec()%>')"  action="EditcalamviecServlet" method="post" id="fEditCalamviec" >
                <input style="display: none;" name="idcalamviec" value="<%=nv.getIdcalamviec()%>" />
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="tenca">Tên Ca <em>*</em> </label>
                    <div class="col-md-7">
                        <input type="text" name="tenca" value="<%=nv.getTenca()%>" onkeyup='loadXMLEditCalamviec("<%=nv.getIdcalamviec()%>")' class="form-control" id="tenca<%=nv.getIdcalamviec()%>" placeholder="">
                        <span id="errTenca<%=nv.getIdcalamviec()%>"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="giobatdau">Giờ Bắt Đầu <em>*</em> </label>
                    <div class="col-md-7">
                        <input type="text" name="giobatdau"value="<%=nv.getGiobatdau()%>"class="form-control" id="fullname" placeholder="">
                        <span id="errUserName"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="gioketthuc">Giờ Kết Thúc <em>*</em> </label>
                    <div class="col-md-7">
                        <input type="text" name="gioketthuc"value="<%=nv.getGioketthuc() %>"class="form-control" id="fullname" placeholder="">
                        <span id="errUserName"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3" for="ghichu">Ghi Chú <em>*</em></label>
                    <div class="col-md-7">
                        <input type="text" name="ghichu" value="<%=nv.getGhichu()%>" class="form-control"  id="birthday">
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-md-2">
                    </div>
                </div>
                <div class="form-group" >
                    <div class="col-md-2">
                        <input style="display: none;" id="giaTriCu<%=nv.getIdcalamviec()%>" value="<%=nv.getTenca()%>" />
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