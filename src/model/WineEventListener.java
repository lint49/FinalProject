package model;

import java.util.EventListener;

public interface WineEventListener extends EventListener {
	
	public void wineBtnClicked(WineEventObject ev);

}
