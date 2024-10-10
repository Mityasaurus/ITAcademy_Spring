package com.example.itacademy.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
//
@Entity
@Table(name = "users")
public class UserModel {
    public enum Status{
        CREATED, ACTIVE, BLOCKED, DELETED
    }

    public enum Role{
        GUEST, USER, ADMIN
    }

    {
        status = Status.CREATED;
        role = Role.GUEST;
    }

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, length = 50, unique = true)
    private String login;

    @NonNull
    @Column(nullable = false)
    private String password;

    @NonNull
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Role role;
}
