package com.chinasofti.biz.impl;

import java.util.List;
import java.util.Map;

import com.chinasofti.biz.EmployeeBiz;
import com.chinasofti.dao.EmployeeDao;
import com.chinasofti.dao.impl.EmployeeDaoImpl;
import com.chinasofti.domain.Employee;

public class EmployeeBizImpl implements EmployeeBiz{
	EmployeeDao edao = new EmployeeDaoImpl();

	public Employee eLogin(String account, String password) {
		return this.edao.eLogin(account, password);
	}

	public String alterEmpPass(int empId,String newPass) {
		return this.edao.alterEmpPass(empId, newPass)?"密码修改成功":"密码修改失败";
	}

	public List<Employee> findemp() {
		return this.edao.findemp();
	}

	public Employee findempById(int empId) {
		return this.edao.findempById(empId);
	}

	public String addEmployee(String empName, String account, String password) {
		return this.edao.addEmployee(empName, account, password)?"员工添加成功":"员工添加失败";
	}

	public String removeEmployee(int empId) {
		return this.edao.removeEmployee(empId)?"删除员工成功":"删除员工失败";
	}

	public String freezeUser(int userId) {
		return this.edao.freezeUser(userId)?"用户冻结成功":"用户冻结失败";
	}

	public String report(int cId) {
		return this.edao.report(cId)?"挂失成功":"挂失失败";
	}

	public String replace(int cId) {
		return this.replace(cId);
	}

	public Map<String, Integer> sale() {
		return this.edao.sale();
	}

	public String favorite() {
		return this.edao.favorite().getfName();
	}
	
}
