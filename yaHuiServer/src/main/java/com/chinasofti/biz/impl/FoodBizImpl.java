package com.chinasofti.biz.impl;

import java.util.List;

import com.chinasofti.biz.FoodBiz;
import com.chinasofti.dao.FoodDao;
import com.chinasofti.dao.impl.FoodDaoImpl;
import com.chinasofti.domain.Food;

public class FoodBizImpl implements FoodBiz{
	FoodDao fdao = new FoodDaoImpl();

	public List<Food> findFood() {
		return this.fdao.findFood();
	}

	public Food findFoodById(int fId) {
		return this.fdao.findFoodById(fId);
	}

	public String addFood(String fName, double price, int tId, double dis) {
		return this.fdao.addFood(new Food(0, fName, price, tId, dis))?"菜品添加成功":"菜品添加失败";
	}

	public String modifyFood(int fId,String fName, double price, int tId, double dis) {
		return this.fdao.modifyFood(fId, new Food(0, fName, price, tId, dis))?"菜品修改成功":"菜品修改失败";
	}

	public String removeFood(int fId) {
		return this.fdao.removeFood(fId)?"菜品删除成功":"菜品删除失败";
	}

}
