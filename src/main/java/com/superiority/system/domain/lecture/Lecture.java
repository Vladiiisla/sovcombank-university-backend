package com.superiority.system.domain.lecture;

import com.superiority.system.domain.course.Course;
import com.superiority.system.domain.educationMaterial.EducationMaterial;
import com.superiority.system.domain.user.instructor.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lecture")
public class Lecture{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "date_time")
    private ZonedDateTime dateTime;
    @Column(name = "location")
    private String location;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    @ManyToMany
    @JoinTable(
            name = "lecture_material",
            joinColumns = @JoinColumn(name = "lecture_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private Set<EducationMaterial> materials;
    @Column(name = "description")
    private String description;
    @Column(name = "duration_minutes")
    private int durationMinutes;
    @Column(name = "recorder_video_url")
    private String recorderVideoUrl;
    @ElementCollection
    private List<String> tags;
    @Column(name = "required_prerequisites")
    private String requiredPrerequisites;
    @OneToMany(mappedBy = "lecture")
    private List<Quiz> quizzes;
    @ManyToMany
    @JoinTable(
            name = "lecture_courses",
            joinColumns = @JoinColumn(name = "lecture_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
    @OneToMany(mappedBy = "lecture")
    private List<LectureFeedback> feedback;
    @Column(name = "location_description")
    private String locationDescription;
    @Column(name = "presentation_url")
    private String presentationUrl;



}
