package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "car_table")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	private String car_image;

	@NotBlank
	@Size(max = 30)
	private String license_number;

	@ManyToOne
    @JoinColumn(name = "car_transmission", referencedColumnName = "system_code")
	private SystemMaster car_transmission;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand_id;
}
