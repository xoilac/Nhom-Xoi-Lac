package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class baodanh_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/include-dashboard/headtag.jsp");
    _jspx_dependants.add("/include-dashboard/sidebar.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Điểm Danh</title>\r\n");
      out.write("       ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap Core CSS -->\r\n");
      out.write("<link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- MetisMenu CSS -->\r\n");
      out.write("<link href=\"vendor/metisMenu/metisMenu.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Custom CSS -->\r\n");
      out.write("<link href=\"dist/css/sb-admin-2.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Morris Charts CSS -->\r\n");
      out.write("<link href=\"vendor/morrisjs/morris.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Custom Fonts -->\r\n");
      out.write("<link href=\"vendor/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"css/style-sort-table.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery -->\r\n");
      out.write("<script src=\"vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap Core JavaScript -->\r\n");
      out.write("<script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Metis Menu Plugin JavaScript -->\r\n");
      out.write("<script src=\"vendor/metisMenu/metisMenu.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Morris Charts JavaScript -->\r\n");
      out.write("<!--<script src=\"vendor/raphael/raphael.min.js\"></script>\r\n");
      out.write("<script src=\"vendor/morrisjs/morris.min.js\"></script>-->\r\n");
      out.write("<!--<script src=\"../data/morris-data.js\"></script>-->\r\n");
      out.write("\r\n");
      out.write("<!-- Custom Theme JavaScript -->\r\n");
      out.write("<script src=\"dist/js/sb-admin-2.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.validate.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/additional-methods.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/javascript.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"ckeditor/ckeditor.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--Start-Sidebar-->\r\n");
      out.write("    <nav class=\"navbar navbar-default navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n");
      out.write("                <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"index.jsp\">Trang chủ</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.navbar-header -->\r\n");
      out.write("\r\n");
      out.write("        <ul class=\"nav navbar-top-links navbar-right\">\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("                    <i class=\"fa fa-envelope fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\r\n");
      out.write("                </a>\r\n");
      out.write("                <ul class=\"dropdown-menu dropdown-messages\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <strong>John Smith</strong>\r\n");
      out.write("                                <span class=\"pull-right text-muted\">\r\n");
      out.write("                                    <em>Yesterday</em>\r\n");
      out.write("                                </span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <strong>John Smith</strong>\r\n");
      out.write("                                <span class=\"pull-right text-muted\">\r\n");
      out.write("                                    <em>Yesterday</em>\r\n");
      out.write("                                </span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <strong>John Smith</strong>\r\n");
      out.write("                                <span class=\"pull-right text-muted\">\r\n");
      out.write("                                    <em>Yesterday</em>\r\n");
      out.write("                                </span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a class=\"text-center\" href=\"#\">\r\n");
      out.write("                            <strong>Read All Messages</strong>\r\n");
      out.write("                            <i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <!-- /.dropdown-messages -->\r\n");
      out.write("            </li>\r\n");
      out.write("            <!-- /.dropdown -->\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("                    <i class=\"fa fa-tasks fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\r\n");
      out.write("                </a>\r\n");
      out.write("                <ul class=\"dropdown-menu dropdown-tasks\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    <strong>Task 1</strong>\r\n");
      out.write("                                    <span class=\"pull-right text-muted\">40% Complete</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <div class=\"progress progress-striped active\">\r\n");
      out.write("                                    <div class=\"progress-bar progress-bar-success\" role=\"progressbar\" aria-valuenow=\"40\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 40%\">\r\n");
      out.write("                                        <span class=\"sr-only\">40% Complete (success)</span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    <strong>Task 2</strong>\r\n");
      out.write("                                    <span class=\"pull-right text-muted\">20% Complete</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <div class=\"progress progress-striped active\">\r\n");
      out.write("                                    <div class=\"progress-bar progress-bar-info\" role=\"progressbar\" aria-valuenow=\"20\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 20%\">\r\n");
      out.write("                                        <span class=\"sr-only\">20% Complete</span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    <strong>Task 3</strong>\r\n");
      out.write("                                    <span class=\"pull-right text-muted\">60% Complete</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <div class=\"progress progress-striped active\">\r\n");
      out.write("                                    <div class=\"progress-bar progress-bar-warning\" role=\"progressbar\" aria-valuenow=\"60\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 60%\">\r\n");
      out.write("                                        <span class=\"sr-only\">60% Complete (warning)</span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    <strong>Task 4</strong>\r\n");
      out.write("                                    <span class=\"pull-right text-muted\">80% Complete</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <div class=\"progress progress-striped active\">\r\n");
      out.write("                                    <div class=\"progress-bar progress-bar-danger\" role=\"progressbar\" aria-valuenow=\"80\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 80%\">\r\n");
      out.write("                                        <span class=\"sr-only\">80% Complete (danger)</span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a class=\"text-center\" href=\"#\">\r\n");
      out.write("                            <strong>See All Tasks</strong>\r\n");
      out.write("                            <i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <!-- /.dropdown-tasks -->\r\n");
      out.write("            </li>\r\n");
      out.write("            <!-- /.dropdown -->\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("                    <i class=\"fa fa-bell fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\r\n");
      out.write("                </a>\r\n");
      out.write("                <ul class=\"dropdown-menu dropdown-alerts\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <i class=\"fa fa-comment fa-fw\"></i> New Comment\r\n");
      out.write("                                <span class=\"pull-right text-muted small\">4 minutes ago</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <i class=\"fa fa-twitter fa-fw\"></i> 3 New Followers\r\n");
      out.write("                                <span class=\"pull-right text-muted small\">12 minutes ago</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <i class=\"fa fa-envelope fa-fw\"></i> Message Sent\r\n");
      out.write("                                <span class=\"pull-right text-muted small\">4 minutes ago</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <i class=\"fa fa-tasks fa-fw\"></i> New Task\r\n");
      out.write("                                <span class=\"pull-right text-muted small\">4 minutes ago</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <i class=\"fa fa-upload fa-fw\"></i> Server Rebooted\r\n");
      out.write("                                <span class=\"pull-right text-muted small\">4 minutes ago</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a class=\"text-center\" href=\"#\">\r\n");
      out.write("                            <strong>See All Alerts</strong>\r\n");
      out.write("                            <i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <!-- /.dropdown-alerts -->\r\n");
      out.write("            </li>\r\n");
      out.write("            <!-- /.dropdown -->\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("                    <i class=\"fa fa-user fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\r\n");
      out.write("                </a>\r\n");
      out.write("                <ul class=\"dropdown-menu dropdown-user\">\r\n");
      out.write("                    <li><a href=\"#\"><i class=\"fa fa-user fa-fw\"></i> User Profile</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li><a href=\"#\"><i class=\"fa fa-gear fa-fw\"></i> Settings</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li><a href=\"login.html\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <!-- /.dropdown-user -->\r\n");
      out.write("            </li>\r\n");
      out.write("            <!-- /.dropdown -->\r\n");
      out.write("        </ul>\r\n");
      out.write("        <!-- /.navbar-top-links -->\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"navbar-default sidebar\" role=\"navigation\">\r\n");
      out.write("            <div class=\"sidebar-nav navbar-collapse\">\r\n");
      out.write("                <ul class=\"nav\" id=\"side-menu\">\r\n");
      out.write("                    <li class=\"sidebar-search\">\r\n");
      out.write("                        <div class=\"input-group custom-search-form\">\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\r\n");
      out.write("                            <span class=\"input-group-btn\">\r\n");
      out.write("                                <button class=\"btn btn-default\" type=\"button\">\r\n");
      out.write("                                    <i class=\"fa fa-search\"></i>\r\n");
      out.write("                                </button>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- /input-group -->\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-laptop fa-fw\"></i> Quản lý Nhân viên<span class=\"fa arrow\"></span></a>\r\n");
      out.write("                        <ul class=\"nav nav-second-level\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"quanly.jsp\">Quản Lý Nhân Viên</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"baodanh.jsp\">Điểm Danh</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.sidebar-collapse -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.navbar-static-side -->\r\n");
      out.write("    </nav>\r\n");
      out.write("<!--End-Sidebar-->");
      out.write("\r\n");
      out.write("            <!--Ghi nội dung -->\r\n");
      out.write("            <div id=\"page-wrapper\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-12\">\r\n");
      out.write("<!--                        <h1 class=\"page-header\">Quản lý người dùng</h1>-->\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /.col-lg-12 -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("        <section class=\"container-fluid\">\r\n");
      out.write("                        <div class=\"panel panel-default\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"panel-heading\">\r\n");
      out.write("                                <h1 style=\"color: #269abc;text-align: center\"><b>Điểm Danh Nhân Viên</b></h1>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <form action=\"\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label style=\"    \">\r\n");
      out.write("                                        <select name=\"tacvu\" class=\"form-control-static\">\r\n");
      out.write("                                            <option value=\"\">Tác vụ</option>\r\n");
      out.write("                                            <option value=\"xoa\">Điểm danh</option>\r\n");
      out.write("                                        </select>\r\n");
      out.write("                                        <input class=\"btn btn-danger\" type=\"submit\" value=\"Thực hiện\" />\r\n");
      out.write("                                    </label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <!-- Table -->\r\n");
      out.write("                                <script type=\"text/javascript\">\r\n");
      out.write("//                                    function check(source) {\r\n");
      out.write("//                                        checkboxes = document.getElementsByName('iduser');\r\n");
      out.write("//                                        for (var i = 0; i < checkboxes.length; i++) {\r\n");
      out.write("//                                            checkboxes[i].checked = source.checked;\r\n");
      out.write("//                                        }\r\n");
      out.write("//                                    }\r\n");
      out.write("                                </script>\r\n");
      out.write("                                ");

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


                                
      out.write("\r\n");
      out.write("                                <table class=\"table\">\r\n");
      out.write("                                    <thead>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th> <input type=\"checkbox\" onclick=\"check(this)\" />  All</th> \r\n");
      out.write("                                            <th>TT</th>                        \r\n");
      out.write("                                                                    \r\n");
      out.write("\r\n");
      out.write("                                            <th>Họ tên</th>                        \r\n");
      out.write("                                            <th>Ngày sinh</th> \r\n");
      out.write("                                            <th>Giới tính</th> \r\n");
      out.write("                                            \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            <th>Hình đại diện</th>\r\n");
      out.write("                                            \r\n");
      out.write("                                            \r\n");
      out.write("                                        </tr>\r\n");
      out.write("\r\n");
      out.write("                                    </thead>\r\n");
      out.write("                                    <tbody>\r\n");
      out.write("                                        ");
 //                                    for (int i = 0; i < listUser.size(); i++) {
//                                                User user = listUser.get(i);
//                                                int dem =i+1;
//                                                if(pageNumber>1){
//                                                    dem=i+pageSize * (pageNumber -1)+1;
//                                                }
                                        
      out.write("\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th><input type=\"checkbox\" name=\"iduser\" value=\"<>\" /></th>\r\n");
      out.write("                                            <th>1</th>\r\n");
      out.write("                                            <th>Tô văn Tư</th>\r\n");
      out.write("                                            <th>05/02/1997</th>\r\n");
      out.write("                                            <th>Nam</th>\r\n");
      out.write("                                            <th><img src=\"images/tải xuống.jpg\" alt=\"\"width=\"50px\"height=\"50px\"/></th> \r\n");
      out.write("                                    \r\n");
      out.write("                                            \r\n");
      out.write("                                            \r\n");
      out.write("\r\n");
      out.write("                                           \r\n");
      out.write("\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        ");


//                                            }
                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </tbody>\r\n");
      out.write("\r\n");
      out.write("                                </table>\r\n");
      out.write("                            </form>\r\n");
      out.write("\r\n");
      out.write("                            ");

//                                if (pageCount != 1) {
                            
      out.write("\r\n");
      out.write("                            <div class=\"panel-footer\">\r\n");
      out.write("                                <nav aria-label=\"Page navigation\">\r\n");
      out.write("                                    <ul class=\"pagination\">\r\n");
      out.write("                                        \r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </nav>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");

//                                }
                            
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </section>\r\n");
      out.write("                </div>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
