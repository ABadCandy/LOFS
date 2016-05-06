package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;
import entity.Choose;
import entity.Note;

public class chooseDao {
	public void save(Choose choose)throws Exception{
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
				"insert into t_choose(stature,education,marriage,province,city,userId)"
				+" values(?,?,?,?,?,?)");
		stmt.setString(1, choose.getStature());
		stmt.setString(2, choose.getEducation());
		stmt.setString(3, choose.getMarriage());
		stmt.setString(4,choose.getProvince());
		stmt.setString(5, choose.getCity());
		stmt.setLong(6, choose.getUserId());
		stmt.executeUpdate();
		DBUtil.close(conn);
	}
	public Choose findByUserId(long userId)throws Exception{
		Choose choose=null;
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
				"select * from t_choose where userId=?");
		stmt.setLong(1, userId);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			choose=new Choose();
			choose.setId(rs.getLong("id"));
			choose.setStature(rs.getString("stature"));
			choose.setCity(rs.getString("city"));
			choose.setProvince(rs.getString("province"));
			choose.setEducation(rs.getString("education"));
			choose.setMarriage(rs.getString("marriage"));
			choose.setUserId(userId);
		}
		DBUtil.close(conn);
		return choose;
	}
	public void update(long userId,String stature,String education,
			String marriage,String province,String city
		)throws Exception{
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
			"update t_choose set stature=?,education=?,marriage=?," +
			"province=?,city=? where userId=?");
		stmt.setString(1, stature);
		stmt.setString(2, education);
		stmt.setString(3, marriage);
		stmt.setString(4, province);
		stmt.setString(5, city);
		stmt.setLong(6, userId);
		stmt.executeUpdate();
		DBUtil.close(conn);
	}
}
