package com.ibm.practica.shop.repository;

import com.ibm.practica.shop.model.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}
