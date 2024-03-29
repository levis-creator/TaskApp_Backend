package com.micosoft.taskapp_backend.tasks;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    @Autowired
    private final TaskService taskService;
    @GetMapping
    public List<Task> gettingTasks(){
        return taskService.getTasks();
    }
    @GetMapping("{id}")
    public Task gettingTask(@PathVariable("id") Long id){
        return taskService.getTask(id);
    }
    @PostMapping
    public Task creatingTask(@RequestBody Task task){
        return taskService.createTask(task);
    }
    @DeleteMapping("{id}")
    public String deletingTask(@PathVariable Long id){
        return taskService.deleteTask(id);
    }
    @PutMapping("{id}")
    public Task updateTask(@PathVariable Long id, Task task){
        return taskService.updateTask(id, task);
    }
}
