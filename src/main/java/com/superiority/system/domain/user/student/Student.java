package com.superiority.system.domain.user.student;

import com.superiority.system.domain.assignment.Assignment;
import com.superiority.system.domain.group.Group;
import com.superiority.system.domain.user.User;
import com.superiority.system.domain.course.Course;
import com.superiority.system.domain.user.candidate.Candidate;
import com.superiority.system.domain.user.instructor.Instructor;
import com.superiority.system.domain.lecture.LectureFeedback;
import com.superiority.system.domain.user.mentor.Mentor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Table(name = "student")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {
    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @Column(name = "student_id")
    private String studentID; // Уникальный идентификатор студента
    @Column(name = "enrollment_date")
    private ZonedDateTime enrollmentDate; // Дата зачисления
    @Column(name = "program")
    private String program; // Название программы обучения
    @Column(name = "program_status")
    private String programStatus; // Статус обучающей программы студента (активный, завершенный, и т. д.)
    @ManyToMany
    @JoinTable(
            name = "student_instructor",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id")
    )
    private Set<Instructor> instructors;
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "cource_id")
    )
    private List<Course> enrolledCourses;
    @OneToMany(mappedBy = "student")
    private Set<Assignment> assignments;
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;
    @Column(name = "curriculum")
    private String curriculum; // Учебный план или курсы, в которых студент зарегистрирован
    @Column(name = "expected_graduation_date")
    private Date expectedGraduationDate; // Ожидаемая дата окончания обучения
    @Column(name = "is_graduated")
    private boolean isGraduated; // Флаг, указывающий, окончил ли студент обучение
    @OneToMany(mappedBy = "student")
    private List<LectureFeedback> feedbackForStudent;
    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Group groupForStudents;
}
