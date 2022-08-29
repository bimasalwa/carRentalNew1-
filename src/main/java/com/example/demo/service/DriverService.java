package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Driver;
import com.example.demo.repository.DriverRepository;

@Service
public class DriverService {
    @Autowired
    DriverRepository repository;

    public List<Driver> inquiryDriver(String param){
        return repository.inquiryDriver(param);
    }
}
