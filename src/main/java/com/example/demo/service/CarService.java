package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;

@Service
public class CarService {
    @Autowired
    CarRepository repository;

    public List<Car> inquiryCar(String param){
        return repository.inquiryCar(param);
    }
}
