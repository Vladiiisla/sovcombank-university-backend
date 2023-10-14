package com.superiority.system.domain.group;

import com.superiority.system.domain.user.student.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groups")
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @OneToMany(mappedBy = "groupForStudents")
    private List<Student> studentList;
}