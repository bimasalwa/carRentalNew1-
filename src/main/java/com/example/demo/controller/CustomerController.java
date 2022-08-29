package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.request.SingleStringRequest;
import com.example.demo.response.CommonResponse;
import com.example.demo.service.CustomerService;
import com.example.demo.utils.Constant;
import com.example.demo.utils.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService service;

    @Autowired
    CustomerRepository repository;

    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Req.AddCustomer request) {
        try {
            repository.save(Constant.toCustomer(request));
            return CommonResponse.success("Customer Registered");
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Object> updateCustomer(@RequestBody Req.EditCustomer req) {
        try {
            repository.save(Constant.toCustomer(req));
            return CommonResponse.success("Customer Updated");
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }


    @DeleteMapping("/deleteCustomerById/{customer_id}")
    public ResponseEntity<Object> deleteCustomerById(@PathVariable Long customer_id) {
        try {
            repository.deleteById(customer_id);
            return CommonResponse.success("Customer Deleted");
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @GetMapping("/getCustomerById/{customer_id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long customer_id) {
        try {
            Customer cust = repository.findById(customer_id).orElse(null);
            return CommonResponse.common("OK", HttpStatus.OK, cust);
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @PostMapping("/inquiryCustomer")
    public ResponseEntity<?> inquiryCustomer(@RequestBody SingleStringRequest request) {
        try {
            List<Customer> lists = service.inquiryCustomer(request.getValue());
            return CommonResponse.common("OK", HttpStatus.OK, lists);
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }
}
