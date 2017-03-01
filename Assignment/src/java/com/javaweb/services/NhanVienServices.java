package com.javaweb.services;

import com.javaweb.hibernate.util.HibernateUtil;
import com.javaweb.model.Luongnv;
import com.javaweb.model.Nhanvien;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *s
 * @author admin
 */
public class NhanVienServices {
     //Hàm kiểm tra đăng nhập
    public boolean CheckLogin(String giaTri, String password) {
        Nhanvien nhanvien = GetNhanvienByEmailOrtendn(giaTri);
        if (nhanvien != null) {
            if (nhanvien.getMatkhau().equals(password)) {
                return true;
            } else {
                return false;
            }

        } else {

            return false;
        }
    }
    //Hàm thêm dữ liệu
    public boolean ThemNhanVien(Nhanvien nv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(nv);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return false;
    }
    public Nhanvien getNVByID(String IDnv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            String strQuery = "from Nhanvien where idnhanvien = " + IDnv;
            Query query = session.createQuery(strQuery);
            Nhanvien nv = (Nhanvien) query.uniqueResult();
            tx.commit();
            return nv;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return null;
    }
    public ArrayList<Nhanvien> GetAllNV() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Nhanvien> listNV = new ArrayList<Nhanvien>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Nhanvien");
            listNV = (ArrayList) query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return listNV;
    }
    
    public int nvcount = 0;
    public ArrayList<Nhanvien> getAllNv(int pageSize, int pageNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList listNV = new ArrayList<Nhanvien>();

        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Nhanvien order by idnhanvien desc");
            nvcount = query.list().size();
            query = query.setFirstResult(pageSize * (pageNumber - 1));
            query.setMaxResults(pageSize);
            listNV = (ArrayList) query.list();

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.close();
        }

        return listNV;
    }
    //Hàm lấy thông tin bằng email hoặc tên đn
    public Nhanvien GetNhanvienByEmailOrtendn(String gt) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Nhanvien nhanvien = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            String strQuery = "from Nhanvien where email= '" + gt + "' or tendn= '" + gt + "'";
            Query query = session.createQuery(strQuery);
            nhanvien = (Nhanvien) query.uniqueResult();
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return nhanvien;
    }
    
}
