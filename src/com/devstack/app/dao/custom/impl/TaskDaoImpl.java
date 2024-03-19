package com.devstack.app.dao.custom.impl;

import com.devstack.app.dao.custom.TaskDao;
import com.devstack.app.db.HibernateUtil;
import com.devstack.app.dto.TaskDto;
import com.devstack.app.model.Task;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TaskDaoImpl implements TaskDao {
    @Override
    public void create(Task task) {
        try(Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(task);
            transaction.commit();
        }
    }
}
