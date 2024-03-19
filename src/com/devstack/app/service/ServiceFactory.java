package com.devstack.app.service;

import com.devstack.app.dao.custom.impl.TaskDaoImpl;
import com.devstack.app.service.impl.TaskServiceImpl;


public class ServiceFactory {
    private ServiceFactory(){}

    public enum ServiceType{
        TASK,USER
    }
    public static  <T> T getService(ServiceType type){
        switch (type){
            case TASK:
                return (T) new TaskServiceImpl();
            default:
                return null;
        }
    }
}
