package com.digital.spring_exam_trainee.repositories;

import com.digital.spring_exam_trainee.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
