package model;

import java.util.EventListener;

public interface TicketEventListener extends EventListener {
	
	public void ticketBtnClicked(TicketEventObject ev);

}
