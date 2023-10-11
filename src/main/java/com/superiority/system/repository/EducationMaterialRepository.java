package com.superiority.system.repository;

import com.superiority.system.domain.educationMaterial.EducationMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationMaterialRepository extends JpaRepository<EducationMaterial, Long> {
}