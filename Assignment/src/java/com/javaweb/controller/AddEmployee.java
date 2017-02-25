package com.javaweb.controller;

import com.javaweb.model.Nhanvien;
import com.javaweb.services.FileServices;
import com.javaweb.services.NhanVienServices;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author admin
 */
public class AddEmployee extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private File file;
    private String filePath;
    private int maxFileSize = 10000 * 1024;
    private int maxMemSize = 10000 * 1024;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        

        NhanVienServices nvs = new NhanVienServices();
        Nhanvien nv = null;

        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
        if (isMultiPart) {

            try {
                //File Upload
                String folderUpload = getServletContext().getInitParameter("file-upload");
                String rootPath = getServletContext().getRealPath("/");
                
                String directory = rootPath.substring(0, rootPath.indexOf("build"));
                
                filePath = directory+"web\\" + folderUpload;
                response.setContentType("text/html;charset=UTF-8");
                java.io.PrintWriter out = response.getWriter();

                DiskFileItemFactory factory = new DiskFileItemFactory();

                //maximum size that will be stored in memory
                factory.setSizeThreshold(maxMemSize);
                //Location to save data that is larger than maxMemSize.
                factory.setRepository(new File("D:\\TAM"));

                //create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                //maximun file size to be uploaded.
                upload.setSizeMax(maxMemSize);

                String hoTen = "", strNgaySinh = "", sdt = "", diaChi = "", email = "", valGioiTinh = "",
                strNgayVaoLam = "", cmnd = "", strNgayCap = "", noiCap = "", tenFile = "", ghiChu = "", hinhAnh = "unknown.jpg";
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                boolean gioiTinh = false;
        
                Date ngaySinh = new Date();
                Date ngayVaoLam = new Date();
                Date ngayCap = new Date();

                //Parse the request to get file items.
                List fileItems = upload.parseRequest(request);

                //Process the uploaded file items
                Iterator itr = fileItems.iterator();

                while (itr.hasNext()) {
                    FileItem fi = (FileItem) itr.next();
                    if (fi.isFormField()) 
                    {
                        //do field specific process
                        String fieldName = fi.getFieldName();
                        if (fieldName.equals("fullname")) 
                        {
                            hoTen = fi.getString("UTF-8");
                        } else if (fieldName.equals("birthday")) 
                        {
                            strNgaySinh = fi.getString("UTF-8");
                        } else if (fieldName.equals("dienthoai")) 
                        {
                            sdt = fi.getString("UTF-8");
                        } else if (fieldName.equals("address")) 
                        {
                            diaChi = fi.getString("UTF-8");
                        } else if (fieldName.equals("email")) 
                        {
                            email = fi.getString("UTF-8");
                        } else if (fieldName.equals("gender")) 
                        {
                            valGioiTinh = fi.getString("UTF-8");
                        } else if (fieldName.equals("ngayVaoLam")) 
                        {
                            strNgayVaoLam = fi.getString("UTF-8");
                        } else if (fieldName.equals("cmnd")) 
                        {
                            cmnd = fi.getString("UTF-8");
                        } else if (fieldName.equals("ngayCap")) 
                        {
                            strNgayCap = fi.getString("UTF-8");
                        } else if (fieldName.equals("noiCap")) 
                        {
                            noiCap = fi.getString("UTF-8");
                        } else if (fieldName.equals("ghiChu")) 
                        {
                            ghiChu = fi.getString("UTF-8");
                        } 
//                        out.println(fi.getString("UTF-8")+ " "+fieldName);
//                        response.getWriter().println("<h2> sadsasadsad" + fi.getString("UTF-8") + " " + fieldName + "</h2>");
//                        response.getWriter().println("<h3>" + hoTen + " "+ ghiChu+ " "+" "+gioiTinh + " " + strNgaySinh + filePath + "</h3>");
//                        response.getWriter().println("<h2>" + item.getFieldName() + " item.getname " + item.getName() + " item " + item + "</h2>");
                    } else {
//                        response.getWriter().println("<h2> else else" + fi.getString("UTF-8") + " " + fi.getFieldName() + "</h2>");
                        //do file upload specific process
                        tenFile = fi.getName();
                        String contentType = fi.getContentType();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();

                        if (!tenFile.equals("")) 
                        {
                            //change file name
                            tenFile = FileServices.DoiTenFile(tenFile);
                            //Write the file
                            if (tenFile.lastIndexOf("\\") >= 0) {
                                file = new File(filePath + tenFile.substring(tenFile.lastIndexOf("\\")));
                            } else {
                                file = new File(filePath + "/" + tenFile.substring(tenFile.lastIndexOf("\\") + 1));
                            }
                            fi.write(file);
                        }

                        //call a method to upload file.
                        if (fi.getFieldName().equals("hinhAnh")) 
                        {
                            if (!fi.getName().equals("")) 
                            {
                                hinhAnh = tenFile;
                            }
                        }
                    }
                }

                try {
                    ngaySinh = sdf.parse(strNgaySinh);
                    ngayVaoLam = sdf.parse(strNgayVaoLam);
                    ngayCap = sdf.parse(strNgayCap);
                } catch (ParseException ex) {
                    Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
                
//                ngaySinh = (Date)strNgaySinh;

                if (valGioiTinh.equals("Nam")) {
                    gioiTinh = true;
                }
                nv = new Nhanvien(hoTen, ngaySinh, sdt, diaChi, 1, gioiTinh, ngayVaoLam, cmnd, ngayCap, "tendn", "mk", email, "0", ghiChu, hinhAnh, noiCap);

                nvs.ThemNhanVien(nv);

                response.sendRedirect("quanly.jsp");
                
            } catch (Exception fue) {
                System.out.println(fue.toString());
            }
        }

//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AddEmployee</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AddEmployee at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
