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
@Table(name = "customer_table")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    @NotBlank
    @Size(max = 30)
    private String customer_name;

    @ManyToOne
    @JoinColumn(name = "customer_gender", referencedColumnName = "system_code")
    private SystemMaster customer_gender;

    @NotBlank
    @Size(max = 30)
    private String customer_address;

    @NotBlank
    @Size(max = 30)
    private String phone_number;

    @ManyToOne
    @JoinColumn(name = "customer_guarantee", referencedColumnName = "system_code")
    private SystemMaster customer_guarantee;

    @NotBlank
    @Size(max = 30)
    private String id_number;
}
