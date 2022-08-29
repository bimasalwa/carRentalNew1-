package com.example.demo.utils;

import com.example.demo.request.CarRequest;
import com.example.demo.request.CustomerRequest;
import com.example.demo.request.DriverRequest;
import com.example.demo.request.UserRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Req {
    @JsonIgnoreProperties("email")
    public static class Login extends UserRequest {}

    public static class Register extends UserRequest {}
       
    @JsonIgnoreProperties("customer_id")
    public static class AddCustomer extends CustomerRequest {}

    public static class EditCustomer extends CustomerRequest {}

    
    @JsonIgnoreProperties("car_id")
    public static class AddCar extends CarRequest {}

    public static class EditCar extends CarRequest {}

    @JsonIgnoreProperties("driver_id")
    public static class AddDriver extends DriverRequest {}

    public static class EditDriver extends DriverRequest {}
}
