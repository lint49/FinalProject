package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Demo extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// LoginView view = new LoginView(primaryStage);
		// OwnerView view = new OwnerView(primaryStage);
		// ManagerView view3 = new ManagerView(primaryStage);
		 CustomerView view3 = new CustomerView(primaryStage);
	}

}
