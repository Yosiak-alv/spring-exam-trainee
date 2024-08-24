package com.digital.spring_exam_trainee.repositories;

import com.digital.spring_exam_trainee.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
