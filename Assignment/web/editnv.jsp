<%-- 
    Document   : editnv.jsp
    Created on : Feb 13, 2017, 8:57:22 AM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.javaweb.services.NhanVienServices"%>
<%@page import="com.javaweb.model.Nhanvien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    NhanVienServices nvs = new NhanVienServices();
    ArrayList<Nhanvien> eListNV = null;

    eListNV = nvs.GetAllNV();

    for (int i = 0; i < eListNV.size(); i++) {
        Nhanvien nv = eListNV.get(i);
%>
<div id="editnv<%=nv.getIdnhanvien()%>" style="margin-top: -65px;" class="modal fade" role="dialog"><!--Modal nhan vien-->
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 style=" color: #05B2D2;   text-align: center;" class="modal-title"><i class="glyphicon glyphicon-user"></i> Sửa nhân viên</h4>
            </div>

            <form class="form-horizontal" name="fUser"  action="EditnvServlet" method="post" id="fEditEmp" enctype="multipart/form-data">
                <input style="display: none;" name="idnv" value="<%=nv.getIdnhanvien()%>" />
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="fullname">Họ tên <em>*</em> </label>
                    <div class="col-md-7">
                        <input type="text" name="fullname"value="<%=nv.getHoten()%>"class="form-control" id="fullname" placeholder="Họ và tên">
                        <span id="errUserName"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3" for="birthday">Ngày sinh <em>*</em></label>
                    <div class="col-md-7">
                        <input type="date" name="birthday" value="<%=nv.getNgaysinh()%>" class="form-control"  id="birthday">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3" for="dienthoai">Điện thoại <em>*</em> </label>
                    <div class="col-md-7"> 
                        <input type="text" name="dienthoai" value="<%=nv.getSdt()%>" class="form-control"  id="dienthoai" placeholder="Điện thoại">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3" for="address">Địa chỉ </label>
                    <div class="col-md-7"> 
                        <input type="text" name="address" value="<%=nv.getDiachi()%>" class="form-control"  id="address" placeholder="Địa chỉ thường trú">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3" for="email">Email <em>*</em> </label>
                    <div class="col-md-7">
                        <input type="email" name="email" value="<%=nv.getEmail()%>" class="form-control"  id="email" placeholder="Email, abc@xyw.iuo">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Giới Tính</label>
                    <div class="col-md-7">
                        <% if (nv.isGioitinh()) {

                        %>
                        <input type="radio" name="gender" value="Nam" checked="checked" />Nam
                        <input type="radio" name="gender" value="Nữ" />Nữ
                        <%                            } else {
                        %>
                        <input type="radio" name="gender" value="Nam"  />Nam
                        <input type="radio" name="gender" value="Nữ"checked="checked" />Nữ
                        <%
                            }
                        %>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3" for="ngayVaoLam">Ngày vào làm <em>*</em></label>
                    <div class="col-md-7">
                        <input type="date" name="ngayVaoLam" value="<%=nv.getNgayvaolam()%>" class="form-control" id="ngayVaoLam">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3" for="cmnd">CMND <em>*</em></label>
                    <div class="col-md-7"> 
                        <input type="text" name="cmnd" value="<%=nv.getCmnd()%>" class="form-control" id="cmnd" placeholder="Chứng minh nhân dân">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3" for="ngayCap">Ngày cấp <em>*</em></label>
                    <div class="col-md-7">
                        <input type="date" name="ngayCap" value="<%=nv.getNgaycap()%>" class="form-control" id="ngayCap">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3" for="noiCap">Nơi cấp <em>*</em></label>
                    <div class="col-md-7"> 
                        <input type="text" name="noiCap" value="<%=nv.getNoicap()%>" class="form-control" id="noiCap" placeholder="Nơi cấp chứng minh nhân dân">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3" for="ghiChu">Ghi chú</label>
                    <div class="col-md-7">
                        <textarea rows="4" id="prod-describe" cols="10" class="form-control" name="ghiChu" value="<%=nv.getGhichu()%>" placeholder="Ghi chú"></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <input type="file" name="hinhAnh" size="50" onchange="loadFile(event, 'suanv<%=nv.getIdnhanvien()%>')" style="margin-top: 20px;    margin-left: 149px;border:none;"/>
                    <img id="outputsuanv<%=nv.getIdnhanvien()%>" src="<%=getServletContext().getInitParameter("file-upload")%><%=nv.getHinhanh()%>" style="width:100px;height:100px;    margin-left: 223px;">
                    
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
