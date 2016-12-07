package controllers;

import model.Wine;
import model.WineBag;
import model.WineEventListener;
import model.WineEventObject;
import view.OwnerView;

public class WineController {

	public WineController(Wine model, OwnerView view) {

		view.setWineBtnListener(new WineEventListener() {

			@Override
			public void wineBtnClicked(WineEventObject ev) {
				
				WineBag w = new WineBag(100);
				model.setWineName(ev.getWineName());
				model.setWineType(ev.getWineType());
				model.setRegion(ev.getRegion());
				model.setAlcoholPercentage(ev.getAlcoholPercentage());
				model.setPrice(ev.getPrice());
				
				System.out.println(model);
				
				if(ev.getWineName() != null ){
					view.comboWine(model.getWineName());
				}
				
				w.add(model);
				w.saveWine();

			}

		});
	}

}
