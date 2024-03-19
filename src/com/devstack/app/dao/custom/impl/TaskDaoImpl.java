package com.devstack.app.dao.custom.impl;

import com.devstack.app.PasswordUtil;
import com.devstack.app.dao.custom.TaskDao;
import com.devstack.app.db.HibernateUtil;
import com.devstack.app.dto.TaskDto;
import com.devstack.app.model.Task;
import com.devstack.app.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TaskDaoImpl implements TaskDao {
    @Override
    public void create(Task task) {}

    @Override
    public void saveTaskWithUser(Task task, String username) {
        try(Session session= HibernateUtil.openSession()){
            Query<User> query = session.createQuery("FROM User WHERE username=:username", User.class);
            query.setParameter("username",username);
            User user = query.uniqueResult();
            if (user!=null){

                task.setUser(user);
                Transaction transaction = session.beginTransaction();
                session.save(task);
                transaction.commit();

            }else{
                throw new RuntimeException("User Not Found!");
            }
        }
    }
}
