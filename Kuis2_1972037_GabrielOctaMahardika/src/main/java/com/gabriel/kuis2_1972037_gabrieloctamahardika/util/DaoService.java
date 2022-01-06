package com.gabriel.kuis2_1972037_gabrieloctamahardika.util;

import javafx.collections.ObservableList;

import java.util.List;

/**
 * @Author 1972037 Gabriel Octa Mahardika
 **/
public interface DaoService<T> {
    public ObservableList<T> showData();
    public int addData(T data);
    public int delData (T data);
    public int updateData (T data);
}
