package com.micosoft.TaskApp_Backend.subtasks;

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
    @ManyToOne
    private Long taskId;
    private String subTaskName;
    private boolean completedSubTask=false;

}