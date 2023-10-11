package com.superiority.system.repository;

import com.superiority.system.domain.lecture.LectureFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureFeedbackRepository extends JpaRepository<LectureFeedback, Long> {
}