package com.devstack.app.dao.custom;

import com.devstack.app.dao.CrudDao;
import com.devstack.app.model.Task;

public interface TaskDao extends CrudDao<Task,Long> {
    public void saveTaskWithUser(Task task, String username);
}
