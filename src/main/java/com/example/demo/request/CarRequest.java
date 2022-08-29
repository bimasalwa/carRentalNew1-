package com.example.demo.request;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarRequest {
    @NotBlank
    private Long car_id;

    @NotBlank
	@Size(max = 30)
	private String car_name;

	@NotBlank
	@Size(max = 30)
	private String car_price_day;

	@NotBlank
	@Size(max = 30)
	private String car_price_hour;

	@NotBlank
	@Size(max = 30)
	private String car_year;

	@NotBlank
	@Size(max = 20)
	private String car_color;

    @NotBlank
	@Size(max = 20)
	private String car_transmission;

	private String car_image;

    @NotBlank
	@Size(max = 30)
	private String license_number;
    
    @NotBlank
    private Long brand_id;
}
