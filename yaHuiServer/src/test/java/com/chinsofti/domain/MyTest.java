package com.chinsofti.domain;

import java.util.List;

import org.junit.Test;

import com.chinasofti.dao.CustomerDao;
import com.chinasofti.dao.EmployeeDao;
import com.chinasofti.dao.impl.CustomerDaoImpl;
import com.chinasofti.dao.impl.EmployeeDaoImpl;
import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Employee;

public class MyTest {
	//客户登录测试
	@Test
	public void cLogin(){
		CustomerDao cdao = new CustomerDaoImpl();
		Customer c = cdao.cLogin("lisi", "123456");
		System.out.println(c);
	}
	//客户修改密码
	@Test
	public void alterPassword(){
		CustomerDao cdao = new CustomerDaoImpl();
		boolean b = cdao.alterCustPass(2, "666666");
		System.out.println(b);
	}
	//查询所有客户
	@Test
	public void findall(){
		CustomerDao cdao = new CustomerDaoImpl();
		List<Customer> list = cdao.findCust();
		for (Customer c : list) {
			System.out.println(c);
		}
	}
	//根据客户编号查询客户
	@Test
	public void findById(){
		CustomerDao cdao = new CustomerDaoImpl();
		Customer c = cdao.findCustById(3);
		System.out.println(c);
	}
	//成为会员
	@Test
	public void bevip(){
		CustomerDao cdao = new CustomerDaoImpl();
		boolean b = cdao.beVip(3, 2);
		System.out.println(b);
	}
	//充值
	@Test
	public void topup(){
		CustomerDao cdao = new CustomerDaoImpl();
		boolean b = cdao.topUp(2, 100);
		System.out.println(b);
	}
	
	
	
	//添加员工
	@Test
	public void addEmployee(){
		EmployeeDao edao = new EmployeeDaoImpl();
		boolean b=edao.addEmployee("解明卓", "解明卓", "123456");
		System.out.println(b);
	}
	//员工登录
	@Test
	public void elogin(){
		EmployeeDao edao = new EmployeeDaoImpl();
		Employee e=edao.eLogin("解明卓", "123456");
		System.out.println(e);
	}
	
	//员工修改密码
	@Test
	public void alterEmpPass(){
		EmployeeDao edao = new EmployeeDaoImpl();
		boolean b = edao.alterEmpPass(2, "666666");
		System.out.println(b);
	}
	
	//查询所有员工
	@Test
	public void findEmp(){
		EmployeeDao edao = new EmployeeDaoImpl();
		List<Employee> list = edao.findemp();
		for (Employee e : list) {
			System.out.println(e);
		}
	}
}
