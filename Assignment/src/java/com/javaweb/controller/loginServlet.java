/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.controller;

import com.javaweb.model.Nhanvien;
import com.javaweb.services.EnDeCryption;
import com.javaweb.services.NhanVienServices;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class loginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String tendn = request.getParameter("tendn");
        String password = request.getParameter("pw");
//        String remem = request.getParameter("remember");

//        boolean remember = "R".equals(remem);
        NhanVienServices nhanvienservice = new NhanVienServices();
//        EnDeCryption mh=new EnDeCryption("asdasdasda");
//        String mk=mh.encoding(password);

        EnDeCryption mh = new EnDeCryption("zxczxsdfsdfgsdjklh");
        String mk = mh.encoding(password);

        boolean login = nhanvienservice.CheckLogin(tendn, mk);
        HttpSession session = request.getSession();
        session.removeAttribute("errormsg");
        if (login) {
            session.removeAttribute("chucvu");
            session.removeAttribute("email");
            session.removeAttribute("hoten");
            session.removeAttribute("idnhanvien");
            session.removeAttribute("hinhanh");

            if (session.getAttribute("email") != null) {
                String em = (String) session.getAttribute("email");
                if (em.equals(tendn)) {
                    response.sendRedirect("eroorsession.jsp");
                }
            }
            Nhanvien nhanvien = nhanvienservice.GetNhanvienByEmailOrtendn(tendn);
            session.setAttribute("email", nhanvien.getEmail());
            session.setAttribute("tendn", nhanvien.getTendn());
            session.setAttribute("chucvu", nhanvien.getChucvu());
            session.setAttribute("hoten", nhanvien.getHoten());
            session.setAttribute("hinhanh", nhanvien.getHinhanh());

            session.setAttribute("tendn", nhanvien.getTendn());

            response.sendRedirect("quanly.jsp");
//            String url = "/index.jsp";
//            getServletContext().getRequestDispatcher(url).forward(request, response);
//            response.sendRedirect(session.getAttribute("urlcur") + "");
        } else {
            session.setAttribute("errormsg", "Tài khoản hoặc mật khẩu sai");
            String url = "/index.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);

//            try (PrintWriter out = response.getWriter()) {
//
//                out.println("<script>\n"
//                        + "$( document ).ready(function() {\n"
//                        + "$(\"#myModal\").modal('show');\n"
//                        + "});\n"
//                        + "</script>");
//
//            }
//            String url = "/quanly.jsp";
//            try (PrintWriter out = response.getWriter()) {
//                /* TODO output your page here. You may use following sample code. */
//                out.println("<!DOCTYPE html>");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title>Servlet loginServlet</title>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println("<h1>Servlet loginServlet at " + request.getContextPath() + "</h1>");
//                out.println("</body>");
//                out.println("</html>");
//            }
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
