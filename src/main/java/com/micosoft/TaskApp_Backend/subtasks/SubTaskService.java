package com.micosoft.TaskApp_Backend.subtasks;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubTaskService {
    @Autowired
    private final SubTaskRepository subTaskRepository;

    public List<SubTask> getSubTasks() {
        return subTaskRepository.findAll();
    }

    public SubTask getSubtask(Long id) {
        Optional<SubTask> subTaskDb = subTaskRepository.findById(id);
        if (subTaskDb.isPresent()) {
            return subTaskDb.get();
        } else {
            throw new IllegalStateException("Subtask does not exist");
        }
    }

    public SubTask creatingSubTask(SubTask subTask) {
        Optional<SubTask> subTaskDb = subTaskRepository.findById(subTask.getTaskId());
        if (subTaskDb.isEmpty()) {
            return subTaskRepository.save(subTask);
        } else {
            throw new IllegalStateException("Subtask already exist");
        }
    }

    public String deleteTask(Long id) {
        Optional<SubTask> subTaskDb = subTaskRepository.findById(id);
        if (subTaskDb.isPresent()) {
            subTaskRepository.deleteById(id);
            return "Delete subtask";
        } else {
            throw new IllegalStateException("Task not found");
        }
    }

    public SubTask updateSubTask(Long id, SubTask subTask) {
        Optional<SubTask> subTaskDb = subTaskRepository.findById(id);
        if (subTaskDb.isEmpty()) {
            throw new IllegalStateException("Task not found");
        } else if (!subTask.getSubTaskName().isEmpty() && !subTask.getSubTaskName().equals(subTaskDb.get().getSubTaskName())) {
            subTaskDb.get().setSubTaskName(subTask.getSubTaskName());
        }
        if (!subTask.isCompletedSubTask()==subTaskDb.get().isCompletedSubTask()) {
            subTaskDb.get().setCompletedSubTask(subTask.isCompletedSubTask());
        }
        return subTaskRepository.save(subTaskDb.get());
    }
}