package com.gabriel.kuis2_1972037_gabrieloctamahardika.dao;

import com.gabriel.kuis2_1972037_gabrieloctamahardika.entity.Buku;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.util.DaoService;
import com.gabriel.kuis2_1972037_gabrieloctamahardika.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @Author 1972037 Gabriel Octa Mahardika
 **/
public class BukuDao implements DaoService<Buku> {

    @Override
    public ObservableList<Buku> showData() {
        Session session = HibernateUtil.getSessionFactory();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = builder.createQuery(Buku.class);
        criteriaQuery.from(Buku.class);
        List<Buku> bukus = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return FXCollections.observableArrayList(bukus);
    }

    @Override
    public int addData(Buku data) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(data);
            transaction.commit();
            result = 1;
        }catch (HibernateException ex){
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public int delData(Buku data) {
        return 0;
    }

    @Override
    public int updateData(Buku data) {
        return 0;
    }
}
