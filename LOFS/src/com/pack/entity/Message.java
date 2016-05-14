package com.pack.entity;
/**
 * Message类
 * 里面有id,sendId，sendName等属性及构造函数、方法等
 * @author tanghao
 *@date:日期:2016-3-26时间:下午2:41:35
 *@version 1.0
 */
public class Message {
	private long id;
	private long sendId;
	private String sendName;
	private long receiverId;
	private String content;
	private int state;
	/**
	 * 
	 * @param sendId
	 * @param sendName
	 * @param receiverId
	 * @param content
	 * @param state
	 */
	public Message(long sendId, String sendName, long receiverId, String content, int state) {
		super();
		this.sendId = sendId;
		this.sendName = sendName;
		this.receiverId = receiverId;
		this.content = content;
		this.state = state;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getContent() {
		return content;
	}
	/**
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	public long getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}
	/**
	 * 
	 * @return
	 */
	public long getSendId() {
		return sendId;
	}
	public void setSendId(long sendId) {
		this.sendId = sendId;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
}
