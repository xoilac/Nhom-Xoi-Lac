/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.services;

import com.javaweb.hibernate.util.HibernateUtil;
import com.javaweb.model.Calamviec;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class CaLamViecServices {
    public Calamviec getCalamviecByID(String idcalamviec) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            String strQuery = "from Calamviec where idcalamviec = " + idcalamviec;
            Query query = session.createQuery(strQuery);
            Calamviec cv = (Calamviec) query.uniqueResult();
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
    public ArrayList<Calamviec> getAllcalamviecoder(int pageSize, int pageNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList listcalamviec= new ArrayList<Calamviec>();

        try {
            tx = session.getTransaction();
            tx.begin();

            Query query = session.createQuery("from Calamviec");
            lcount = query.list().size();
            query = query.setFirstResult(pageSize * (pageNumber - 1));
            query.setMaxResults(pageSize);
            listcalamviec = (ArrayList) query.list();

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.close();
        }

        return listcalamviec;
    }
     public ArrayList<Calamviec> GetAllCalamviec() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Calamviec> listcalamviec = new ArrayList<Calamviec>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Calamviec");
            listcalamviec = (ArrayList) query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return listcalamviec;
    }
     public boolean InsertCalamviec(Calamviec calamviec) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(calamviec);
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
     public boolean DeleteCalamviec(Calamviec calamviec) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.delete(calamviec);
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
     public boolean isCalamviecExists(String tenca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean result = false;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Calamviec where tenca = '" + tenca + "'");
            Calamviec pt = (Calamviec) query.uniqueResult();
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
