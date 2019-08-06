package com.chen.pojo;

/**
 * 
 * @author chenguoji
 *
 */
public class UserInfo {

	private String username;// 用户名
	private String password;// 密码
	private String pName;// 中文名
	private String region;// 地址
	private int authority;// 状态（1，总店，其他分店）

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

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

}
