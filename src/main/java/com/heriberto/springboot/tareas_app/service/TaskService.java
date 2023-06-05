package com.heriberto.springboot.tareas_app.service;

import com.heriberto.springboot.tareas_app.dto.TaskInDTO;
import com.heriberto.springboot.tareas_app.exceptions.ToDoExceptions;
import com.heriberto.springboot.tareas_app.mapper.TaskInDTOToTask;
import com.heriberto.springboot.tareas_app.persistence.entity.Task;
import com.heriberto.springboot.tareas_app.persistence.entity.TaskStatus;
import com.heriberto.springboot.tareas_app.persistence.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Handler;

@Service
public class TaskService {

    private final TaskRepository repository;

    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task creteTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        this.repository.save(task);

        return this.repository.save(task);
    }

    public List<Task> findAll(){
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFInished(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not Found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

    @Transactional
    public void deleteById(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not Found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

}
