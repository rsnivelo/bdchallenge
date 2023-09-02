package com.appleindustries.challenge.repositories;

import com.appleindustries.challenge.repositories.model.Customer;
import com.appleindustries.challenge.repositories.model.CustomerOrder;
import com.appleindustries.challenge.repositories.model.OrderDetail;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    @Query("select od from OrderDetail od where od.price is not null and od.order.creationDate between :startDate and :endDate")
    List<OrderDetail> getPayedOrders(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
