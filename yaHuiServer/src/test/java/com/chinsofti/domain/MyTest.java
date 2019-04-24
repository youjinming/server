package com.chinsofti.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.chinasofti.dao.CustomerDao;
import com.chinasofti.dao.EmployeeDao;
import com.chinasofti.dao.impl.CustomerDaoImpl;
import com.chinasofti.dao.impl.EmployeeDaoImpl;
import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Employee;
import com.chinasofti.domain.Food;

public class MyTest {
	
	@Test
	public void f(){
		EmployeeDao eDao= new EmployeeDaoImpl();
		Food f = eDao.favorite();
		System.out.println(f);
	}
	
	
	//客户登录测试
	@Test
	public void cLogin(){
		CustomerDao cdao = new CustomerDaoImpl();
		Customer c = cdao.cLogin("hujinwei", "456");
		System.out.println(c);
	}
	
	@Test
	public void addCustomer(){
		CustomerDao cdao = new CustomerDaoImpl();
		boolean c = cdao.addCustomer(new Customer(0, "解明卓", "xiemingzhuo", "123456", 1, null));
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
	
	//挂失
	@Test
	public void report(){
		EmployeeDao edao = new EmployeeDaoImpl();
		boolean b = edao.report(100008);
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
		Employee e=edao.eLogin("lizhilan", "123456");
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
	
	//用户解冻
	@Test
	public void relieve(){
		EmployeeDao edao = new EmployeeDaoImpl();
		boolean b = edao.relieveUser(2);
		System.out.println(b);
	}
	@Test
	public void time(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String oTime=df.format(new Date());
		System.out.println(oTime);
	}
	
	
	@Test
	public void sale(){
		EmployeeDao edao = new EmployeeDaoImpl();
		Map<Food, Integer> m = edao.sale();
		Set<Food> set = m.keySet();
		for (Food food : set) {
			System.out.println(food.getfName()+m.get(food));
		}
	}
}
