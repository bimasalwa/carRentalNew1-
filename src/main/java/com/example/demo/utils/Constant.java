package com.example.demo.utils;

import com.example.demo.model.*;
import com.example.demo.request.CarRequest;
import com.example.demo.request.CustomerRequest;
import com.example.demo.request.DriverRequest;
import com.example.demo.request.UserRequest;


public class Constant {
    public static Users user(UserRequest req) {
        Users model = new Users();
        if (req.getPassword() != null) {
            model.setPassword(req.getPassword());
        }
        if (req.getEmail() != null) {
            model.setEmail(req.getEmail());
        }
        model.setUsername(req.getUsername());
        return model;
    }

    public static Customer toCustomer(CustomerRequest req) {
        Customer model = new Customer();
        SystemMaster gender = new SystemMaster();
        SystemMaster hold = new SystemMaster();
        if (req.getCustomer_id() != null) {
            model.setCustomer_id(req.getCustomer_id());
        }
        model.setCustomer_address(req.getCustomer_address());
        model.setCustomer_name(req.getCustomer_name());
        model.setPhone_number(req.getPhone_number());
        model.setId_number(req.getId_number());

        gender.setSystem_code(req.getCustomer_gender());
        hold.setSystem_code(req.getCustomer_guarantee());
        model.setCustomer_gender(gender);
        model.setCustomer_guarantee(hold);
        return model;
    }

    public static Car toCar(CarRequest req) {
        SystemMaster transmission = new SystemMaster();
        Brand brand = new Brand();
        Car model = new Car();
        if (req.getCar_id() != null) {
            model.setCar_id(req.getCar_id());
        }
        transmission.setSystem_code(req.getCar_transmission());
        model.setLicense_number(req.getLicense_number());
        model.setCar_price_hour(req.getCar_price_hour());
        model.setCar_price_day(req.getCar_price_day());
        model.setCar_color(req.getCar_color());
        model.setCar_image(req.getCar_image());
        brand.setBrand_id(req.getBrand_id());
        model.setCar_name(req.getCar_name());
        model.setCar_year(req.getCar_year());
        model.setCar_transmission(transmission);
        model.setBrand_id(brand);
        return model;
    }

    public static Driver toDriver(DriverRequest req) {
        SystemMaster gender = new SystemMaster();
        Driver model = new Driver();
        if (req.getDriver_id() != null) {
            model.setDriver_id(req.getDriver_id());
        }
        model.setDriver_birthdate(req.getDriver_birthdate());
        model.setDriver_address(req.getDriver_address());
        gender.setSystem_code(req.getDriver_gender());
        model.setDriver_name(req.getDriver_name());
        model.setPhone_number(req.getPhone_number());
        model.setExperience(req.getExperience());
        model.setLicense_number(req.getLicense_number());
        model.setId_number(req.getId_number());
        model.setDriver_gender(gender);
        return model;

    }
}
