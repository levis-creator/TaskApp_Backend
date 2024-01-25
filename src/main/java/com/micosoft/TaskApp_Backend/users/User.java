package com.micosoft.TaskApp_Backend.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "task-user")
public class User {
    @Id
    @Column(nullable = false)
    private String userId;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    @Email(message = "please ensure that the email is valid")
    private String email;
}