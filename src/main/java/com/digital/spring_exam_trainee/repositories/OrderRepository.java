package com.digital.spring_exam_trainee.repositories;

import com.digital.spring_exam_trainee.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
