package entity;
/*
 * id bigint primary key auto_increment,
picName varchar(100),
userId bigint*/
public class Pic {
	private long id;
	private String picName;
	private long userId;
	public Pic() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
