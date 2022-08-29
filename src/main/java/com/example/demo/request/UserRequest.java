package com.example.demo.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {
    @NotBlank
	private String username;

	@NotBlank
	private String password;
    
    @Size(max = 50)
    @Email
    private String email;
}
