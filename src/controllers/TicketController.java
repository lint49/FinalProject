package controllers;

import java.io.IOException;

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

				model.setName(ev.getName());
				model.setDate(ev.getDate());
				model.setPrice(ev.getPrice());

				TicketBag t = new TicketBag(22);
				t.add(model);
				t.saveTicket();
				
				try {
					t.load();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(model);
				
				view.comboTicket(model.getName() +" -" + model.getDate() + " \n$" + model.getPrice());
				
				
				
				
			}

		});

	}

}
