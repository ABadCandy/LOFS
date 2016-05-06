package entity;
/*id bigint primary key auto_increment,
note text,
userId bigint*/
public class Note {
	private long id;
	private String text;
	private long userId;
	public Note() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
