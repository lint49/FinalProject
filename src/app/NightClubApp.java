package app;

import javafx.application.Application;
import javafx.stage.Stage;
import view.LoginView;

public class NightClubApp extends Application {
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		 LoginView view = new LoginView(primaryStage);
		 
	}

}
