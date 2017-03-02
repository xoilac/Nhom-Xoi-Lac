<%-- 
    Document   : editluong.jsp
    Created on : Feb 26, 2017, 7:16:41 PM
    Author     : Admin
--%>

<%@page import="com.javaweb.services.ChucVuServices"%>
<%@page import="com.javaweb.model.Chucvu"%>
<%@page import="com.javaweb.services.LuongServices"%>
<%@page import="com.javaweb.model.Luongnv"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javaweb.services.NhanVienServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@include file="includes/headtag.jsp" %>--%>
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

            <form class="form-horizontal" name="fChucvu<%=nv.getIdluongnv()%>" onsubmit="return validateFormLuong('<%=nv.getIdluongnv()%>')" action="EditluongServlet" method="post" id="fEditLuong">
                <input style="display: none;" name="idluongnv" value="<%=nv.getIdluongnv()%>" />

                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="chucvu">Chức vụ <em>*</em> </label>
                    <div class="col-md-7">
                        <select name="chucvu" class="form-control" id="chucvu<%=nv.getIdluongnv()%>" onchange="loadXMLChucvu('<%=nv.getIdluongnv()%>')" >
                            <%
                                ChucVuServices cvs = new ChucVuServices();
                                ArrayList<Chucvu> aCV = null;
                                aCV = cvs.GetAllChucvu();
                                for (int j = 0; j < aCV.size(); j++) {
                                    Chucvu cv = aCV.get(j);
                                    if (nv.getChucvu() == cv.getIdchucvu()) {
                            %>
                            <option value="<%=nv.getChucvu()%>" selected><%=cv.getTenchucvu()%></option>
                            <%
                            } else {
                            %>
                            <option value="<%=cv.getIdchucvu()%>"><%=cv.getTenchucvu()%></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                        <!--<input type="text" name="chucvu" value="" onchange ='loadXMLChucvu()' class="form-control" id="chucvu" placeholder="Họ và tên">-->
                        <span id="errChucvu<%=nv.getIdluongnv()%>"></span>
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
                        <input style="display: none;" id="giaTriCu<%=nv.getIdluongnv()%>" value="<%=nv.getChucvu()%>" />
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
