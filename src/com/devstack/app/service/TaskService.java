package com.devstack.app.service;

import com.devstack.app.dto.TaskDto;
import com.devstack.app.model.Task;

import java.util.List;

public interface TaskService {
    public void createTaskWithUser(TaskDto dto, String username);
    public List<TaskDto> loadAllTasks(String email);
    public void deleteTaskById(Long id);
}
