package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;
import entity.Note;

public class noteDao {
	public void save(Note note)throws Exception{
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
				"insert into t_note(note,userId) values(?,?)");
		stmt.setString(1, note.getText());
		stmt.setLong(2, note.getUserId());
		stmt.executeUpdate();
		DBUtil.close(conn);
	}
	public Note findByUserId(long userId)throws Exception{
		Note note=null;
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
				"select * from t_note where userId=?");
		stmt.setLong(1, userId);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			note=new Note();
			note.setId(rs.getLong("id"));
			note.setText(rs.getString("note"));
			note.setUserId(userId);
		}
		DBUtil.close(conn);
		return note;
	}
	public void updateByUserId(long id,String text)throws Exception{
		Connection conn=DBUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(
				"update t_note set note=? where userId=?");
		stmt.setString(1, text);
		stmt.setLong(2, id);
		stmt.executeUpdate();
		DBUtil.close(conn);
	}
}
