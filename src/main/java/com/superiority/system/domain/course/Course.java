package com.superiority.system.domain.course;

import com.superiority.system.domain.assignment.Assignment;
import com.superiority.system.domain.educationMaterial.EducationMaterial;
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
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    @ManyToMany(mappedBy = "enrolledCourses")
    private List<Student> enrolledStudents;
    @ManyToMany(mappedBy = "assignmentCourses")
    private List<Assignment> assignments;
    @ManyToMany(mappedBy = "courses")
    private List<Lecture> lectures;
    @ManyToMany(mappedBy = "courses")
    private List<EducationMaterial> educationMaterials;
}
