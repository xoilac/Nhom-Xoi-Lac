<%-- 
    Document   : CheckCalamviec
    Created on : Mar 2, 2017, 8:42:03 AM
    Author     : Admin
--%>

<%@page import="com.javaweb.services.CaLamViecServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("UTF-8");
    String Tenca = request.getParameter("tenca");

    if (!Tenca.equals("")) {
         CaLamViecServices us = new CaLamViecServices();
        boolean ketQua = ketQua = us.isCalamviecExists(Tenca);

        if (ketQua) {
%>
<font color=red>Ca này đã tồn tại</font>
<input type="hidden" id="actual" name="actual" value="taken">
<%
} else {
%>
<!--<font color=green>Tên người dùng có thể dùng</font>-->
<input type="hidden" id="actual" name="actual" value="available">
<%
            }
        }
%>
