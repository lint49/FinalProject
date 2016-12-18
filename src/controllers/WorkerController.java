package controllers;

import model.Worker;
import model.WorkerBag;
import model.WorkerEventListener;
import model.WorkerEventObject;
import view.ManagerView;

public class WorkerController {
	
	public WorkerController(Worker model, ManagerView view){
		
		view.setWorkerBtnListener(new WorkerEventListener() {
			
			WorkerBag w = new WorkerBag(100);

			@Override
			public void workerBtnClicked(WorkerEventObject ev) {
				
				model.setFirstName(ev.getFirstName());
				model.setLastName(ev.getLastName());
				model.setStNum(ev.getStNum());
				model.setStName(ev.getStName());
				model.setCity(ev.getCity());
				model.setState(ev.getState());
				model.setZip(ev.getZip());
				model.setPhone(ev.getPhone());
				model.setWorkerPay(ev.getWorkerPay());
				model.setTitle(ev.getTitle());
				model.setDateStart(ev.getDateStart());

				System.out.println(model);
				
				w.add(model);
				w.saveWorker();
			}
			
		});
		
	}

}
