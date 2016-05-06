package entity;

public class User {
	private long id;
	private String username;
	private String password;
	private String name;
	private String gendar;
	private int age;
	private String phone;
	public User() {
		super();
	}
	public User(String username, String password, String name, String gendar,
			int age, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.gendar = gendar;
		this.age = age;
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGendar() {
		return gendar;
	}
	public void setGendar(String gendar) {
		this.gendar = gendar;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
