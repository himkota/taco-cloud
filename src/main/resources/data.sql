delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;
delete from Ingredient;

insert into Ingredient (id,name,type)
	values ('FLTO','Flour Tortilla','WRAP');
insert into Ingredient (id,name,type)
	values ('COTO','Corn Tortilla','WRAP');
insert into Ingredient (id,name,type)
	values ('BEAN','Beans','PROTEIN');
insert into Ingredient (id,name,type)
	values ('CHKN','Chicken','PROTEIN');
insert into Ingredient (id,name,type)
	values ('TMTO','tomato','VEGGIES');
insert into Ingredient (id,name,type)
	values ('LETC','lettuce','VEGGIES');	
insert into Ingredient (id,name,type)
	values ('CHED','Cheddar','CHEESE');	
insert into Ingredient (id,name,type)
	values ('JACK','Paper Jack','CHEESE');	
insert into Ingredient (id,name,type)
	values ('SLSA','Salsa','SAUCE');	
insert into Ingredient (id,name,type)
	values ('SRCR','sour cream','SAUCE');	
	