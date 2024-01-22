package com.micosoft.TaskApp_Backend.tasks;

import com.micosoft.TaskApp_Backend.tags.Tags;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long taskId;
    private String taskTitle;
    private String tasKDescription;
    private List<String> tags;
    @ManyToOne
    private String category;
    @ManyToOne
    private String userId;
    private boolean complete=false;
    private LocalDate dueDate;
}