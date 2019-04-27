package com.himanshu.tacos.data;

import com.himanshu.tacos.model.Ingredient;

public interface IngredientRepository {
	Iterable<Ingredient> findAll();
	Ingredient findOne(String id);
	Ingredient save(Ingredient ingredient);
}
