<%-- 
    Document   : quanly
    Created on : Jan 17, 2017, 4:45:11 PM
    Author     : Admin
--%>

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
                                    <label style="   ">
                                        <select name="tacvu" class="form-control-static">
                                            <option value="">Tác vụ</option>
                                            <option value="xoa">Xóa</option>
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
                                            <th> <input type="checkbox" onclick="check(this)" />  All</th> 
                                            <th>TT</th>                        


                                            <th>Họ tên</th>                        
                                            <th>Ngày sinh</th> 
                                            <th>Giới tính</th> 
                                            <th>Ngày vào làm</th> 
                                            <th>Số ngày làm</th> 
                                            <th>Lương</th> 

                                            <th>Hình đại diện</th>


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
                                            <th><input type="checkbox" name="iduser" value="<>" /></th>
                                            <th>1</th>
                                            <th>Tô văn Tư</th>
                                            <th>05/02/1997</th>
                                            <th>Nam</th>
                                            <th>12/12/2016</th>
                                            <th>30</th>
                                            <th>6000000 vnđ</th>
                                            <th><img src="images/tải xuống.jpg" alt=""width="50px"height="50px"/></th> 




                                            <td>
                                                <a href="edituser.jsp?iduser=<>">Edit</a>
                                            </td>

                                            <td>

                                                <a href="DeleteUserServlet?iduser=<>" onclick="return confirm('Bạn có muốn xóa người dùng này?')">Delete</a>
                                            </td>

                                        </tr>
                                        <%//                                            }
                                        %>



                                    </tbody>

                                </table>
                            </form>

                            <%//                                if (pageCount != 1) {
                            %>
                            <div class="panel-footer">
                                <nav aria-label="Page navigation">
                                    <ul class="pagination">

                                    </ul>
                                </nav>
                            </div>
                            <%//                                }
                            %>
                        </div>
                    </section>
                </div>
                <%--<%@include file="includes/footer.jsp" %>--%>
                </body>
                </html>
