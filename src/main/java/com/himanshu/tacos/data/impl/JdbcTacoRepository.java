package com.himanshu.tacos.data.impl;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.himanshu.tacos.data.TacoRepository;
import com.himanshu.tacos.model.Ingredient;
import com.himanshu.tacos.model.Taco;

public class JdbcTacoRepository implements TacoRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTacoRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Taco save(Taco design) {
		long tacoId = saveTacoInfo(design);
		design.setId(tacoId);
		for(Ingredient ingredient : design.getIngredients()) {
			saveIngredientToTaco(ingredient,tacoId);
			
		}
		return design;
	}
	
	private long saveTacoInfo(Taco taco) {
		taco.setCreatedAt(new Date());
		PreparedStatementCreator psc = 
				new PreparedStatementCreatorFactory(
						" insert int Taco (name,createdAt) values (?,?)",
						Types.VARCHAR,Types.TIMESTAMP
						).newPreparedStatementCreator(
							Arrays.asList(
								taco.getName(),
								new Timestamp(taco.getCreatedAt().getTime())));
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(psc,keyHolder);
		return keyHolder.getKey().longValue();
	}
	
	private void saveIngredientToTaco(Ingredient ingredient,long tacoId) {
		jdbcTemplate.update(
				" insert into Taco_Ingredients (taco, ingredient) "
				+ " values (?,?) ",
			tacoId,ingredient.getId());
	}
}
