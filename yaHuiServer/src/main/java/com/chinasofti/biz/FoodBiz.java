package com.chinasofti.biz;

import java.util.List;
import com.chinasofti.domain.Food;

public interface FoodBiz {
	//查看某种类的菜品
	public List<Food> findFood();
	
	//通过菜品编号查找菜品
	public Food findFoodById(int fId);
	
	//新增菜品
	public String addFood(String fName,double price,int tId,double dis);
	
	//修改菜品
	public String modifyFood(int fId,String fName,double price,int tId,double dis);
		
	//删除菜品
	public String removeFood(int fId);
	
}
