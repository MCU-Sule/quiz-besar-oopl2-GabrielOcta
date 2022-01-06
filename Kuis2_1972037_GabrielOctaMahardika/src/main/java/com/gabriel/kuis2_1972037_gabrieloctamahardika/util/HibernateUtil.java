package com.gabriel.kuis2_1972037_gabrieloctamahardika.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @Author 1972037 Gabriel Octa Mahardika
 **/
public class HibernateUtil {
    public static Session getSessionFactory(){
        SessionFactory sf;
        sf = new Configuration().configure().buildSessionFactory();
        Session s;
        s = sf.openSession();
        return s;
    }
}
