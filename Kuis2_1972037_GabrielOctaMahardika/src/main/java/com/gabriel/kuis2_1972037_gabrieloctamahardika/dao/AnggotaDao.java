package com.gabriel.kuis2_1972037_gabrieloctamahardika.dao;

import com.gabriel.kuis2_1972037_gabrieloctamahardika.entity.Anggota;
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
public class AnggotaDao implements DaoService<Anggota> {
    @Override
    public ObservableList<Anggota> showData() {
        Session session = HibernateUtil.getSessionFactory();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = builder.createQuery(Anggota.class);
        criteriaQuery.from(Anggota.class);
        List<Anggota> anggotas = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return FXCollections.observableArrayList(anggotas);
    }

    @Override
    public int addData(Anggota data) {
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
    public int delData(Anggota data) {
        return 0;
    }

    @Override
    public int updateData(Anggota data) {
        return 0;
    }
}
