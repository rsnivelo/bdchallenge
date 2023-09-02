package com.appleindustries.challenge.repositories;

import com.appleindustries.challenge.repositories.model.OrderDetail;
import com.appleindustries.challenge.repositories.model.PackageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageTypeRepository extends JpaRepository<PackageType, String> {
}
