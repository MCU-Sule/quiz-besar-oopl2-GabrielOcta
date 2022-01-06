module com.gabriel.kuis2_1972037_gabrieloctamahardika {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.sql;
    requires java.naming;

    opens com.gabriel.kuis2_1972037_gabrieloctamahardika to javafx.fxml;
    exports com.gabriel.kuis2_1972037_gabrieloctamahardika;
    exports com.gabriel.kuis2_1972037_gabrieloctamahardika.entity;
}