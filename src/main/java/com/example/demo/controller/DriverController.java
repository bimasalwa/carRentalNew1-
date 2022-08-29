package com.example.demo.controller;
import java.util.List;
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
import com.example.demo.model.Driver;
import com.example.demo.repository.DriverRepository;
import com.example.demo.request.SingleStringRequest;
import com.example.demo.response.CommonResponse;
import com.example.demo.service.DriverService;
import com.example.demo.utils.Constant;
import com.example.demo.utils.Req;


@RestController
@RequestMapping("/api/driver")
public class DriverController {
    @Autowired
    DriverService service;

    @Autowired
    DriverRepository repository;

    @PostMapping("/addDriver")
    public ResponseEntity<?> addDriver(@RequestBody Req.AddDriver request) {
        try {
            repository.save(Constant.toDriver(request));
            return CommonResponse.success("Driver Registered");
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @PutMapping("/updateDriver")
    public ResponseEntity<Object> updateDriver(@RequestBody Req.EditDriver req) {
        try {
            repository.save(Constant.toDriver(req));
            return CommonResponse.success("Driver Updated");
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @DeleteMapping("/deleteDriverById/{driver_id}")
    public ResponseEntity<Object> deleteDriverById(@PathVariable Long driver_id) {
        try {
            repository.deleteById(driver_id);
            return CommonResponse.success("Driver Deleted");
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @GetMapping("/getDriverById/{driver_id}")

    public ResponseEntity<?> getDriverById(@PathVariable Long driver_id) {
        try {
            Driver cust = repository.findById(driver_id).orElse(null);
            return CommonResponse.common("OK", HttpStatus.OK, cust);
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @PostMapping("/inquiryDriver")
    public ResponseEntity<?> inquiryDriver(@RequestBody SingleStringRequest request) {
        try {
            List<Driver> custs = service.inquiryDriver(request.getValue());
            return CommonResponse.common("OK", HttpStatus.OK, custs);
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }
}
