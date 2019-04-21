package com.himanshu.tacos.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {
	
	@NotNull
	@Size(min=5, message="Name should not be less than 5 characters please")
	private String name;
	
	@Size(min=1, message="Atleast select one ingredient please")
	private List<String> ingredients;
}
