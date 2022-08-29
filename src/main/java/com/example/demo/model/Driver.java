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
@Table(name = "driver_table")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driver_id;

    @NotBlank
    @Size(max = 30)
    private String driver_name;

    @NotBlank
    @Size(max = 50)
    private String driver_address;
    
    @ManyToOne
	@JoinColumn(name = "driver_gender", referencedColumnName = "system_code")
	private SystemMaster driver_gender;

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
