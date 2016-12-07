package controllers;

import model.Manager;
import model.ManagerBag;
import model.ManagerEventListener;
import model.ManagerEventObject;
import view.OwnerView;

public class ManagerController {

	public ManagerController(Manager model, OwnerView view) {
		view.setManagerBtnListener(new ManagerEventListener() {

			ManagerBag m = new ManagerBag(100);

			@Override
			public void managerBtnClicked(ManagerEventObject ev) {

				model.setFirstName(ev.getFirstName());
				model.setLastName(ev.getLastName());
				model.setStNum(ev.getStNum());
				model.setStName(ev.getStName());
				model.setCity(ev.getCity());
				model.setState(ev.getState());
				model.setZip(ev.getZip());
				model.setPhone(ev.getPhone());
				model.setSalary(ev.getSalary());
				model.setShiftStart(ev.getShiftStart());
				model.setShiftEnd(ev.getShiftEnd());

				System.out.println(model);

				if (ev.getFirstName() != null) {
					view.comboNames(model.getFirstName());
				}

				m.add(model);
				m.saveManager();

			}

			@Override
			public void findBtnClicked(ManagerEventObject ev) {

				m.findByFirstName(view.getName());
				view.setManagerFName(model.getFirstName());
				view.setManagerLName(model.getLastName());
				view.setManagerStNum(model.getStNum());
				view.setManagerStName(model.getStName());
				view.setManagerCity(model.getCity());
				view.setManagerState(model.getState());
				view.setManagerZip(model.getZip());
				view.setManagerPhone(model.getPhone());
				view.setManagerPay(model.getSalary());
				view.setManagerStart(model.getShiftStart());
				view.setManagerEnd(model.getShiftEnd());

			}

		});
	}

}
