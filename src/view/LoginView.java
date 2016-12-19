package view;

import controllers.ManagerController;
import controllers.TicketController;
import controllers.WineController;
import controllers.WorkerController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Manager;
import model.Ticket;
import model.Wine;
import model.Worker;

public class LoginView {

	private Label userName;
	private Label password;
	private TextField userNameText;
	private PasswordField passwordText;
	private Button loginButton;
	private Button registerBtn;
	private HBox topPane;
	private HBox bottomPane;
	private HBox loginRegPane;
	private VBox pane;
	private Label error;
	private OwnerView ownerView;
	private ManagerView managerView;
	private CustomerView customerView;
	private RegisterView registerView;

	public LoginView(Stage stage) {

		userName = new Label("User Name:");
		userName.setAlignment(Pos.CENTER_LEFT);

		password = new Label("Password:");
		password.setAlignment(Pos.CENTER_LEFT);

		loginButton = new Button("Login");
		registerBtn = new Button("Register");

		userNameText = new TextField();
		passwordText = new PasswordField();

		topPane = new HBox(5);
		bottomPane = new HBox(5);
		loginRegPane = new HBox(10);
		
		loginRegPane.setAlignment(Pos.BASELINE_CENTER);
		loginRegPane.getChildren().addAll(loginButton, registerBtn);

		topPane.setAlignment(Pos.BASELINE_CENTER);
		topPane.getChildren().addAll(userName, userNameText);

		bottomPane.setAlignment(Pos.BASELINE_CENTER);
		bottomPane.getChildren().addAll(password, passwordText);

		loginButton.setDefaultButton(true);

		loginButton.setOnAction(event -> {

			if (userNameText.getText().equals("admin") && passwordText.getText().equals("0")) {

				System.out.println("pass");

			} else if (userNameText.getText().equals("owner") && passwordText.getText().equals("1")) {

				ownerView = new OwnerView(stage);

				Ticket model = new Ticket();
				TicketController controller = new TicketController(model, ownerView);

				Wine model2 = new Wine();
				WineController controller2 = new WineController(model2, ownerView);
				
				Manager model3 = new Manager();
				ManagerController controller3 = new ManagerController(model3, ownerView);

			} else if (userNameText.getText().equals("manager") && passwordText.getText().equals("2")) {

				managerView = new ManagerView(stage);
				
				Worker model = new Worker();
				WorkerController controller4 = new WorkerController(model, managerView);

			} else if (userNameText.getText().equals("customer") && passwordText.getText().equals("3")) {

				customerView = new CustomerView(stage);

			} else {
				error.setTextFill(Color.web("#ff0000"));
				error.setText("(Wrong username or password)");
			}

			userNameText.setText("");
			passwordText.setText("");

		});
		
		registerBtn.setOnAction(event -> {
			
			registerView = new RegisterView(stage);
					
		});

		registerBtn.setStyle("-fx-font: 12 arial; -fx-base: #66c2ff;");

		error = new Label("");

		BackgroundImage myBI = new BackgroundImage(new Image("file:src/background.png", 65, 65, false, true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		Label welcome = new Label("Welcome");
		welcome.setTextFill(Color.web("#809fff"));
		welcome.setStyle("-fx-font-family: Courgette; -fx-font-size: 50;");
		
		pane = new VBox(30);
		pane.getStylesheets().add("http://fonts.googleapis.com/css?family=Courgette");
		pane.setBackground(new Background(myBI));
		pane.setAlignment(Pos.BASELINE_CENTER);
		pane.getChildren().addAll(welcome,topPane, bottomPane, loginRegPane, error);
		stage.setTitle("Night Club Login");
		stage.setScene(new Scene(pane, 330, 300));
		stage.show();
		
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);

	}

}
