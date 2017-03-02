/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.services;

import com.javaweb.hibernate.util.HibernateUtil;
import com.javaweb.model.Luongnv;
import com.javaweb.model.Nhanvien;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class LuongServices {
     public Luongnv getLuongByID(int idluong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            String strQuery = "from Luongnv where idluongnv = " + idluong;
            Query query = session.createQuery(strQuery);
            Luongnv nv = (Luongnv) query.uniqueResult();
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
      public int lcount = 0;
    public ArrayList<Luongnv> getAllLuong(int pageSize, int pageNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList listluong = new ArrayList<Luongnv>();

        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Luongnv order by idluongnv desc");
            lcount = query.list().size();
            query = query.setFirstResult(pageSize * (pageNumber - 1));
            query.setMaxResults(pageSize);
            listluong = (ArrayList) query.list();

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.close();
        }

        return listluong;
    }
     public ArrayList<Luongnv> GetAllluongnv() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Luongnv> listluong = new ArrayList<Luongnv>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Luongnv");
            listluong = (ArrayList) query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return listluong;
    }
     public boolean InsertLuong(Luongnv luong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(luong);
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
     public boolean isChucvuExists(String chucvu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean result = false;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Luongnv where chucvu = '" + chucvu + "'");
            Luongnv pt = (Luongnv) query.uniqueResult();
            tx.commit();
            if (pt != null) {
                result = true;
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return result;
    }
}
