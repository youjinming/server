package com.chinasofti.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
				Employee e = new Employee(rs.getInt("empId"), rs.getString("empName"), rs.getString("account"), rs.getString("password"), rs.getInt("mgr"));
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
		String sql = "update customer set state=0 where userId="+userId;
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
		try {
			String sql = "select state from viptable where cardid="+cId;
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				if(rs.getInt("state")==1){
					return false;
				}
			}
			String sql1 = "update viptable set state=1 where cardid="+cId;
			int i = this.db.update(sql1);
			return i>0;
		} catch (SQLException e) {
			return false;
		} finally {
			this.db.closed();
		}
	}

	public Map<Food, Integer> sale() {
		db = new DBUtil();
		Map<Food, Integer> m = new HashMap<Food, Integer>();
		String sql = "select f.fname,f.fid,f.price,f.tid,f.dis,NVL(sum(num),0) num from Food f,volumn v where f.fid=v.fid(+) group by fname,f.fid,f.price,f.tid,f.dis";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				m.put(new Food(rs.getInt("fId"), rs.getString("fName"), rs.getDouble("price"), rs.getInt("tId"), rs.getDouble("dis")), rs.getInt("num"));
			}
			return m;
		} catch (SQLException e) {
			return null;
		} finally {
			this.db.closed();
		}
	}

	public Food favorite() {
		Map<Food, Integer> m = this.sale();
		Set<Food> set = m.keySet();
		int max=0;
		Food f = null;
		for (Food food : set) {
			if(m.get(food)>max){
				max=m.get(food);
				f=food;
			}
		}
		return f;
	}

	public boolean modifyVipDis(int lev, double dis) {
		db = new DBUtil();
		String sql = "update dis set dis=? where lev="+lev;
		try {
			int i = this.db.update(sql,dis);
			return i>0;
		} catch (SQLException e) {
			return false;
		} finally {
			this.db.closed();
		}
	}

	public boolean relieveUser(int userId) {
		db = new DBUtil();
		String sql = "update customer set state=1 where userId="+userId;
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
