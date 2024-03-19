package com.devstack.app.dao;

import com.devstack.app.dao.custom.impl.TaskDaoImpl;

public class DaoFactory {
    private DaoFactory(){}

    public enum DaoType{
        TASK,USER
    }
    public static  <T> T getDao(DaoType type){
        switch (type){
            case TASK:
                return (T) new TaskDaoImpl();
            default:
                return null;
        }
    }
}
