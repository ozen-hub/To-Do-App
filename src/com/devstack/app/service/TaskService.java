package com.devstack.app.service;

import com.devstack.app.dto.TaskDto;
import com.devstack.app.model.Task;

public interface TaskService {
    public void createTask(TaskDto dto);
}
