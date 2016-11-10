package model;

import java.util.EventObject;

public class LoginEventObject extends EventObject {
	
	private String userName;
	private String password;
	
	public LoginEventObject(Object source) {
		super(source);
	}
	
	public LoginEventObject(Object source, String userName, String password) {
		super(source);
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

}
