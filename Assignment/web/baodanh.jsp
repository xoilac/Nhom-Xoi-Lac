<%-- 
    Document   : baodanh
    Created on : Jan 17, 2017, 4:44:41 PM
    Author     : Admin
--%>

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
                    <section class="container-fluid">
                        <div class="panel panel-default">

                            <div class="panel-heading">
                                <h1 style="color: #269abc;text-align: center"><b>Điểm Danh Nhân Viên</b></h1>

                            </div>

                            <form action="DiemDanhServlet" method="post">

                                <div class="form-group">
                                    <label style="    ">
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



                                            <th>Hình đại diện</th>
                                            <th>Trạng thái</th>

                                        </tr>

                                    </thead>
                                    <tbody>
                                        <%                                           for (int i = 0; i < listNV.size(); i++) {
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
                                            <th><%=nvql.getNgaysinh()%></th>
                                            <% if (nvql.isGioitinh() == true) {

                                            %>
                                            <th>Nam</th>
                                                <%                                            } else {
                                                %>
                                            <th>Nữ</th>
                                                <%
                                                    }
                                                %>
                                            
                                            <th><img src="images/tải xuống.jpg" alt=""width="50px"height="50px"/></th> 
                                            <% if (nvql.isTrangthai()== true) {

                                            %>
                                            <th>Có mặt</th>
                                                <%                                            } else {
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
