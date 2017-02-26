<%-- 
    Document   : quanlyluong.jsp
    Created on : Feb 26, 2017, 6:32:42 PM
    Author     : Admin
--%>

<%@page import="com.javaweb.services.LuongServices"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javaweb.services.NhanVienServices"%>
<%@page import="com.javaweb.model.Luongnv"%>

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
                                <h1 style="color: #269abc;text-align: center"><b>Quản Lý lương</b></h1>

                            </div>

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
                                    String url = "quanlyluong.jsp";
                                    LuongServices ps = new LuongServices();
                                    ArrayList<Luongnv> listluong = null;

                                    if (request.getParameter("pagenumber") != null) {
                                        session.setAttribute("pagenumber", request.getParameter("pagenumber"));
                                        pageNumber = Integer.parseInt(request.getParameter("pagenumber"));
                                    } else {
                                        session.setAttribute("pagenumber", "1");
                                    }

                                    listluong = ps.getAllLuong(pageSize, pageNumber);

                                    int pageCount = (ps.lcount) / pageSize + (ps.lcount % pageSize > 0 ? 1 : 0);

                                    String nextPage = (pageCount > pageNumber ? (pageNumber + 1) : pageNumber) + "";
                                    String prevPage = (pageNumber <= 1 ? 1 : pageNumber - 1) + "";


                                %>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            
                                            <th>TT</th>                        
                                            <th>Chức vụ</th>                        
                                            <th>Lương cơ bản</th> 
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%                                            
                                            for (int i = 0; i < listluong.size(); i++) {
                                                Luongnv luong = listluong.get(i);
                                                int dem = i + 1;
                                                if (pageNumber > 1) {
                                                    dem = i + pageSize * (pageNumber - 1) + 1;
                                                }
                                        %>
                                        <tr>
                                            
                                            <th><%=dem%></th>
                                            <th><%=luong.getChucvu()%></th>
                                              <th><%=luong.getLuongcoban()%></th>
                                            <td>
                                                <a  href="#editluong<%=luong.getIdluongnv()%>" data-toggle="modal">
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
                                        <%@include file="editluong.jsp" %>

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
