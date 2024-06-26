package com.hotelmanagementsystem.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.hotelmanagementsystem.validation.Adult;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "First name is required")
	private String fname;
	@NotEmpty(message = "Last name is required")
	private String lname;
	@Email(message = "Email should be valid")
	@NotEmpty(message = "Email is required")
	@Column(unique = true)
	private String email;
	@NotEmpty(message = "Password is required")
	@Size(min = 6, message = "Password must be at least 6 characters long")
	private String password;

	@NotEmpty(message = "Gender is required")
	private String gender;
	@NotNull(message = "Date of birth is required")
	@Past(message = "Date of birth must be in the past")

    @Adult(message = "Your Age Must Be 18 years old")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dob;
	@NotEmpty(message = "Phone number is required")
	@Pattern(regexp = "98\\d{8}", message = "Phone number must start with 98 and be 10 digits in total")
	private String phone;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;
	
	
	private String roles;
	
}
