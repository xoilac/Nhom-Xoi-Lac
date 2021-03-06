<%-- 
    Document   : baodanh
    Created on : Jan 17, 2017, 4:44:41 PM
    Author     : Admin
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javaweb.model.Diemdanh"%>
<%@page import="com.javaweb.services.ChamCongServices"%>
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
                                <h1 style="color: #269abc;text-align: center"><b>Chấm Công Nhân Viên</b></h1>

                            </div>

                            <form action="ChamCongServlet" method="post">

                                <div class="form-group">
                                    <label>
                                        <select name="thoigian" class="form-control-static">
                                            <option value="">Chọn tháng...</option>
                                            <%
                                                ChamCongServices ccs = new ChamCongServices();
                                                ArrayList<Diemdanh> aDD = null;
                                                aDD = ccs.LayGiaTriNam();
                                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                                                SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
                                            
                                                for (int i = 0; i < aDD.size(); i++) {
                                                    String nam = sdf.format(aDD.get(i).getThoigian());
                                            %>
                                            <optgroup label="<%=nam%>">
                                                <%
                                                    ArrayList<Diemdanh> aDD2 = ccs.LayGiaTriThangTheoNam(nam);
                                                    for (int j = 0; j < aDD2.size(); j++) {
                                                        String thang = sdf2.format(aDD2.get(j).getThoigian());
                                                %>
                                                <option value="<%=nam%>-<%=thang%>"><%=thang%></option>
                                                <%
                                                    }
                                                %>
                                            </optgroup>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </label>
                                    <label>
                                        <select name="tacvu" class="form-control-static">
                                            <option value="chamcong">Chấm công</option>
                                            <option value="view-list">Xem danh sách</option>
                                        </select>
                                        <input class="btn btn-danger" type="submit" value="Thực hiện" />
                                    </label>
                                </div>
                                <!-- Table -->
                                <script type="text/javascript">
                                    //                                    function check(source) {
                                    //                                        checkboxes = document.getElementsByName('iduser');
                                    //                                        for (var i = 0; i < checkboxes.length; i++) {
                                    //                                            checkboxes[i].checked = source.checked;
                                    //                                        }
                                    //                                    }
                                </script>
                                <%
                                    //                                    int pageSize = 10;
                                    //                                    int pageNumber = 1;
                                    //                                    String url = "UserManager.jsp";
                                    //                                    UserService ps = new UserService();
                                    //                                    ArrayList<User> listUser = null;
                                    //
                                    //                                    if (request.getParameter("pagenumber") != null) {
                                    //                                        session.setAttribute("pagenumber", request.getParameter("pagenumber"));
                                    //                                        pageNumber = Integer.parseInt(request.getParameter("pagenumber"));
                                    //                                    } else {
                                    //                                        session.setAttribute("pagenumber", "1");
                                    //                                    }
                                    //
                                    //                                    listUser = ps.getAllUser(pageSize, pageNumber);
                                    //
                                    //                                    int pageCount = (ps.usertcount) / pageSize + (ps.usertcount % pageSize > 0 ? 1 : 0);
                                    //
                                    //                                    String nextPage = (pageCount > pageNumber ? (pageNumber + 1) : pageNumber) + "";
                                    //                                    String prevPage = (pageNumber <= 1 ? 1 : pageNumber - 1) + "";

                                %>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <!--                                            <th> <input type="checkbox" onclick="check(this)" />  All</th> -->
                                            <th>TT</th>                        


                                            <th>Họ tên</th>                        
                                            <th>Ngày sinh</th> 
                                            <th>Giới tính</th> 



                                            <th>Hình đại diện</th>
                                            <th>Chức Vụ</th>
                                            <th>Số ngày làm</th>
                                            <th>Lương</th>

                                        </tr>

                                    </thead>
                                    <tbody>
                                        <% //                                    for (int i = 0; i < listUser.size(); i++) {
                                            //                                                User user = listUser.get(i);
                                            //                                                int dem =i+1;
                                            //                                                if(pageNumber>1){
                                            //                                                    dem=i+pageSize * (pageNumber -1)+1;
                                            //                                                }
                                        %>
                                        <tr>
                                            <!--                                            <th><input type="checkbox" name="iduser" value="<>" /></th>-->
                                            <th>1</th>
                                            <th>Tô văn Tư</th>
                                            <th>05/02/1997</th>
                                            <th>Nam</th>
                                            <th><img src="images/tải xuống.jpg" alt=""width="50px"height="50px"/></th> 
                                            <th>Quản Lý</th>
                                            <th>30</th>
                                            <th>2000000</th>





                                        </tr>
                                        <%//                                            }
                                        %>



                                    </tbody>

                                </table>
                            </form>

                        </div>
                    </section>
                </div>
                <%--<%@include file="includes/footer.jsp" %>--%>
                </body>
                </html>
