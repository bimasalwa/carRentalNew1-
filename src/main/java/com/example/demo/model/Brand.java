package com.example.demo.model;
import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "brand_table")
public class Brand {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brand_id;

    @Size(max = 20)
	private String brand_name;
}	
