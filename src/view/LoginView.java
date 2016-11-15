package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginView {

	private Label userName;
	private Label password;
	private TextField userNameText;
	private PasswordField passwordText;
	private Button loginButton;
	private HBox topPane;
	private HBox bottomPane;
	private VBox pane;
	private Label error;
	private OwnerView ownerView;
	private ManagerView managerView;

	public LoginView(Stage stage) {
		userName = new Label("User Name:");
		userName.setAlignment(Pos.CENTER_LEFT);

		password = new Label("Password:");
		password.setAlignment(Pos.CENTER_LEFT);

		loginButton = new Button("Login");

		userNameText = new TextField();
		passwordText = new PasswordField();

		topPane = new HBox(5);
		bottomPane = new HBox(5);

		HBox.setMargin(userName, new Insets(30, 0, 0, 0));
		topPane.setAlignment(Pos.BASELINE_CENTER);
		topPane.getChildren().addAll(userName, userNameText);

		bottomPane.setAlignment(Pos.BASELINE_CENTER);
		bottomPane.getChildren().addAll(password, passwordText);

		loginButton.setOnAction(event -> {

			if (userNameText.getText().equals("admin") && passwordText.getText().equals("0")) {

				System.out.println("pass");

			} else if (userNameText.getText().equals("owner") && passwordText.getText().equals("1")) {

				ownerView = new OwnerView(stage);

			} else if (userNameText.getText().equals("manager") && passwordText.getText().equals("2")) {

				managerView = new ManagerView(stage);

			} else if (userNameText.getText().equals("customer") && passwordText.getText().equals("3")) {

				System.out.println("pass");

			} else {
				error.setTextFill(Color.web("#ff0000"));
				error.setText("(Wrong username or password)");
			}

			userNameText.setText("");
			passwordText.setText("");

		});

		error = new Label("");

		pane = new VBox(30);
		pane.setAlignment(Pos.BASELINE_CENTER);
		pane.getChildren().addAll(topPane, bottomPane, loginButton, error);
		stage.setTitle("Night Club Login");
		stage.setScene(new Scene(pane, 300, 230));
		stage.show();

	}

}
