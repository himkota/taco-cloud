package com.himanshu.tacos.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {
	
	private long id;
	
	private Date createdAt;
	
	@NotNull
	private String name;
	
	private List<Ingredient> ingredients;
}
