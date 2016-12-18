package model;

import java.util.EventListener;

public interface WorkerEventListener extends EventListener {
	
	public void workerBtnClicked(WorkerEventObject ev);

}
