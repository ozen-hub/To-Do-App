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

import java.util.List;

public class TaskDaoImpl implements TaskDao {
    @Override
    public void create(Task task) {
    }

    @Override
    public void saveTaskWithUser(Task task, String username) {
        try (Session session = HibernateUtil.openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE username=:username", User.class);
            query.setParameter("username", username);
            User user = query.uniqueResult();
            if (user != null) {

                task.setUser(user);
                Transaction transaction = session.beginTransaction();
                session.save(task);
                transaction.commit();

            } else {
                throw new RuntimeException("User Not Found!");
            }
        }
    }

    @Override
    public List<Task> loadAllTasks(String email) {


        try (Session session = HibernateUtil.openSession()) {

            Query<User> query1 = session.createQuery("FROM User WHERE username=:username", User.class);
            query1.setParameter("username", email);
            User user = query1.uniqueResult();

            if (user == null) {
                throw new RuntimeException("User Not Found!");
            }

            Query<Task> query2 = session.createQuery("FROM Task WHERE user_id=:id ORDER BY date ASC", Task.class);
            query2.setParameter("id", user.getId());
            return query2.list();
        }
    }

    @Override
    public void deleteTaskById(Long id) {
        try (Session session = HibernateUtil.openSession()) {
            Task task = session.find(Task.class, id);
            if (task==null){
                throw new RuntimeException("Not Found!");
            }

            Transaction transaction = session.beginTransaction();
            session.delete(task);
            transaction.commit();
        }
    }


}
