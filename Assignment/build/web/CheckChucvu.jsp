<%-- 
    Document   : CheckChucvu.jsp
    Created on : Mar 1, 2017, 6:49:24 PM
    Author     : Admin
--%>

<%@page import="com.javaweb.services.LuongServices"%>
<%@page import="com.javaweb.services.ChucVuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("UTF-8");
    String idluong = request.getParameter("idluong");
    String chucvu = request.getParameter("chucvu");
    String giaTriCu = request.getParameter("old");

    if (!chucvu.equals("")) {
        LuongServices ls = new LuongServices();
        boolean ketQua = ls.isChucvuExists(chucvu);

        if (ketQua && !giaTriCu.equals(chucvu)) {
%>
<font color=red>Chức vụ này đã có mức lương riêng </font>
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