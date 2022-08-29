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
@Table(name = "system_master")
public class SystemMaster {
    @Id
    @NotBlank
    @Size(max = 30)
    private String system_code;

    @NotBlank
    @Size(max = 30)
    private String system_type;

    @NotBlank
    @Size(max = 20)
    private String system_label;
}
