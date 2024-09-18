package com.example.itacademy.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
//
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @Column(nullable = false)
    @NonNull
    private Integer paymentAmount;
    @Column(nullable = false)
    @NonNull
    private Date paymentDate;
    @Column(nullable = false)
    @NonNull
    private Integer yearNumber;
    //
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", foreignKey =
    @ForeignKey(name = "FK_payments_students"))
    private Student student;
}
