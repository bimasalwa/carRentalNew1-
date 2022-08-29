package com.example.demo.request;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DriverRequest {
    @NotBlank
    private Long driver_id;

    @NotBlank
    @Size(max = 30)
    private String driver_name;

    @NotBlank
    @Size(max = 50)
    private String driver_address;

    @NotBlank
    @Size(max = 30)
    private String driver_gender;

    @NotBlank
    @Size(max = 30)
    private String driver_birthdate;

    @NotBlank
    @Size(max = 30)
    private String phone_number;

    @NotBlank
    @Size(max = 30)
    private String experience;

    @NotBlank
    @Size(max = 30)
    private String license_number;

    @NotBlank
    @Size(max = 30)
    private String id_number;
}
