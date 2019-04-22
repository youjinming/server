package com.chinasofti.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinasofti.dao.EmployeeDao;
import com.chinasofti.domain.Employee;
import com.chinasofti.domain.Food;
import com.chinasofti.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private DBUtil db;
	
	public Employee eLogin(String account, String password) {
		db = new DBUtil();
		String sql = "select * from employee where account=? and password=?";
		try {
			ResultSet rs = this.db.query(sql, account,password);
			while(rs.next()){
				Employee e = new Employee(rs.getInt("empId"), rs.getString("empName"), rs.getString("account"), rs.getString("account"), rs.getInt("mgr"));
				return e;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			this.db.closed();
		}
		return null;
	}

	public boolean alterEmpPass(int empId,  String newPass) {
		db = new DBUtil();
		String sql = "update employee set password=? where  empId=?";
		try {
			int i = this.db.update(sql, newPass,empId);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.db.closed();
		}
		return false;
	}

	public List<Employee> findemp() {
		db = new DBUtil();
		List<Employee> list = new ArrayList<Employee>();
		String sql = "select * from employee";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				Employee e = new Employee(rs.getInt("empId"), rs.getString("empName"), rs.getString("account"), rs.getString("account"), rs.getInt("mgr"));
				list.add(e);
			}
			return list;
		} catch (SQLException e) {
			return null;
		} finally {
			this.db.closed();
		}
	}

	public Employee findempById(int empId) {
		List<Employee> list = this.findemp();
		for (Employee e : list) {
			if(e.getEmpId() == empId){
				return e;
			}
		}
		return null;
	}

	public boolean addEmployee(String empName, String account, String password) {
		db = new DBUtil();
		String sql = "insert into employee(empid,empName,account,password,mgr) values(seq_emp.nextval,?,?,?,0)";
		try {
			int i = this.db.update(sql, empName,account,password);
			return i>0;
		} catch (SQLException e) {
			return false;
		} finally {
			this.db.closed();
		}
	}

	public boolean removeEmployee(int empId) {
		db = new DBUtil();
		String sql = "delete from employee where empId="+empId;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			return false;
		} finally {
			this.db.closed();
		}
	}

	public boolean freezeUser(int userId) {
		db = new DBUtil();
		String sql = "update customer set userstate=0 where userId="+userId;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			return false;
		} finally {
			this.db.closed();
		}
	}

	public boolean report(int cId) {
		db = new DBUtil();
		String sql = "update viptable set state=0 where cardId="+cId;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			return false;
		} finally {
			this.db.closed();
		}
	}

	public boolean replace(int cId) {
		db = new DBUtil();
		String sql = "update viptable set state=1 where cId="+cId;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			return false;
		} finally {
			this.db.closed();
		}
	}

	public Map<String, Integer> sale() {
		db = new DBUtil();
		Map<String, Integer> m = new HashMap<String, Integer>();
		String sql = "select f.fname,sum(num) from Food f,volumn v where f.fid=v.fid group by fname";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				m.put(rs.getString("fname"), rs.getInt("num"));
			}
			return m;
		} catch (SQLException e) {
			return null;
		} finally {
			this.db.closed();
		}
	}

	public Food favorite() {
		Map<String, Integer> m = this.sale();
		Food f = new Food();
		int max=m.get(0);
		for (int i = 1; i < m.size(); i++) {
			if(m.get(i)>max){
				
			}
		}
		return null;
	}

}
