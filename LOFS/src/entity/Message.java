package entity;

public class Message {
	private long id;
	private long sendId;
	private String sendName;
	private long receiverId;
	private String content;
	private int state;
	
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
	public void setContent(String content) {
		this.content = content;
	}
	public long getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}
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
