package com.example.sign_in_form.model;

import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 5, max = 45, message = "Invalid, length is between 5 - 45")
    private String firstName;
    @NotNull
    @Size(min = 5, max = 45, message = "Invalid, length is between 5 - 45")
    private String lastName;
    @NotBlank
    private String phoneNumber;
    @NotNull
    @Min(value = 18, message = "Age should not be less than 18")
    private int age;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;


}
