/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.services;

import com.javaweb.hibernate.util.HibernateUtil;
import com.javaweb.model.Chucvu;
import com.javaweb.model.Luongnv;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class ChucVuServices {
    public Chucvu getChucvuByID(int idchucvu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            String strQuery = "from Chucvu where idchucvu = " + idchucvu;
            Query query = session.createQuery(strQuery);
            Chucvu cv = (Chucvu) query.uniqueResult();
            tx.commit();
            return cv;
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
    public ArrayList<Chucvu> getAllchucvuoder(int pageSize, int pageNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList listchuvu = new ArrayList<Chucvu>();

        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Chucvu");
            lcount = query.list().size();
            query = query.setFirstResult(pageSize * (pageNumber - 1));
            query.setMaxResults(pageSize);
            listchuvu = (ArrayList) query.list();

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.close();
        }

        return listchuvu;
    }
     public ArrayList<Chucvu> GetAllChucvu() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Chucvu> listchucvu = new ArrayList<Chucvu>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Chucvu");
            listchucvu = (ArrayList) query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return listchucvu;
    }
     public boolean InsertChucvu(Chucvu chucvu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(chucvu);
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
}
