package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Brand;
import com.example.demo.repository.BrandRepository;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandRepository repository;

    public Brand saveBrand(String brand_name) {
        Brand brand = new Brand();
        brand.setBrand_name(brand_name);
        return repository.save(brand);
    }

    public List<Brand> inquiryBrand(String param) {
        return repository.inquiryBrand(param);
    }

    public Boolean isExist(String name) {
        return repository.brandIsExist(name) != null;
    }
}
