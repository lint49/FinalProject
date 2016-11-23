package view;

import controllers.TicketController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Ticket;

public class Demo extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// LoginView view = new LoginView(primaryStage);
		OwnerView view = new OwnerView(primaryStage);
		// ManagerView view = new ManagerView(primaryStage);

		Ticket model = new Ticket();
		TicketController controller = new TicketController(model, view);

	}

}
