package com.micosoft.taskapp_backend.tasks;

import com.micosoft.taskapp_backend.categories.Category;
import com.micosoft.taskapp_backend.users.User;
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
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_item_id")
    private Category categoryItem;

}