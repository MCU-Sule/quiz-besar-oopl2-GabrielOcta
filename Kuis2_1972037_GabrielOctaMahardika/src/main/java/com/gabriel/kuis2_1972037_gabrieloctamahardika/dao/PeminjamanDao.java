package com.gabriel.kuis2_1972037_gabrieloctamahardika.dao;

import com.gabriel.kuis2_1972037_gabrieloctamahardika.entity.Peminjaman;
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
public class PeminjamanDao implements DaoService<Peminjaman> {
    @Override
    public ObservableList<Peminjaman> showData() {
        Session session = HibernateUtil.getSessionFactory();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = builder.createQuery(Peminjaman.class);
        criteriaQuery.from(Peminjaman.class);
        List<Peminjaman> peminjamanList = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return FXCollections.observableArrayList(peminjamanList);
    }

    @Override
    public int addData(Peminjaman data) {
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
    public int delData(Peminjaman data) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(data);
            transaction.commit();
            result = 1;
        }catch (HibernateException ex){
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public int updateData(Peminjaman data) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(data);
            transaction.commit();
            result = 1;
        }catch (HibernateException ex){
            transaction.rollback();
        }
        session.close();
        return result;
    }
}
