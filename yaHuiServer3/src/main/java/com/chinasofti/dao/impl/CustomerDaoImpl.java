package com.chinasofti.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.chinasofti.dao.CustomerDao;
import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Food;
import com.chinasofti.domain.Po;
import com.chinasofti.domain.Vip;
import com.chinasofti.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao {
	
	private DBUtil db;
	
	public Customer cLogin(String account, String password) {
		db = new DBUtil();
		try {
			String sql = "select  a.*,v.cardid,v.balance,v.lev,v.state,d.dis from customer a,viptable v,dis d where  a.userid=v.userid(+) and v.lev=d.lev(+) and a.account=? and a.password=?";
			ResultSet rs = this.db.query(sql,account,password);
			while(rs.next()){
				Customer c = new Customer(rs.getInt("userId"), rs.getString("userName"), rs.getString("account"), rs.getString("password"), rs.getInt("userstate"), new Vip(rs.getInt("cardId"), rs.getInt("lev"), rs.getDouble("balance"), rs.getInt("State"),rs.getDouble("dis")));
				return c;
			}

		} catch (SQLException e) {
			return null;
		} finally {
			this.db.closed();
		}
		return null;
	}

	public boolean alterCustPass(int userId, String newPass) {
		db = new DBUtil();
		String sql = "update customer set password=? where userId=?";
		try {
			int i = this.db.update(sql, newPass,userId);
			return i>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			this.db.closed();
		}
		return false;
	}

	public List<Customer> findCust() {
		db = new DBUtil();
		String sql = "select  a.*,v.cardid,v.balance,v.lev,v.state,d.dis from customer a,viptable v,dis d where  a.userid=v.userid(+) and v.lev=d.lev(+)";
		List<Customer> list = new ArrayList<Customer>();
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				Customer c = new Customer(rs.getInt("userId"), rs.getString("userName"), rs.getString("account"), rs.getString("password"), rs.getInt("userstate"), new Vip(rs.getInt("cardId"), rs.getInt("lev"), rs.getDouble("balance"), rs.getInt("State"),rs.getDouble("dis")));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.db.closed();
		}
		return null;
	}

	public Customer findCustById(int userId) {
		List<Customer> list = this.findCust();
		for (Customer c : list) {
			if(c.getUserId() == userId){
				return c;
			}
		}
		return null;
	}

	public boolean beVip(int userId, int lv) {
		Customer c = this.findCustById(userId);
		String sql = "select * from vipTable where userId="+userId;
		try {
			db = new DBUtil();
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				if(c.getV().getLev()>=lv){
					return false;
				}
				String sql2 = "update vipTable set lev=? where userid=?";
				int i = this.db.update(sql2,lv,userId);
				return i>0;
			}else{
				String sql3 = "insert into viptable(cardId,userId,lev) values(seq_cardid.nextval,?,?)";
				int i = this.db.update(sql3, userId,lv);
				return i>0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.db.closed();
		} 
		return false;
	}

	public boolean topUp(int userId, double money) {
		
		Calendar cale = Calendar.getInstance(); 
		int day = cale.get(Calendar.DATE); 
		Customer c = this.findCustById(userId);
		double newMoney;
		if(day == 22 && money>200){
			newMoney=c.getV().getBalance()+money+50;
		}else{
			newMoney=c.getV().getBalance()+money;
		}
		db = new DBUtil();
		String sql ="update viptable set balance=? where userId=?";
		try {
			int i = this.db.update(sql, newMoney,userId);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.db.closed();
		} 
		return false;
	}

	public Po settle(Customer c, Map<Food,Integer> m,double getMoney) {
		String uuId = UUID.randomUUID().toString().replaceAll("-", "");
		Po p = new Po(uuId, c.getV().getCardId(), getMoney, m);
		try {
			String sql = "insert into Po(uuid,oTime,cardId,getMoney) values(?,to_date(?,'yyyy-mm-dd HH24:MI:SS'),?,?)";
			this.db.update(sql, uuId,c.getV().getCardId(),p.getGetMoney());
			String sql1 = "insert into volumn(uuid,fid,num) values(?,?,?)";
			Set<Food> s = m.keySet();
			for (Food f : s) {
				this.db.update(sql1, p.getUuId(),f.getfId(),m.get(f));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}
