package com.example.itacademy.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
//
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(length = 15, nullable = false, unique = true)
    private String phone;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false, foreignKey =
    @ForeignKey(name = "FK_students_groups"))
    private Group group;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Payment> payments;
}
