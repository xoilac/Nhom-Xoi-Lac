<%-- 
    Document   : chucvu.jsp
    Created on : Feb 26, 2017, 7:40:41 PM
    Author     : Admin
--%>

<%@page import="com.javaweb.model.Chucvu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javaweb.model.Luongnv"%>
<%@page import="com.javaweb.services.ChucVuServices"%>
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
                                <h1 style="color: #269abc;text-align: center"><b>Chức vụ</b></h1>

                            </div>

                            <a href="#addchucvu" style="float: right; margin-right: 20px;    margin-bottom: -24px;
                               margin-top: 10px;"  class="btn btn btn-info btn-lg"data-toggle="modal" type="submit" value="" >
                                <img src="images/profile-add-icon.png" alt=""/> Thêm Chức vụ
                            </a>
                            <form action="" method="post">


                                <!-- Table -->
                                <script type="text/javascript">
                                    function check(source) {
                                        checkboxes = document.getElementsByName('idluongnv');
                                        for (var i = 0; i < checkboxes.length; i++) {
                                            checkboxes[i].checked = source.checked;
                                        }
                                    }
                                </script>
                                <%
                                    int pageSize = 10;
                                    int pageNumber = 1;
                                    String url = "chucvu.jsp";
                                    ChucVuServices ps = new ChucVuServices();
                                    ArrayList<Chucvu> listchucvus = null;

                                    if (request.getParameter("pagenumber") != null) {
                                        session.setAttribute("pagenumber", request.getParameter("pagenumber"));
                                        pageNumber = Integer.parseInt(request.getParameter("pagenumber"));
                                    } else {
                                        session.setAttribute("pagenumber", "1");
                                    }

                                    listchucvus = ps.getAllchucvuoder(pageSize, pageNumber);

                                    int pageCount = (ps.lcount) / pageSize + (ps.lcount % pageSize > 0 ? 1 : 0);

                                    String nextPage = (pageCount > pageNumber ? (pageNumber + 1) : pageNumber) + "";
                                    String prevPage = (pageNumber <= 1 ? 1 : pageNumber - 1) + "";


                                %>
                                <table class="table">
                                    <thead>
                                        <tr>

                                            <th>TT</th>                        
                                            <th>Tên chức vụ</th>                        
                                            <th>Mô tả</th> 

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%                                            for (int i = 0; i < listchucvus.size(); i++) {
                                                Chucvu chucvu = listchucvus.get(i);
                                                int dem = i + 1;
                                                if (pageNumber > 1) {
                                                    dem = i + pageSize * (pageNumber - 1) + 1;
                                                }
                                        %>
                                        <tr>

                                            <th><%=dem%></th>
                                            <th><%=chucvu.getTenchucvu()%></th>
                                            <th><%=chucvu.getMota()%></th>
                                            <td>
                                                <a  href="#editchucvu<%=chucvu.getIdchucvu()%>" data-toggle="modal">
                                                    <img src="images/edit-file-icon.png" alt=""/>
                                                </a>
                                            </td>

                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </form>
                            <%@include file="editchucvu.jsp" %>
                            <%@include file="addchucvu.jsp" %>
                            <%                                if (pageCount != 1) {
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
<%-- 
    Document   : baodanh
    Created on : Jan 17, 2017, 4:44:41 PM
    Author     : Admin
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.javaweb.model.Diemdanh"%>
<%@page import="java.util.Date"%>
<%@page import="com.javaweb.services.DiemDanhServices"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javaweb.model.Nhanvien"%>
<%@page import="com.javaweb.services.NhanVienServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Điểm Danh</title>
        <%@include file="include-dashboard/headtag.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="include-dashboard/sidebar.jsp" %>
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                    </div>
                </div>
                <div class="row">
                    <%
                        int pageSize = 10;
                        int pageNumber = 1;
                        
                        ArrayList<Diemdanh> listDD = null;
                        ArrayList<Nhanvien> listNV = null;
                        
                        Date today = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        
                        DiemDanhServices dds = new DiemDanhServices();
                        NhanVienServices nvs = new NhanVienServices();
                        
                        String strToDay = sdf.format(today);
                        Diemdanh themrd = null;
                        
                        listNV = nvs.GetAllNV();
                        listDD = dds.LayTheoNgayHomNay(strToDay, pageSize, pageNumber);

                        if (listDD.size() == 0) {
                            for (int i = 0; i < listNV.size(); i++) {
                                int idNV = listNV.get(i).getIdnhanvien();
                                themrd = new Diemdanh(idNV, 1, today, false, "");
                                dds.InsertRecord(themrd);
                            }
                        }
                    %>
                    <section class="container-fluid">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1 style="color: #269abc;text-align: center"><b>Điểm Danh Nhân Viên</b></h1>
                            </div>
                            <form action="DiemDanhServlet" method="post">
                                <div class="form-group">
                                    <label>
                                        <select name="tacvu" class="form-control-static">
                                            <option value="">Tác vụ</option>
                                            <option value="true">Điểm danh</option>
                                            <option value="false">Vắng</option>
                                        </select>
                                        <input class="btn btn-danger" type="submit" value="Thực hiện" />
                                    </label>
                                </div>

                                <script type="text/javascript">
                                    function check(source) {
                                        checkboxes = document.getElementsByName('idnv');
                                        for (var i = 0; i < checkboxes.length; i++) {
                                            checkboxes[i].checked = source.checked;
                                        }
                                    }
                                </script>
                                <%                                    String url = "baodanh.jsp";
                                    if (request.getParameter("pagenumber") != null) {
                                        session.setAttribute("pagenumber", request.getParameter("pagenumber"));
                                        pageNumber = Integer.parseInt(request.getParameter("pagenumber"));
                                    } else {
                                        session.setAttribute("pagenumber", "1");
                                    }

                                    int pageCount = (dds.ddcount) / pageSize + (dds.ddcount % pageSize > 0 ? 1 : 0);

                                    String nextPage = (pageCount > pageNumber ? (pageNumber + 1) : pageNumber) + "";
                                    String prevPage = (pageNumber <= 1 ? 1 : pageNumber - 1) + "";


                                %>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th> <input type="checkbox" onclick="check(this)" />  All</th> 
                                            <th>TT</th>                        
                                            <th>Họ tên</th>                        
                                            <th>Thời gian</th> 
                                            <th>Giới tính</th> 
                                            <th>Hình đại diện</th>
                                            <th>Trạng thái</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%                
                                            listDD = dds.LayTheoNgayHomNay(strToDay, pageSize, pageNumber);
                                            Nhanvien nv = null;
                                            for (int i = 0; i < listDD.size(); i++) {
                                                Diemdanh nvbd = listDD.get(i);
                                                int dem = i + 1;
                                                if (pageNumber > 1) {
                                                    dem = i + pageSize * (pageNumber - 1) + 1;
                                                }
                                                int idnv = nvbd.getNhanvien();
                                                nv = nvs.getNVByID(idnv + "");
                                                SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                                
                                        %>
                                        <tr>
                                            <th><input type="checkbox" name="idnv" value="<%=nvbd.getNhanvien()%>" /></th>
                                            <th><%=dem%></th>
                                            <th><%=nv.getHoten()%></th>
                                            <th><%=sdf2.format(nvbd.getThoigian())%></th>
                                                <% if (nv.isGioitinh() == true) {
                                                %>
                                            <th>Nam</th>
                                                <%
                                                } else {
                                                %>
                                            <th>Nữ</th>
                                                <%
                                                    }
                                                %>

                                            <th><img src="<%=getServletContext().getInitParameter("file-upload")%><%=nv.getHinhanh()%>" alt=""width="80px"height="80px"/></th> 
                                                <% if (nvbd.isTrangthai()== true) {

                                                %>
                                            <th>Có mặt</th>
                                                <%                                                } else {
                                                %>
                                            <th>Vắng</th>
                                                <%
                                                    }
                                                %>
                                        </tr>
                                    </tbody>
                                    <%
                                        }
                                    %>
                                </table>
                            </form>
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
    </body>
</html>
