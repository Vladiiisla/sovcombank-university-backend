package com.superiority.system.domain.lecture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
    @Column(name = "question_text")
    private String questionText;
    @Column(name = "correct_answer")
    private String correctAnswer;
}
