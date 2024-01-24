package com.micosoft.TaskApp_Backend.tags;

import com.micosoft.TaskApp_Backend.users.User;
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
    private Long tagId;
    private String tagName;
    private  String colors;
    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

}