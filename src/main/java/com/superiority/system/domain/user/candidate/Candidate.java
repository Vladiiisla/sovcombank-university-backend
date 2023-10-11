package com.superiority.system.domain.user.candidate;

import com.superiority.system.domain.user.User;
import com.superiority.system.domain.user.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = "candidate")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Candidate extends User {
    @Column(name = "desired_program")
    private String desiredProgram;
    @Column(name = "career_goals")
    private String career_goals;
    @Column(name = "is_enrolled")
    private boolean isEnrolled;
    @Column(name = "enrollment_date")
    private ZonedDateTime enrollmentDate;
    @Column(name = "graduation_date")
    private ZonedDateTime graduationDate;
    @Column(name = "program_status")
    private String programStatus;
    @Column(name = "education_indtitution")
    private String educationInstitution;
    @OneToOne(mappedBy = "candidate")
    private Student student;
}
