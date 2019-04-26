package com.chinasofti.biz.impl;

import java.util.List;
import java.util.Map;

import com.chinasofti.biz.CustomerBiz;
import com.chinasofti.dao.CustomerDao;
import com.chinasofti.dao.impl.CustomerDaoImpl;
import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Food;
import com.chinasofti.domain.Po;

public class CustomerBizImpl implements CustomerBiz{
	CustomerDao cdao = new CustomerDaoImpl();

	public Customer cLogin(String account, String password) {
		return this.cdao.cLogin(account, password);
	}

	public String alterCustPass(int userId, String newPass) {
		return this.cdao.alterCustPass(userId, newPass)?"密码修改成功！":"密码修改失败！";
	}

	public List<Customer> findCust() {
		return this.cdao.findCust();
	}

	public Customer findCustById(int userId) {
		return this.cdao.findCustById(userId);
	}

	public String beVip(int userId, int lv) {
		return this.cdao.beVip(userId, lv)?"恭喜您成为了会员":"会员办理失败";
	}

	public String topUp(int userId, double money) {
		return this.cdao.topUp(userId, money)?"充值成功":"充值失败";
	}

	public Po settle(Customer c, Map<Food, Integer> m,double getMoney) {
		
		return null;
	}

}
