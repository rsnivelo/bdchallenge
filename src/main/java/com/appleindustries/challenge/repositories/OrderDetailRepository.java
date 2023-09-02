package com.appleindustries.challenge.repositories;

import com.appleindustries.challenge.repositories.model.Customer;
import com.appleindustries.challenge.repositories.model.OrderDetail;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
