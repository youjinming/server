package com.chinasofti.control;

import java.util.List;
import java.util.Map;

import com.chinasofti.biz.CustomerBiz;
import com.chinasofti.biz.EmployeeBiz;
import com.chinasofti.biz.FoodBiz;
import com.chinasofti.biz.impl.CustomerBizImpl;
import com.chinasofti.biz.impl.EmployeeBizImpl;
import com.chinasofti.biz.impl.FoodBizImpl;
import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Employee;
import com.chinasofti.domain.Food;
import com.chinasofti.domain.Po;

public class yaHuiBizImpl implements yaHuiBiz {
	CustomerBiz cBiz;
	EmployeeBiz eBiz;
	FoodBiz fBiz;
	
	

	public yaHuiBizImpl() {
		super();
		this.cBiz = new CustomerBizImpl();
		this.eBiz = new EmployeeBizImpl();
		this.fBiz = new FoodBizImpl();
	}
	
	public String addCustomer(String userName,String account,String password) {
		return this.cBiz.addCustomer(userName,account,password);
	}

	public Customer cLogin(String account, String password) {
		return this.cBiz.cLogin(account, password);
	}

	public String alterCustPass(int userId, String newPass) {
		return this.cBiz.alterCustPass(userId, newPass);
	}

	public List<Customer> findCust() {
		return this.cBiz.findCust();
	}

	public Customer findCustById(int userId) {
		return this.cBiz.findCustById(userId);
	}

	public String beVip(int userId, int lv) {
		return this.cBiz.beVip(userId, lv);
	}

	public String topUp(int userId, double money) {
		return this.cBiz.topUp(userId, money);
	}

	public Po settle(Customer c, Map<Food, Integer> m,double getMoney,double sumprice) {
		return this.cBiz.settle(c, m,getMoney,sumprice);
	}
	
	public Employee eLogin(String account, String password) {
		return this.eBiz.eLogin(account, password);
	}

	public String alterEmpPass(int empId, String newPass) {
		return this.eBiz.alterEmpPass(empId, newPass);
	}

	public List<Employee> findemp() {
		return this.eBiz.findemp();
	}

	public Employee findempById(int empId) {
		return this.eBiz.findempById(empId);
	}

	public String addEmployee(String empName, String account, String password) {
		return this.eBiz.addEmployee(empName, account, password);
	}

	public String removeEmployee(int empId) {
		return this.eBiz.removeEmployee(empId);
	}

	public String freezeUser(int userId) {
		return this.eBiz.freezeUser(userId);
	}

	public String report(int cardId) {
		return this.eBiz.report(cardId);
	}

	public String replace(int cardId) {
		return this.eBiz.replace(cardId);
	}

	public Map<Food, Integer> sale() {
		return this.eBiz.sale();
	}

	public Food favorite() {
		return this.eBiz.favorite();
	}

	public List<Food> findFood() {
		return this.fBiz.findFood();
	}

	public Food findFoodById(int fId) {
		return this.fBiz.findFoodById(fId);
	}

	public String addFood(String fName, double price, int tId, double dis) {
		return this.fBiz.addFood(fName, price, tId, dis);
	}

	public String modifyFood(int fId,String fName, double price, int tId, double dis) {
		return this.fBiz.modifyFood(fId,fName, price, tId, dis);
	}

	public String removeFood(int fId) {
		return this.fBiz.removeFood(fId);
	}

	public String modifyVipDis(int lev, double dis) {
		return this.eBiz.modifyVipDis(lev,dis);
	}

	public String relieveUser(int userId) {
		return this.eBiz.relieveUser(userId);
	}



}
