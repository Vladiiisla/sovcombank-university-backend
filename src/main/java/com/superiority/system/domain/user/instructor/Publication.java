package com.superiority.system.domain.user.instructor;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}
