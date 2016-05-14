package com.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pack.entity.Message;
import com.pack.util.DBUtil;

/**
 * MessageDAO类
 * 该类主要实现从MySQL数据库中提取用户信息
 * @author tanghao
 *@date:日期:2016-3-26时间:下午2:44:52
 *@version 1.0
 */
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
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
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
	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void update(long id) throws Exception{
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep = 
			conn.prepareStatement("update t_message set status=0 where receiverId=?");
		prep.setLong(1, id);
		prep.executeUpdate();
		DBUtil.close(conn);
	}
}
