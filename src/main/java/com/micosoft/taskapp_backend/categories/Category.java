package com.micosoft.taskapp_backend.categories;

import com.micosoft.taskapp_backend.users.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long categoryId;
    private String categoryName;
    private String categoryColor;
    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

}