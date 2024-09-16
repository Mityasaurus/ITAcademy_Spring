package com.example.itacademy.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
//
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @Column(nullable = false, unique = true)
    @NonNull
    private String name;
    @Column(length = 15, nullable = false, unique = true)
    @NonNull
    private String phone;
    //
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", nullable = false, foreignKey =
    @ForeignKey(name = "FK_departments_faculties"))
    private Faculty faculty;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Group> groups;
}
