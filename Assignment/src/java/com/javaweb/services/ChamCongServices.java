package com.javaweb.services;

import com.javaweb.hibernate.util.HibernateUtil;
import com.javaweb.model.Chamcong;
import com.javaweb.model.Diemdanh;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class ChamCongServices {

    //Hàm insert dữ liệu
    public boolean ThemChamCong(Chamcong chc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(chc);
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

    //Lấy dữ liệu
    public ArrayList<Chamcong> LayTheoThang(String thang) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Chamcong> list = new ArrayList<Chamcong>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Chamcong where date_format(thanglam, '%Y-%m') = '" + thang + "'");
            list = (ArrayList) query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return list;
    }

    //Lấy giá trị năm trong bảng điểm danh
    public ArrayList<Diemdanh> LayGiaTriNam() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Diemdanh> listDD = new ArrayList<Diemdanh>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Diemdanh group by date_format(thoigian, '%Y') order by thoigian desc");
            listDD = (ArrayList) query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return listDD;
    }
    
    //Lấy giá trị tháng theo năm truyền vô
    public ArrayList<Diemdanh> LayGiaTriThangTheoNam(String nam) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Diemdanh> listDD = new ArrayList<Diemdanh>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Diemdanh where date_format(thoigian, '%Y') = '"+nam+"' group by date_format(thoigian, '%m')");
            listDD = (ArrayList) query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return listDD;
    }
}
