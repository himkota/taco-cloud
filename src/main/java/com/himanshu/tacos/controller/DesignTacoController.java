package com.himanshu.tacos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.himanshu.tacos.model.Ingredient;
import com.himanshu.tacos.model.Ingredient.Type;
import com.himanshu.tacos.model.Taco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	@GetMapping
	public String showDesignForm(Model model) {
		log.info("Inside the controller ");
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO", "Floar Tortilla", Type.WRAP),
				new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
				new Ingredient("CARN", "Carnitas", Type.PROTEIN),
				new Ingredient("BEAN", "Black Beans", Type.PROTEIN),
				new Ingredient("TMTO", "Tomato", Type.VEGGIES),
				new Ingredient("LETC", "Lettuce", Type.VEGGIES),
				new Ingredient("CHED", "Cheddar", Type.CHEESE),
				new Ingredient("Jack", "Monterry Jack", Type.CHEESE),
				new Ingredient("SLSA", "salsa", Type.SAUCE),
				new Ingredient("SRCR", "sour cream", Type.SAUCE)
				); 
		
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase()
					, filterByType(ingredients, type));
		}
		model.addAttribute("design",new Taco());
		return "design";
	}
	
	private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
	

}
