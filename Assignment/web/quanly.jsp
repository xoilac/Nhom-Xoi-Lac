<%-- 
    Document   : quanly
    Created on : Jan 17, 2017, 4:45:11 PM
    Author     : Admin
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.javaweb.model.Nhanvien"%>
<%@page import="com.javaweb.services.NhanVienServices"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản Lý</title>
        <%--<%@include file="includes/headtag.jsp" %>--%>
        <%@include file="include-dashboard/headtag.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="include-dashboard/sidebar.jsp" %>
            <!--Ghi nội dung -->
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <!--                        <h1 class="page-header">Quản lý người dùng</h1>-->
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <section class="container-fluid">
                        <div class="panel panel-default">

                            <div class="panel-heading">
                                <h1 style="color: #269abc;text-align: center"><b>Quản Lý Nhân Viên</b></h1>

                            </div>

                            <form action="" method="post">

                                <div class="form-group">
                                    <label>
                                        <select name="tacvu" class="form-control-static">
                                            <option value="">Tác vụ</option>
                                            <option value="xoa">Xóa</option>
                                        </select>
                                        <input class="btn btn-danger" type="submit" value="Thực hiện" />
                                    </label>
                                    <a href="#register" style="float: right; margin-right: 20px;"  class="btn btn btn-info btn-lg"data-toggle="modal" type="submit" value="" >
                                        <img src="images/profile-add-icon.png" alt=""/> Thêm Nhân Viên 
                                    </a>
                                </div>
                                <!-- Table -->
                                <script type="text/javascript">
                                    function check(source) {
                                        checkboxes = document.getElementsByName('idnv');
                                        for (var i = 0; i < checkboxes.length; i++) {
                                            checkboxes[i].checked = source.checked;
                                        }
                                    }
                                </script>
                                <%
                                    int pageSize = 10;
                                    int pageNumber = 1;
                                    String url = "quanly.jsp";
                                    NhanVienServices ps = new NhanVienServices();
                                    ArrayList<Nhanvien> listNV = null;

                                    if (request.getParameter("pagenumber") != null) {
                                        session.setAttribute("pagenumber", request.getParameter("pagenumber"));
                                        pageNumber = Integer.parseInt(request.getParameter("pagenumber"));
                                    } else {
                                        session.setAttribute("pagenumber", "1");
                                    }

                                    listNV = ps.getAllNv(pageSize, pageNumber);

                                    int pageCount = (ps.nvcount) / pageSize + (ps.nvcount % pageSize > 0 ? 1 : 0);

                                    String nextPage = (pageCount > pageNumber ? (pageNumber + 1) : pageNumber) + "";
                                    String prevPage = (pageNumber <= 1 ? 1 : pageNumber - 1) + "";


                                %>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th> <input type="checkbox" onclick="check(this)" />  All</th> 
                                            <th>TT</th>                        
                                            <th>Họ tên</th>                        
                                            <th>Ngày sinh</th> 
                                            <th>Giới tính</th> 
                                            <th>Ngày vào làm</th> 
                                            <th>Hình đại diện</th>
                                            <th>Sửa</th>
                                            <th>Xóa</th> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%                
                                            SimpleDateFormat sdf  = new SimpleDateFormat("dd-MM-yyyy");
                                            for (int i = 0; i < listNV.size(); i++) {
                                                Nhanvien nvql = listNV.get(i);
                                                int dem = i + 1;
                                                if (pageNumber > 1) {
                                                    dem = i + pageSize * (pageNumber - 1) + 1;
                                                }
                                        %>
                                        <tr>
                                            <th><input type="checkbox" name="idnv" value="<%=nvql.getIdnhanvien()%>" /></th>
                                            <th><%=dem%></th>
                                            <th><%=nvql.getHoten()%></th>
                                            <th><%=sdf.format(nvql.getNgaysinh())%></th>
                                                <% if (nvql.isGioitinh() == true) {

                                                %>
                                            <th>Nam</th>
                                                <%                                            } else {
                                                %>
                                            <th>Nữ</th>
                                            <%
                                                }
                                            %>
                                            <th><%=sdf.format(nvql.getNgayvaolam())%></th>
                                            <th><img src="<%=getServletContext().getInitParameter("file-upload")%><%=nvql.getHinhanh() %>" alt=""width="80px"height="80px"/></th> 
                                            <td>
                                                <a  href="#editnv<%=nvql.getIdnhanvien()%>" data-toggle="modal">
                                                    <img src="images/edit-file-icon.png" alt=""/>
                                                </a>
                                            </td>
                                            <td>
                                                <a href="DeleteUserServlet?iduser=<<%=nvql.getIdnhanvien()%>>" onclick="return confirm('Bạn có muốn xóa người dùng này?')">
                                                    <img src="images/Places-trash-empty-icon.png" alt=""/>
                                                </a>
                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </form>
                            <%@include file="dangky.jsp" %>
                            <%@include file="editnv.jsp" %>

                            <%
                                if (pageCount != 1) {
                            %>
                            <div class="panel-footer">
                                <nav aria-label="Page navigation">
                                    <ul class="pagination">
                                        <%
                                            if (pageNumber != 1) {
                                        %>
                                        <li><a aria-label="Previous" href="<%=url%>?pagenumber=<%=prevPage%>"><span aria-hidden="true">&laquo;</span></a></li>
                                            <%
                                                }
                                                for (int j = 1; j <= pageCount; j++) {
                                                    if (pageNumber == j) {
                                            %>
                                        <li class="active"><a href="<%=url%>?pagenumber=<%=j%>"><%=j%></a></li>
                                            <%
                                            } else {
                                            %>
                                        <li><a href="<%=url%>?pagenumber=<%=j%>"><%=j%></a></li>
                                            <%
                                                    }
                                                }
                                                if (pageNumber != pageCount) {
                                            %>
                                        <li><a aria-label="Next" href="<%=url%>?pagenumber=<%=nextPage%>"><span aria-hidden="true">&raquo;</span></a></li>
                                            <%
                                                }
                                            %>
                                    </ul>
                                </nav>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <%--<%@include file="includes/footer.jsp" %>--%>
    </body>
</html>
