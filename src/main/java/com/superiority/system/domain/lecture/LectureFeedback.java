package com.superiority.system.domain.lecture;

import com.superiority.system.domain.user.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @Column(name = "feedback_text")
    private String feedbackText;

    @Column(name = "rating")
    private int rating;
}
