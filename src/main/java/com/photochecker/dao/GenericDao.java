package com.photochecker.dao;

import java.util.List;

public interface GenericDao<T>  {

    public int save(T t);

    public T find(int id);

    public List<T> findAll();

    public boolean update(T t);

    public void remove(T t);
}
