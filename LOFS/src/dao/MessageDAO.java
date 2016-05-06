package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Message;

public class MessageDAO {
	public void saveMessage(Message msg) throws Exception{
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep = 
			conn.prepareStatement(
					"insert into t_message(sendId,sendName,receiverId,content,status) " +
					"values(?,?,?,?,?)");
		prep.setLong(1, msg.getSendId());
		prep.setString(2, msg.getSendName());
		prep.setLong(3, msg.getReceiverId());
		prep.setString(4, msg.getContent());
		prep.setInt(5, msg.getState());
		prep.executeUpdate();
		DBUtil.close(conn);
	}
	
	public List<Message> find(long id) throws Exception{
		List<Message> msgs = 
			new ArrayList<Message>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep = 
			conn.prepareStatement("select * from t_message where receiverId=? and status=1");
		prep.setLong(1, id);
		ResultSet rst = prep.executeQuery();
		while(rst.next()){
			Message msg = new Message();
			msg.setContent(rst.getString("content"));
			msg.setId(rst.getLong("id"));
			msg.setSendId(rst.getLong("sendId"));
			msg.setSendName(rst.getString("sendName"));
			msg.setReceiverId(id);
			msg.setState(rst.getInt("status"));
			msgs.add(msg);
		}
		
		DBUtil.close(conn);
		return msgs;
	}
	
	public void update(long id) throws Exception{
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep = 
			conn.prepareStatement("update t_message set status=0 where receiverId=?");
		prep.setLong(1, id);
		prep.executeUpdate();
		DBUtil.close(conn);
	}
}
