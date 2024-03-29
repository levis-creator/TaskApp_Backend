package com.micosoft.taskapp_backend.tags;

import com.micosoft.taskapp_backend.users.User;
import jakarta.persistence.*;
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