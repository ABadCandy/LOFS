package com.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.pack.entity.User;
import com.pack.util.DBUtil;


public class userDao {
	public User findByName(String username)throws Exception{
		User user=null;
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
			"select * from t_user where username=?");
		stmt.setString(1, username);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			user=new User();
			user.setId(rs.getLong("id"));
			user.setAge(rs.getInt("age"));
			user.setGendar(rs.getString("gendar"));
			user.setName(rs.getString("name"));
			user.setPhone(rs.getString("phone"));
			user.setPassword(rs.getString("password"));
			user.setUsername(username);
		}
		DBUtil.close(conn);
		return user;
	}
	public long save(User user)throws Exception{
		long id=-1;
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
				"insert into t_user(username,name,password,age,gendar,phone)"
				+" values(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getName());
		stmt.setString(3, user.getPassword());
		stmt.setInt(4,user.getAge());
		stmt.setString(5, user.getGendar());
		stmt.setString(6, user.getPhone());
		stmt.executeUpdate();
		ResultSet rs=stmt.getGeneratedKeys();
		while(rs.next()){
			id=rs.getLong(1);
		}
		DBUtil.close(conn);
		return id;
	}
	public List<User> findAll()throws Exception{
		List<User> users=new ArrayList<User>();
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
				"select * from t_user");
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			User user=new User();
			user.setId(rs.getLong("id"));
			user.setAge(rs.getInt("age"));
			user.setGendar(rs.getString("gendar"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setUsername(rs.getString("username"));
			user.setPhone(rs.getString("phone"));
			users.add(user);
		}
		DBUtil.close(conn);
		return users;
	}
	public User findById(long id)throws Exception{
		User user=null;
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
			"select * from t_user where id=?");
		stmt.setLong(1, id);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			user=new User();
			user.setId(rs.getLong("id"));
			user.setAge(rs.getInt("age"));
			user.setGendar(rs.getString("gendar"));
			user.setName(rs.getString("name"));
			user.setPhone(rs.getString("phone"));
			user.setPassword(rs.getString("password"));
			user.setUsername(rs.getString("username"));
		}
		DBUtil.close(conn);
		return user;
	}
	public void update(long id,String name,String phone)throws Exception{
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
				"update t_user set name=?,phone=? where id=?");
		stmt.setString(1, name);
		stmt.setString(2, phone);
		stmt.setLong(3, id);
		stmt.executeUpdate();
		DBUtil.close(conn);
	}
}
