package com.digital.spring_exam_trainee.repositories;

import com.digital.spring_exam_trainee.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
