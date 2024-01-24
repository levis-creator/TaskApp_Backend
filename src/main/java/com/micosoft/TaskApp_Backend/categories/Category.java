package com.micosoft.TaskApp_Backend.categories;

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
    private String userId;

}