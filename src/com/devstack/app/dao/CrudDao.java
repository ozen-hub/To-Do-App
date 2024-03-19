package com.devstack.app.dao;

public interface CrudDao<T,ID> {
    public void create(T t);
}
