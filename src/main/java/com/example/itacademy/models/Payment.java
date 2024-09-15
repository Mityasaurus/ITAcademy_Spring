package com.example.itacademy.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
//
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer paymentAmount;
    @Column(nullable = false)
    private Date paymentDate;
    @Column(nullable = false)
    private Integer yearNumber;
    //
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", nullable = false, foreignKey =
    @ForeignKey(name = "FK_payments_students"))
    private Student student;
}
