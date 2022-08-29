package com.example.demo.request;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerRequest {
    @NotBlank
    private Long customer_id;

    @NotBlank
    @Size(max = 30)
    private String customer_name;

    @NotBlank
    @Size(max = 30)
    private String customer_gender;

    @NotBlank
    @Size(max = 30)
    private String customer_address;

    @NotBlank
    @Size(max = 30)
    private String phone_number;

    @NotBlank
    @Size(max = 30)
    private String customer_guarantee;

    @NotBlank
    @Size(max = 30)
    private String id_number;
}
