package com.superiority.system.domain.user.instructor;

import com.superiority.system.domain.user.mentor.Mentor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "certification")
@NoArgsConstructor
@AllArgsConstructor
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String certificationName;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;
}
