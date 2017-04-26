package pk.edu.nust.seecs.gradebook.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pk.edu.nust.seecs.gradebook.entity.CLO;
import pk.edu.nust.seecs.gradebook.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for CLO Entity.
 * <p>
 * Wrapper Class for CRUD operations on CLO.
 */
public class CloDao {

    public void addClo(CLO CLO) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(CLO);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
    }

    public void deleteClo(int cloid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            CLO CLO = (CLO) session.load(CLO.class, new Integer(cloid));
            session.delete(CLO);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updateClo(CLO CLO) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(CLO);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
    }

    public List<CLO> getAllClos() {
        List<CLO> CLOS = new ArrayList<CLO>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            CLOS = session.createQuery("from CLO").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
        return CLOS;
    }

    public CLO getCloById(int cloid) {
        CLO CLO = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from CLO where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", cloid);
            CLO = (CLO) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
        return CLO;
    }
}