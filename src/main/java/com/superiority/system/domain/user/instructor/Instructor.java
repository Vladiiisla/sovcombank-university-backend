package com.superiority.system.domain.user.instructor;

import com.superiority.system.domain.user.User;
import com.superiority.system.domain.course.Course;
import com.superiority.system.domain.lecture.Lecture;
import com.superiority.system.domain.user.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "instructor")
public class Instructor extends User {
    @ManyToMany(mappedBy = "instructors")
    private Set<Student> students;
    @Column(name="subject")
    private String subject; // Предмет преподавания
    @Column(name = "biography")
    private String biography; // Биография или профиль преподавателя
    @OneToMany(mappedBy = "instructor")
    private Set<Lecture> lectures;
    @Column(name = "experience")
    private String experience;
    @OneToMany(mappedBy = "instructor")
    private Set<Certification> certifications;
    @Column(name = "linkedin_profiles")
    private String linkedinProfile;
    @ElementCollection
    private List<String> researchInterests;
    @Column(name = "awards",columnDefinition = "TEXT")
    private String awardsJson;
    @OneToMany(mappedBy = "instructor")
    private List<Publication> publications;
    @Column(name = "office_location")
    private String officeLocation;
    @OneToMany(mappedBy = "instructor")
    private List<Course> coursesTaught; // Список курсов, которые преподаватель ведет
}
