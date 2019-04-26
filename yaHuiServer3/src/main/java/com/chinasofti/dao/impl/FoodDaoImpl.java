package com.chinasofti.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.dao.FoodDao;
import com.chinasofti.domain.Employee;
import com.chinasofti.domain.Food;
import com.chinasofti.util.DBUtil;

public class FoodDaoImpl implements FoodDao {
	DBUtil db;
	
	public List<Food> findFood() {
		db = new DBUtil();
		List<Food> list = new ArrayList<Food>();
		String sql = "select * from food";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				if(rs.getInt("isale")!=0){
					Food f = new Food(rs.getInt("fId"), rs.getString("fName"), rs.getDouble("price"), rs.getInt("tid"), rs.getDouble("dis"));
					list.add(f);
				}
			}
			return list;
		} catch (SQLException e) {
			return null;
		} finally {
			this.db.closed();
		}
	}

	public Food findFoodById(int fId) {
		List<Food> list = this.findFood();
		for (Food f : list) {
			if(f.getfId() == fId){
				return f;
			}
		}
		return null;
	}

	public boolean addFood(Food f) {
		db = new DBUtil();
		String sql = "insert into food(fid,fname,price,tid,dis) values(seq_food.nextval,?,?,?,?)";
		try {
			int i = this.db.update(sql, f.getfName(),f.getPrice(),f.gettId(),f.getDis());
			return i>0;
		} catch (SQLException e) {
			return false;
		} finally {
			this.db.closed();
		}
	}

	public boolean modifyFood(int fId, Food f) {
		db = new DBUtil();
		String sql = "update food set fname=?,price=?,tid=?,dis=? where fid="+fId;
		try {
			int i = this.db.update(sql, f.getfName(),f.getPrice(),f.gettId(),f.getDis());
			return i>0;
		} catch (SQLException e) {
			return false;
		} finally {
			this.db.closed();
		}
	}

	public boolean removeFood(int fId) {
		db = new DBUtil();
		String sql = "update food set isale = 0 where fid="+fId;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			return false;
		} finally {
			this.db.closed();
		}
	}

}
