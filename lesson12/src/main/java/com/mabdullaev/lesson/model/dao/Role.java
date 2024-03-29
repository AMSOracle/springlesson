package com.mabdullaev.lesson.model.dao;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @CreationTimestamp
    @Column(name = "created_At")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_At")
    private LocalDateTime updatedAt;
}
