package controllers;

import model.Ticket;
import model.TicketBag;
import model.TicketEventListener;
import model.TicketEventObject;
import view.OwnerView;

public class TicketController {

	public TicketController(Ticket model, OwnerView view) {

		view.setTicketBtnListener(new TicketEventListener() {

			@Override
			public void ticketBtnClicked(TicketEventObject ev) {

				TicketBag t = new TicketBag(100);
				model.setName(ev.getName());
				model.setDate(ev.getDate());
				model.setPrice(ev.getPrice());

				System.out.println(model);
				if (ev.getName() != null) {
					view.comboTicket(model.getName());
				}

				t.add(model);
				t.saveTicket();
			}

		});

	}

}
