package view;

import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Owner;
import model.OwnerBag;

public class LoginView {

	private Label userName;
	private Label password;
	private TextField userNameText;
	private PasswordField passwordText;
	private Button loginButton;
	private HBox pane;
	
	private OwnerView ownerView;

	// private LoginEventListener loginBtnListener;

	public LoginView(Stage stage) {
		userName = new Label("User Name: ");
		userName.setAlignment(Pos.CENTER_LEFT);
		password = new Label("Password: ");
		password.setAlignment(Pos.CENTER_LEFT);
		loginButton = new Button("Login");
		userNameText = new TextField();
		passwordText = new PasswordField();
		pane = new HBox(30);
		HBox.setMargin(userName, new Insets(30, 0, 0, 0));
		pane.setAlignment(Pos.BASELINE_CENTER);
		pane.getChildren().addAll(userName, userNameText, password, passwordText, loginButton);

		loginButton.setOnAction(event -> {

			OwnerBag o = new OwnerBag(22);

			try {
				o.importData("Data/Owner.txt");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			Owner o1 = o.findByFirstName("John");
			Owner o2 = o.findByFirstName("Jane");
			Owner o3 = o.findByFirstName("Bill");
			
			if (userNameText.getText().equals(o1.getUserName()) && passwordText.getText().equals(o1.getPassword())) {

				ownerView = new OwnerView(stage);
				
			}else if (userNameText.getText().equals(o2.getUserName()) && passwordText.getText().equals(o2.getPassword())) {

				System.out.println("pass");

			}else if (userNameText.getText().equals(o3.getUserName()) && passwordText.getText().equals(o3.getPassword())) {

				System.out.println("pass");

			} else {
				System.out.println("fail");
			}
			// userNameText.setText("");
			passwordText.setText("");

		});

		stage.setScene(new Scene(pane, 620, 100));
		stage.show();

	}

}
