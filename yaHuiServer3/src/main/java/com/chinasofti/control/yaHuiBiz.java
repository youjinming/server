package com.chinasofti.control;

import java.util.List;
import java.util.Map;

import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Employee;
import com.chinasofti.domain.Food;
import com.chinasofti.domain.Po;

public interface yaHuiBiz {
	//客户登录验证
	public Customer cLogin(String account,String password);
		
	//客户修改密码
	public String alterCustPass(int userId,String newPass);
		
	//查询所有客户
	public List<Customer> findCust();
		
	//通过顾客编号查找客户
	public Customer findCustById(int userId);
		
	//办卡
	public String beVip(int userId,int lv);
		
	//充值
	public String topUp(int userId,double money); 
		
	//结账
	public Po settle(Customer c,Map<Food,Integer> m,double getMoney);
	
	//员工登录验证
	public Employee eLogin(String account,String password);
		
	//员工修改密码
	public String alterEmpPass(int empId,String newPass);
		
	//查询所有员工
	public List<Employee> findemp();
		
	//通过顾客编号查找员工
	public Employee findempById(int empId);
	
	//新增员工
	public String addEmployee(String empName,String account,String password);
	
	//删除员工
	public String removeEmployee(int empId);
	
	//冻结用户
	public String freezeUser(int userId);
	
	//挂失
	public String report(int cardId);
	
	//补办
	public String replace(int cardId);
	
	//查询各个菜品月销量
	public Map<String, Integer> sale();
	
	//查看最受欢迎的菜品
	public String favorite();
	
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
