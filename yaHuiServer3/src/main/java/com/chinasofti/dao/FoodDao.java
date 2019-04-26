package com.chinasofti.dao;

import java.util.List;

import com.chinasofti.domain.Food;

public interface FoodDao {

	public List<Food> findFood();
	
	public Food findFoodById(int fId);
	
	public boolean addFood(Food f);
	
	public boolean modifyFood(int fId,Food f);
	
	public boolean removeFood(int fId);

}
