package com.micosoft.TaskApp_Backend.tags;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tags")
public class Tags {

    @Id
    private String tagName;
    @NotBlank(message = "userId can't be blank")
    @NotEmpty(message = "userId can't be empty")
    @NotNull(message = "userId can't be null")
    @ManyToOne
    private String userId;
    private  String colors;
}