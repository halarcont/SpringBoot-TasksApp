package com.heriberto.springboot.tareas_app.mapper;

import com.heriberto.springboot.tareas_app.dto.TaskInDTO;
import com.heriberto.springboot.tareas_app.persistence.entity.Task;
import com.heriberto.springboot.tareas_app.persistence.entity.TaskStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{

    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.On_Time);
        return task;
    }
}
