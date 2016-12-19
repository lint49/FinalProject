package view;

import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class RegisterView {

	private LoginView login;
	private Stage stage;
	private VBox pane;
	private Button esc;

	private Button registerBtn;

	private Label nameLbl;
	private Label sexLbl;
	private Label ageLbl;
	private Label userLbl;
	private Label userNamePassWordLbl;
	private TextField nameField = new TextField();
	private TextField ageField = new TextField();

	ComboBox<String> sex;
	ComboBox<String> user;

	public RegisterView(Stage stage) {

		this.stage = stage;

		Label nameLbl = new Label("Name: ");
		Label sexLbl = new Label("Sex: ");
		Label ageLbl = new Label("Age: ");
		Label userLbl = new Label("User: ");
		Label userNamePassWordLbl = new Label("");

		sex = new ComboBox<>();
		sex.getItems().addAll("", "Female", "Male");

		user = new ComboBox<>();
		user.getItems().addAll("Customer", "Manager", "Owner");

		nameField.setMaxWidth(100);
		ageField.setMaxWidth(100);
		ageField.setPromptText("Not Required");

		sex.setMaxWidth(100);

		registerBtn = new Button("Register");

		esc = new Button("Exit");
		esc.setOnAction(event -> {
			login = new LoginView(stage);
		});
		
		esc.setStyle("-fx-font: 20 arial; -fx-base: #ff4d4d;");
		
		registerBtn.setOnAction(event -> {
			
			if (nameField == null || nameField.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Name");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("Name field Is Empty");
				dialog.setContentText("Please enter the name: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					nameField.setText(result.get());
				}
			}

			if (user.getValue() == "Customer") {
				userNamePassWordLbl.setText("User Name: customer \nPassword: 3");
			} else if (user.getValue() == "Manager") {
				userNamePassWordLbl.setText("User Name: manager \nPassword: 2");
			} else if (user.getValue() == "Owner") {
				userNamePassWordLbl.setText("User Name: owner \nPassword: 1");
			}
		});

		registerBtn.setStyle("-fx-font: 12 arial; -fx-base: #66c2ff;");
		
		Label welcome = new Label("Welcome");
		welcome.setTextFill(Color.web("#809fff"));
		welcome.setStyle("-fx-font-family: Courgette; -fx-font-size: 50;");

		BackgroundImage myBI = new BackgroundImage(new Image("file:src/background.png", 65, 65, false, true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		pane = new VBox(5);
		pane.setMargin(welcome, new Insets(20, 0, 0, 65));
		pane.setMargin(userLbl, new Insets(0, 0, 0, 100));
		pane.setMargin(user, new Insets(0, 0, 0, 100));
		pane.setMargin(nameLbl, new Insets(0, 0, 0, 100));
		pane.setMargin(sexLbl, new Insets(0, 0, 0, 100));
		pane.setMargin(ageLbl, new Insets(0, 0, 0, 100));
		pane.setMargin(nameField, new Insets(0, 0, 0, 100));
		pane.setMargin(sex, new Insets(0, 0, 0, 100));
		pane.setMargin(ageField, new Insets(0, 0, 0, 100));
		pane.setMargin(esc, new Insets(10, 0, 0, 115));
		pane.setMargin(registerBtn, new Insets(5, 0, 0, 115));
		pane.setMargin(userNamePassWordLbl, new Insets(5, 0, 0, 100));

		userNamePassWordLbl.setTextFill(Color.web("#ff0000"));

		pane.getStylesheets().add("http://fonts.googleapis.com/css?family=Courgette");

		pane.getChildren().addAll(welcome, userLbl, user, nameLbl, nameField, sexLbl, sex, ageLbl, ageField,
				registerBtn, userNamePassWordLbl, esc);
		pane.setBackground(new Background(myBI));
		stage.setScene(new Scene(pane, 300, 450));
		stage.setTitle("Register");
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
		stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
		stage.show();

	}

}
