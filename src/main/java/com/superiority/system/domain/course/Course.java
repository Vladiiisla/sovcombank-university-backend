package com.superiority.system.domain.course;

import com.superiority.system.domain.user.instructor.Instructor;
import com.superiority.system.domain.lecture.Lecture;
import com.superiority.system.domain.user.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    @ManyToMany(mappedBy = "enrolledCourses")
    private List<Student> enrolledStudents;
    @ManyToMany(mappedBy = "courses")
    private List<Lecture> lectures;
}
