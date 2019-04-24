package com.chinasofti.dao;

import java.util.List;
import java.util.Map;

import com.chinasofti.domain.Employee;
import com.chinasofti.domain.Food;

public interface EmployeeDao {
	//员工登录验证
	public Employee eLogin(String account,String password);
		
	//员工修改密码
	public boolean alterEmpPass(int empId, String newPass);
		
	//查询所有员工
	public List<Employee> findemp();
		
	//通过顾客编号查找员工
	public Employee findempById(int empId);
	
	//新增员工
	public boolean addEmployee(String empName,String account,String password);
	
	//删除员工
	public boolean removeEmployee(int empId);
	
	//冻结用户
	public boolean freezeUser(int userId);
	
	//挂失
	public boolean report(int cId);
	
	//补办
	public boolean replace(int cId);
	
	//查询各个菜品月销量
	public Map<Food, Integer> sale();
	
	//查看最受欢迎的菜品
	public Food favorite();

	public boolean modifyVipDis(int lev, double dis);

	public boolean relieveUser(int userId);
}
