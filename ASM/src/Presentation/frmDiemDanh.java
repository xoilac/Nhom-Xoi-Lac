/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import BLL.ComboBoxBLL;
import BLL.NhanVienBLL;
import BLL.QuyenNhanVienBLL;
import static BLL.ThongBao_ChuyenDoi.*;
import java.sql.ResultSet;

/**
 *
 * @author MinhNguyen
 */
public class frmDiemDanh extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyNguoiDung
     */
    public frmDiemDanh() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNhanVien = new javax.swing.JPanel();
        pnlDanhSachNV = new javax.swing.JPanel();
        lblTimKiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoaiSanPham = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuHome = new javax.swing.JMenu();
        mnuiTrangChu = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuiExit = new javax.swing.JMenuItem();
        mnuQuanly = new javax.swing.JMenu();
        mnuSanPham = new javax.swing.JMenu();
        mnuiLoaiSanPham = new javax.swing.JMenuItem();
        mnuiNhaCungCap = new javax.swing.JMenuItem();
        mnuiSanPham = new javax.swing.JMenuItem();
        mnuHoaDon = new javax.swing.JMenu();
        mnuiQLHDNhap = new javax.swing.JMenuItem();
        mnuiQLHDXuat = new javax.swing.JMenuItem();
        mnuiCTHD = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuKhachHang = new javax.swing.JMenuItem();
        mnuNhanVien = new javax.swing.JMenuItem();
        mnuQLTaiKhoan = new javax.swing.JMenuItem();
        mnuHoadon = new javax.swing.JMenu();
        mnuTaoHoaDon = new javax.swing.JMenu();
        mnuiHDNhap = new javax.swing.JMenuItem();
        mnuiHDXuat = new javax.swing.JMenuItem();
        mnuThongKe = new javax.swing.JMenu();
        mnuTKHoaDon = new javax.swing.JMenuItem();
        mnuTKNhanVien = new javax.swing.JMenuItem();
        mnuTaiKhoan = new javax.swing.JMenu();
        mnuiDangKy = new javax.swing.JMenuItem();
        mnuiDoiMK = new javax.swing.JMenuItem();
        mnuAbout = new javax.swing.JMenu();
        mnuiBanQuyen = new javax.swing.JMenuItem();
        mnuDangXuat = new javax.swing.JMenu();
        mnuTime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BH - Quản lý tài khoản");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlNhanVien.setBackground(new java.awt.Color(170, 234, 240));
        pnlNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true), "Điểm danh", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(255, 0, 0))); // NOI18N

        pnlDanhSachNV.setBackground(new java.awt.Color(170, 234, 240));
        pnlDanhSachNV.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 1, true), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14), new java.awt.Color(51, 102, 255))); // NOI18N

        lblTimKiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTimKiem.setText("Tìm kiếm :");

        txtTimKiem.setToolTipText("Nhập tên hoặc ghi chú");
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(500, 500));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 300));

        tblLoaiSanPham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblLoaiSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblLoaiSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Tên nhân viên", "Giới Tính", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiSanPham.setMaximumSize(new java.awt.Dimension(2147483647, 400));
        tblLoaiSanPham.setMinimumSize(new java.awt.Dimension(500, 160));
        tblLoaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLoaiSanPham);

        jScrollPane3.setViewportView(jScrollPane1);

        jButton1.setText("Điểm danh");

        javax.swing.GroupLayout pnlDanhSachNVLayout = new javax.swing.GroupLayout(pnlDanhSachNV);
        pnlDanhSachNV.setLayout(pnlDanhSachNVLayout);
        pnlDanhSachNVLayout.setHorizontalGroup(
            pnlDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSachNVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                    .addGroup(pnlDanhSachNVLayout.createSequentialGroup()
                        .addComponent(lblTimKiem)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        pnlDanhSachNVLayout.setVerticalGroup(
            pnlDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachNVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDanhSachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDanhSachNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addComponent(pnlDanhSachNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mnuHome.setText("Home");

        mnuiTrangChu.setText("Trang chủ");
        mnuiTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiTrangChuActionPerformed(evt);
            }
        });
        mnuHome.add(mnuiTrangChu);
        mnuHome.add(jSeparator4);

        mnuiExit.setText("Thoát");
        mnuiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiExitActionPerformed(evt);
            }
        });
        mnuHome.add(mnuiExit);

        jMenuBar1.add(mnuHome);

        mnuQuanly.setText("Quản lý");

        mnuSanPham.setText("Sản phẩm");

        mnuiLoaiSanPham.setText("Loại sản phẩm");
        mnuiLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiLoaiSanPhamActionPerformed(evt);
            }
        });
        mnuSanPham.add(mnuiLoaiSanPham);

        mnuiNhaCungCap.setText("Nhà cung cấp");
        mnuiNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiNhaCungCapActionPerformed(evt);
            }
        });
        mnuSanPham.add(mnuiNhaCungCap);

        mnuiSanPham.setText("Các sản phẩm");
        mnuiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiSanPhamActionPerformed(evt);
            }
        });
        mnuSanPham.add(mnuiSanPham);

        mnuQuanly.add(mnuSanPham);

        mnuHoaDon.setText("Hóa đơn");

        mnuiQLHDNhap.setText("Hóa đơn nhập");
        mnuHoaDon.add(mnuiQLHDNhap);

        mnuiQLHDXuat.setText("Hóa đơn xuất");
        mnuiQLHDXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiQLHDXuatActionPerformed(evt);
            }
        });
        mnuHoaDon.add(mnuiQLHDXuat);

        mnuiCTHD.setText("Chi tiết hóa đơn");
        mnuiCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiCTHDActionPerformed(evt);
            }
        });
        mnuHoaDon.add(mnuiCTHD);

        mnuQuanly.add(mnuHoaDon);
        mnuQuanly.add(jSeparator2);

        mnuKhachHang.setText("Khách hàng");
        mnuKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuKhachHangActionPerformed(evt);
            }
        });
        mnuQuanly.add(mnuKhachHang);

        mnuNhanVien.setText("Nhân viên");
        mnuNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNhanVienActionPerformed(evt);
            }
        });
        mnuQuanly.add(mnuNhanVien);

        mnuQLTaiKhoan.setText("Tài khoản người dùng");
        mnuQLTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuQLTaiKhoanActionPerformed(evt);
            }
        });
        mnuQuanly.add(mnuQLTaiKhoan);

        jMenuBar1.add(mnuQuanly);

        mnuHoadon.setText("Hóa đơn");

        mnuTaoHoaDon.setText("Tạo hóa đơn");

        mnuiHDNhap.setText("Hóa đơn nhập");
        mnuiHDNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiHDNhapActionPerformed(evt);
            }
        });
        mnuTaoHoaDon.add(mnuiHDNhap);

        mnuiHDXuat.setText("Hóa đơn xuất");
        mnuiHDXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiHDXuatActionPerformed(evt);
            }
        });
        mnuTaoHoaDon.add(mnuiHDXuat);

        mnuHoadon.add(mnuTaoHoaDon);

        jMenuBar1.add(mnuHoadon);

        mnuThongKe.setText("Thống kê");

        mnuTKHoaDon.setText("Hóa đơn");
        mnuTKHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTKHoaDonActionPerformed(evt);
            }
        });
        mnuThongKe.add(mnuTKHoaDon);

        mnuTKNhanVien.setText("Nhân viên");
        mnuThongKe.add(mnuTKNhanVien);

        jMenuBar1.add(mnuThongKe);

        mnuTaiKhoan.setText("Tài khoản");

        mnuiDangKy.setText("Đăng ký");
        mnuiDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiDangKyActionPerformed(evt);
            }
        });
        mnuTaiKhoan.add(mnuiDangKy);

        mnuiDoiMK.setText("Đổi mật khẩu");
        mnuiDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiDoiMKActionPerformed(evt);
            }
        });
        mnuTaiKhoan.add(mnuiDoiMK);

        jMenuBar1.add(mnuTaiKhoan);

        mnuAbout.setText("Thông tin");

        mnuiBanQuyen.setText("Bản quyền");
        mnuiBanQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiBanQuyenActionPerformed(evt);
            }
        });
        mnuAbout.add(mnuiBanQuyen);

        jMenuBar1.add(mnuAbout);

        mnuDangXuat.setText("Đăng xuất");
        mnuDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnuDangXuatMousePressed(evt);
            }
        });
        jMenuBar1.add(mnuDangXuat);

        mnuTime.setBackground(new java.awt.Color(255, 0, 0));
        jMenuBar1.add(mnuTime);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 318, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        DongHo(mnuTime);

        ResultSet rsNguoiDung = NhanVienBLL.LayThongTinNhanVien();
        ComboBoxBLL.LoadDuLieuCombobox(rsNguoiDung, cbbNguoiDung, "TenNhanVien", "IDNhanVien");

        ResultSet rsQuyenNV = QuyenNhanVienBLL.LayThongTinQuyen();
        ComboBoxBLL.LoadDuLieuCombobox(rsQuyenNV, cbbQuyenNV, "TenQuyen", "MaQuyen");

        //Tạo biến ResultSet và thực hiện gán dữ liệu được lấy từ BLL qua hàm LayThongTinNhanVien()
        ResultSet rs = NhanVienBLL.LayThongTinNhanVien();
        //Gọi hàm đổ dữ liệu vào table THẬT từ BLL
        NhanVienBLL.DoDuLieuVaoQLTaiKhoan(rs, tblLoaiSanPham);
    }//GEN-LAST:event_formWindowOpened

    private void mnuiTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiTrangChuActionPerformed
        frmTrangChinh tc = new frmTrangChinh();
        tc.show();
        this.dispose();
    }//GEN-LAST:event_mnuiTrangChuActionPerformed

    private void mnuiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiExitActionPerformed
        CauHoiThoat();
    }//GEN-LAST:event_mnuiExitActionPerformed

    private void mnuiLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiLoaiSanPhamActionPerformed
        frmLoaiSanPham lsp = new frmLoaiSanPham();
        lsp.show();
        this.dispose();
    }//GEN-LAST:event_mnuiLoaiSanPhamActionPerformed

    private void mnuiNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiNhaCungCapActionPerformed
        frmNhaCungCap ncc = new frmNhaCungCap();
        ncc.show();
        this.dispose();
    }//GEN-LAST:event_mnuiNhaCungCapActionPerformed

    private void mnuiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiSanPhamActionPerformed
        frmSanPham sp = new frmSanPham();
        sp.show();
        this.dispose();
    }//GEN-LAST:event_mnuiSanPhamActionPerformed

    private void mnuiQLHDXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiQLHDXuatActionPerformed
        frmHoaDon hd = new frmHoaDon();
        hd.show();
        this.dispose();
    }//GEN-LAST:event_mnuiQLHDXuatActionPerformed

    private void mnuiCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiCTHDActionPerformed
        frmChiTietHoaDon cthd = new frmChiTietHoaDon();
        cthd.show();
        this.dispose();
    }//GEN-LAST:event_mnuiCTHDActionPerformed

    private void mnuKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuKhachHangActionPerformed
        frmKhachHang kh = new frmKhachHang();
        kh.show();
        this.dispose();
    }//GEN-LAST:event_mnuKhachHangActionPerformed

    private void mnuNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNhanVienActionPerformed
        frmNhanVien nv = new frmNhanVien();
        nv.show();
        this.dispose();
    }//GEN-LAST:event_mnuNhanVienActionPerformed

    private void mnuQLTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuQLTaiKhoanActionPerformed
        frmDiemDanh qlnd = new frmDiemDanh();
        qlnd.show();
        this.dispose();
    }//GEN-LAST:event_mnuQLTaiKhoanActionPerformed

    private void mnuiHDNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiHDNhapActionPerformed
        frmPhieuNhap pn = new frmPhieuNhap();
        pn.show();
        this.dispose();
    }//GEN-LAST:event_mnuiHDNhapActionPerformed

    private void mnuiHDXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiHDXuatActionPerformed
        frmTaoHoaDon thd = new frmTaoHoaDon();
        thd.show();
        this.dispose();
    }//GEN-LAST:event_mnuiHDXuatActionPerformed

    private void mnuTKHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTKHoaDonActionPerformed
        frmBangThongKe btk = new frmBangThongKe();
        btk.show();
        this.dispose();
    }//GEN-LAST:event_mnuTKHoaDonActionPerformed

    private void mnuiDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiDangKyActionPerformed
        frmDangKy dk = new frmDangKy();
        dk.show();
    }//GEN-LAST:event_mnuiDangKyActionPerformed

    private void mnuiDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiDoiMKActionPerformed
        frmDoiMatKhau dmk = new frmDoiMatKhau();
        dmk.show();
    }//GEN-LAST:event_mnuiDoiMKActionPerformed

    private void mnuiBanQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiBanQuyenActionPerformed
        frmBanQuyen bq = new frmBanQuyen();
        bq.show();
    }//GEN-LAST:event_mnuiBanQuyenActionPerformed

    private void mnuDangXuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuDangXuatMousePressed
        frmDangNhap dn = new frmDangNhap();
        dn.show();
        this.dispose();
    }//GEN-LAST:event_mnuDangXuatMousePressed

    private void tblLoaiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiSanPhamMouseClicked
        /*
        Tạo biến index là vị trí dòng được chọn kiểu Integer
        Mục đích: lưu vị trí dòng đầu tiên được chọn trong table
        */
        int index = tblLoaiSanPham.getSelectedRow();
        //Gán các textfield trong form là các giá trị của dòng được chọn với vị trí index
        txtMaND.setText(tblLoaiSanPham.getValueAt(index, 1).toString());

        String NguoiDung = tblLoaiSanPham.getValueAt(index, 2).toString();
        ComboBoxBLL.setSelectedCombobox(cbbNguoiDung, NguoiDung);
        txtTenDN.setText(tblLoaiSanPham.getValueAt(index, 3).toString());
        txtMatKhau.setText(tblLoaiSanPham.getValueAt(index, 4).toString());
        String quyenNV = tblLoaiSanPham.getValueAt(index, 5).toString();
        ComboBoxBLL.setSelectedCombobox(cbbQuyenNV, quyenNV);
    }//GEN-LAST:event_tblLoaiSanPhamMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        //Gán biến từ khóa tìm kiếm từ form
        String tuKhoa = txtTimKiem.getText().trim();

        //Gọi hàm tìm kiếm sau đó đổ vào bảng @tblLoaiSanPham
        ResultSet rsTimKiem = NhanVienBLL.TimKiemNhanVien(tuKhoa);
        NhanVienBLL.DoDuLieuVaoQLTaiKhoan(rsTimKiem, tblLoaiSanPham);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDiemDanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDiemDanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDiemDanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDiemDanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDiemDanh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JMenu mnuAbout;
    private javax.swing.JMenu mnuDangXuat;
    private javax.swing.JMenu mnuHoaDon;
    private javax.swing.JMenu mnuHoadon;
    private javax.swing.JMenu mnuHome;
    private javax.swing.JMenuItem mnuKhachHang;
    private javax.swing.JMenuItem mnuNhanVien;
    private javax.swing.JMenuItem mnuQLTaiKhoan;
    private javax.swing.JMenu mnuQuanly;
    private javax.swing.JMenu mnuSanPham;
    private javax.swing.JMenuItem mnuTKHoaDon;
    private javax.swing.JMenuItem mnuTKNhanVien;
    private javax.swing.JMenu mnuTaiKhoan;
    private javax.swing.JMenu mnuTaoHoaDon;
    private javax.swing.JMenu mnuThongKe;
    private javax.swing.JMenu mnuTime;
    private javax.swing.JMenuItem mnuiBanQuyen;
    private javax.swing.JMenuItem mnuiCTHD;
    private javax.swing.JMenuItem mnuiDangKy;
    private javax.swing.JMenuItem mnuiDoiMK;
    private javax.swing.JMenuItem mnuiExit;
    private javax.swing.JMenuItem mnuiHDNhap;
    private javax.swing.JMenuItem mnuiHDXuat;
    private javax.swing.JMenuItem mnuiLoaiSanPham;
    private javax.swing.JMenuItem mnuiNhaCungCap;
    private javax.swing.JMenuItem mnuiQLHDNhap;
    private javax.swing.JMenuItem mnuiQLHDXuat;
    private javax.swing.JMenuItem mnuiSanPham;
    private javax.swing.JMenuItem mnuiTrangChu;
    private javax.swing.JPanel pnlDanhSachNV;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JTable tblLoaiSanPham;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
