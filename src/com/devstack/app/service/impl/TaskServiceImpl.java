package com.devstack.app.service.impl;

import com.devstack.app.dao.DaoFactory;
import com.devstack.app.dao.custom.TaskDao;
import com.devstack.app.dto.TaskDto;
import com.devstack.app.model.Task;
import com.devstack.app.service.TaskService;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<TaskDto> loadAllTasks(String email) {
        List<Task> list = taskDao.loadAllTasks(email);
        List<TaskDto> dtos = new ArrayList<>();
        list.forEach(e->{
            dtos.add(
                    new TaskDto(e.getId(),e.getTaskName(),e.getDate(),e.isStatus())
            );
        });

        return dtos;
    }
}
