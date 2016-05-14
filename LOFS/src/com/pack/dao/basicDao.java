package com.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pack.entity.Basic;
import com.pack.entity.Choose;
import com.pack.util.DBUtil;


public class basicDao {
	public void save(Basic basic)throws Exception{
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
				"insert into t_basic(stature,education,marriage,salary" +
				",province,city,house,car,userId) values(?,?,?,?,?,?,?,?,?)");
		stmt.setString(1, basic.getStature());
		stmt.setString(2, basic.getEducation());
		stmt.setString(3, basic.getMarriage());
		stmt.setString(4, basic.getSalary());
		stmt.setString(5, basic.getProvince());
		stmt.setString(6, basic.getCity());
		stmt.setString(7, basic.getHouse());
		stmt.setString(8, basic.getCar());
		stmt.setLong(9, basic.getUserId());
		stmt.executeUpdate();
		DBUtil.close(conn);
	}
	public Basic findByUserId(long userId)throws Exception{
		Basic basic=null;
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
				"select * from t_basic where userId=?");
		stmt.setLong(1, userId);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			basic=new Basic();
			basic.setId(rs.getLong("id"));
			basic.setStature(rs.getString("stature"));
			basic.setCity(rs.getString("city"));
			basic.setCar(rs.getString("car"));
			basic.setHouse(rs.getString("house"));
			basic.setSalary(rs.getString("salary"));
			basic.setProvince(rs.getString("province"));
			basic.setEducation(rs.getString("education"));
			basic.setMarriage(rs.getString("marriage"));
			basic.setUserId(userId);
		}
		DBUtil.close(conn);
		return basic;
	}
	public void update(long userId,String stature,String education,
			String marriage,String salary,String province,String city,
			String house,String car)throws Exception{
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
			"update t_basic set stature=?,education=?,marriage=?,salary=?," +
			"province=?,city=?,house=?,car=? where userId=?");
		stmt.setString(1, stature);
		stmt.setString(2, education);
		stmt.setString(3, marriage);
		stmt.setString(4, salary);
		stmt.setString(5, province);
		stmt.setString(6, city);
		stmt.setString(7, house);
		stmt.setString(8, car);
		stmt.setLong(9, userId);
		stmt.executeUpdate();
		DBUtil.close(conn);
	}
}
