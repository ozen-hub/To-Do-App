package com.devstack.app.service.impl;

import com.devstack.app.dao.DaoFactory;
import com.devstack.app.dao.custom.TaskDao;
import com.devstack.app.dto.TaskDto;
import com.devstack.app.model.Task;
import com.devstack.app.service.TaskService;

public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao = DaoFactory.getDao(DaoFactory.DaoType.TASK);

    @Override
    public void createTaskWithUser(TaskDto dto, String username) {
        Task task = new Task();
        task.setTaskName(dto.getTaskName());
        task.setDate(dto.getDate());
        task.setStatus(false);
        taskDao.saveTaskWithUser(task,username);
    }
}
