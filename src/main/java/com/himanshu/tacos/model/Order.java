package com.himanshu.tacos.model;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.*;


@Data
public class Order {
	
	private long id;
	
	private Date placedAt;
	
	@NotBlank(message="required field")
	private String name;
	
	@NotBlank(message="required field")
	private String street;
	
	@NotBlank(message="required field")
	private String city;
	
	@NotBlank(message="required field")
	private String state;
	
	@NotBlank(message="required field")
	private String zip;
	
	@CreditCardNumber
	private String ccNumber;
	
	@Pattern(regexp="(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",message="Must be of the format MM/YY")
	private String ccExpiration;
	
	@Digits(integer=3,fraction=0,message="invalid CVV")
	private String ccCVV;
}
