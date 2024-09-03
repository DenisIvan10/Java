package com.ibm.practica.shop.service;

import com.ibm.practica.shop.model.dto.AddBillDTO;
import com.ibm.practica.shop.model.entity.Bill;
import com.ibm.practica.shop.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class BillService {
    private final BillRepository billRepository;

    public void addBill(AddBillDTO bill) {
        Bill billToBeSaved = Bill.builder()
                .description(bill.getDescription())
                .cost(bill.getCost())
                .build();
        log.info("The bill is: {}", billRepository.save(billToBeSaved));
    }
}
