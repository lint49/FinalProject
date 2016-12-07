package model;

import java.util.EventListener;

public interface ManagerEventListener extends EventListener {
	
	public void managerBtnClicked(ManagerEventObject ev);
	public void findBtnClicked(ManagerEventObject ev);

}
