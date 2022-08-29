package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.request.SingleStringRequest;
import com.example.demo.response.CommonResponse;
import com.example.demo.service.TransactionService;
import com.example.demo.utils.Constant;
import com.example.demo.utils.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transaction;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    TransactionService service;

    @Autowired
    TransactionService repository;

    @PostMapping("/addTransaction")
    public ResponseEntity<?> addCar(@RequestBody Req.AddCar request) {
        try {
            repository.save(Constant.toTransaction(request));
            return CommonResponse.success("Add Transaction Success");
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @PutMapping("/updateTransaction")
    public ResponseEntity<Object> updateTransaction(@RequestBody Req.EditCar request) {
        try {
            repository.save(Constant.toTransaction(request));
            return CommonResponse.success("Transaction Updated");
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @DeleteMapping("/deleteCarById/{car_id}")
    public ResponseEntity<Object> deleteTransactioById(@PathVariable Long transaction_id) {
        try {
            repository.deleteById(transaction_id);
            return CommonResponse.success("Transaction Deleted");
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @GetMapping("/getTransaction")
    public ResponseEntity<?> getTransaction(@PathVariable Long transaction_id) {
        try {
            Car car = repository.(transaction_id).orElse(null);
            return CommonResponse.common("OK", HttpStatus.OK, car);
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @PostMapping("/inquiryCar")
    public ResponseEntity<?> inquiryTransaction(@RequestBody SingleStringRequest request) {
        try {
            List<Transaction> transaction_id = service.inquiryTransaction(request.getValue());
            return CommonResponse.common("OK", HttpStatus.OK, transaction_id;
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }
}
