package com.javaweb.services;

import com.javaweb.hibernate.util.HibernateUtil;
import com.javaweb.model.Nhanvien;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class NhanVienServices {
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
    public boolean Insernv(Nhanvien nv) {
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
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return false;
    }
    public ArrayList<Nhanvien> GetAllNV() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Nhanvien> listNV = new ArrayList<Nhanvien>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from nhanvien");
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
}
