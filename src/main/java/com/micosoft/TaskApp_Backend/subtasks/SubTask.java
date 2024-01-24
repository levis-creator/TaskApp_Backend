package com.micosoft.TaskApp_Backend.subtasks;

import com.micosoft.TaskApp_Backend.tasks.Task;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sub_task")
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long subTaskId;
    private String subTaskName;
    private boolean completedSubTask=false;

    @ManyToOne
    @JoinColumn(name = "task_task_id")
    private Task task;

}