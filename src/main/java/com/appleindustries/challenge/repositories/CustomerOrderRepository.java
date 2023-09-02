package com.appleindustries.challenge.repositories;

import com.appleindustries.challenge.repositories.model.Customer;
import com.appleindustries.challenge.repositories.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, String> {

    Optional<CustomerOrder> findFirst1ByOrderByCreationDateDesc();

    @Query("select co from CustomerOrder co where co.total is not null and co.creationDate between :startDate and :endDate")
    List<CustomerOrder> getPayedOrders(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
