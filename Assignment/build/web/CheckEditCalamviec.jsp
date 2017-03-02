<%-- 
    Document   : CheckEditCalamviec
    Created on : Mar 2, 2017, 9:00:39 AM
    Author     : Admin
--%>

<%@page import="com.javaweb.services.CaLamViecServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("UTF-8");
    String idluong = request.getParameter("idcalamviec");
    String tenca = request.getParameter("tenca");
    String giaTriCu = request.getParameter("old");

    if (!tenca.equals("")) {
        CaLamViecServices ls = new CaLamViecServices();
        boolean ketQua = ls.isCalamviecExists(tenca);

        if (ketQua && !giaTriCu.equals(tenca)) {
%>
<font color=red>Ca làm việc này đã tồn tại</font>
<input type="hidden" id="actual<%=idluong%>" name="actual" value="taken">
<%
} else {
%>
<!--<font color=green>Tên người dùng có thể dùng</font>-->
<input type="hidden" id="actual<%=idluong%>" name="actual" value="available">
<%
        }
    }
%>