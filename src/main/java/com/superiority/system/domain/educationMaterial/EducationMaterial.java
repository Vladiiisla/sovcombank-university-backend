package com.superiority.system.domain.educationMaterial;

import com.superiority.system.domain.lecture.Lecture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "material")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EducationMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "url")
    private String url; // Ссылка на видео или материал
    @Column(name = "type")
    private String type; // Тип материала (видео, презентация и т.д.)
    @ManyToMany(mappedBy = "materials")
    private Set<Lecture> lectures;
    @Column(name = "description")
    private String description;
    @Column(name = "author")
    private String author;
    @Column(name = "upload_date")
    private LocalDateTime uploadDate;
    @Column(name = "duration")
    private int duration;
    @Column(name = "file_size")
    private int fileSize;
    @Column(name = "language")
    private String language;
    @ElementCollection
    private List<String> tags;
    @Column(name = "likes")
    private int likes;
    @Column(name = "views")
    private int views;
}
