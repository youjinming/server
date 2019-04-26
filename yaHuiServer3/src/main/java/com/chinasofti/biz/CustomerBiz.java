package com.chinasofti.biz;

import java.util.List;
import java.util.Map;

import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Food;
import com.chinasofti.domain.Po;

public interface CustomerBiz {
	//客户登录验证
	public Customer cLogin(String account,String password);
	
	//客户修改密码
	public String alterCustPass(int userId, String oldPass);
	
	//查询所有客户
	public List<Customer> findCust();
	
	//通过顾客编号查找客户
	public Customer findCustById(int userId);
	
	//办卡
	public String beVip(int userId,int lv);
	
	//充值
	public String topUp(int userId,double money); 
	
	//结账
	public Po settle(Customer c,Map<Food, Integer> m,double getMoney);
}
