package model;

import java.util.EventListener;

public interface LoginEventListener extends EventListener {
	
	public void loginBtnClicked(LoginEventObject ev);

}
