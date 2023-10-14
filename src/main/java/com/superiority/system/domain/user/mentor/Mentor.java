package com.superiority.system.domain.user.mentor;

import com.superiority.system.domain.educationMaterial.EducationMaterial;
import com.superiority.system.domain.schedule.Schedule;
import com.superiority.system.domain.user.User;
import com.superiority.system.domain.user.instructor.Certification;
import com.superiority.system.domain.user.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mentor extends User {
    @OneToMany(mappedBy = "mentor")
    private Set<Student> students;
    @Column(name = "department")
    private String department;
    @Column(name = "responsibilities")
    private String responsibilities;
    @Column(name = "experience")
    private String experience;
    @OneToMany(mappedBy = "mentor")
    private List<Certification> certifications;
    @Column(name = "linkedinProfile")
    private String linkedinSpoken;
    @Column(name = "availability")
    private String availability;
    @OneToMany(mappedBy = "mentor")
    private List<Schedule> schedule;
    @OneToMany(mappedBy = "mentor")
    private List<EducationMaterial> educationMaterials;
}
