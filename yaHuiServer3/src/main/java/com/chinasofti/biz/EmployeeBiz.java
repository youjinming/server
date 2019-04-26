package com.chinasofti.biz;

import java.util.List;
import java.util.Map;

import com.chinasofti.domain.Employee;

public interface EmployeeBiz {
	//员工登录验证
	public Employee eLogin(String account,String password);
		
	//员工修改密码
	public String alterEmpPass(int empId, String newPass);
		
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
	public String report(int cId);
	
	//补办
	public String replace(int cId);
	
	//查询各个菜品月销量
	public Map<String, Integer> sale();
	
	//查看最受欢迎的菜品
	public String favorite();
}
