package com.superiority.system.domain.assignment;

import com.superiority.system.domain.course.Course;
import com.superiority.system.domain.user.mentor.Mentor;
import com.superiority.system.domain.user.student.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToMany
    @JoinTable(
            name = "assignment_course",
            joinColumns = @JoinColumn(name = "assignment_id"),
            inverseJoinColumns = @JoinColumn(name = "cource_id")
    )
    private List<Course> assignmentCourses;
}