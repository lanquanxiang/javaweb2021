package cn.pzhu.pojo;

public class User {
	private String username;
	private String password;
	private Integer status;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, Integer status) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
