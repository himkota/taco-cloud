package com.himanshu.tacos.data.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.himanshu.tacos.data.IngredientRepository;
import com.himanshu.tacos.model.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Iterable<Ingredient> findAll() {
		return jdbcTemplate.query(" select id,name,type from Ingredient ",
				this::mapRowToIngredient);
	}

	@Override
	public Ingredient findOne(String id) {
		return jdbcTemplate.queryForObject(
				" select id,name,type from Ingredient where id=? ",
				this::mapRowToIngredient,id);
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		jdbcTemplate.update(
				" insert into Ingredient () values (?,?,?) ",
				ingredient.getId(),
				ingredient.getName(),
				ingredient.getType().toString());
		return ingredient;
	}
	
	private Ingredient mapRowToIngredient(ResultSet rs,int rowNum) throws SQLException{
		return new Ingredient(rs.getString("id"),rs.getString("name"),Ingredient.Type.valueOf(rs.getString("type")));
	}

}
