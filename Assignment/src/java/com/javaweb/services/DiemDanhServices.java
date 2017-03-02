/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.services;

import com.javaweb.hibernate.util.HibernateUtil;
import com.javaweb.model.Diemdanh;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class DiemDanhServices {

    //Thêm dữ liệu
    public boolean InsertRecord(Diemdanh dd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(dd);
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

    public int ddcount = 0;

    public ArrayList<Diemdanh> LayTheoNgayHomNay(String today, int pageSize, int pageNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Diemdanh> lst = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Diemdanh where date_format(thoigian, '%Y-%m-%d') = '" + today + "'");
            ddcount = query.list().size();
            query = query.setFirstResult(pageSize * (pageNumber - 1));
            query.setMaxResults(pageSize);
            lst = (ArrayList<Diemdanh>) query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.clear();
        }
        return lst;
    }

    public Diemdanh LayTheoIdNV(String idNV, String today) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Diemdanh dd = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Diemdanh where nhanvien = '" + idNV + "' and date_format(thoigian, '%Y-%m-%d') ='"+today+"'");
            dd = (Diemdanh) query.uniqueResult();
            tx.commit();
            return dd;
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
}
