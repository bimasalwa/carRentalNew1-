package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.request.SingleStringRequest;
import com.example.demo.response.CommonResponse;
import com.example.demo.service.CarService;
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

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    CarService service;

    @Autowired
    CarRepository repository;

    @PostMapping("/addCar")
    public ResponseEntity<?> addCar(@RequestBody Req.AddCar request) {
        try {
            repository.save(Constant.toCar(request));
            return CommonResponse.success("Add Car Success");
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @PutMapping("/updateCar")
    public ResponseEntity<Object> updateCar(@RequestBody Req.EditCar request) {
        try {
            repository.save(Constant.toCar(request));
            return CommonResponse.success("Car Updated");
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @DeleteMapping("/deleteCarById/{car_id}")
    public ResponseEntity<Object> deleteCarById(@PathVariable Long car_id) {
        try {
            repository.deleteById(car_id);
            return CommonResponse.success("Car Deleted");
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @GetMapping("/getCarById/{car_id}")
    public ResponseEntity<?> getCarById(@PathVariable Long car_id) {
        try {
            Car car = repository.findById(car_id).orElse(null);
            return CommonResponse.common("OK", HttpStatus.OK, car);
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }

    @PostMapping("/inquiryCar")
    public ResponseEntity<?> inquiryCar(@RequestBody SingleStringRequest request) {
        try {
            List<Car> car = service.inquiryCar(request.getValue());
            return CommonResponse.common("OK", HttpStatus.OK, car);
        } catch (Exception e) {
            return CommonResponse.fail(e.getMessage());
        }
    }
}
