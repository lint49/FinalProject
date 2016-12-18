package view;

import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CustomerView {

	private LoginView login;
	private Stage stage;
	private VBox pane;
	private VBox pane2;
	private HBox cardPane;
	private HBox mainPane;
	private HBox phonePane;

	Label total;
	Label cards;
	TextField t1 = new TextField();
	TextField t2 = new TextField();
	TextField t3 = new TextField();
	TextField t4 = new TextField();
	Button calBtn;
	private Button esc;

	public CustomerView(Stage stage) {
		this.stage = stage;

		total = new Label("Your Total: ");
		total.setFont(new Font("Arial", 15));

		Label lb = new Label("Price Estimator");
		lb.setFont(new Font("Arial", 30));

		CheckBox b1 = new CheckBox("Beer -- $2.50");
		CheckBox b2 = new CheckBox("Table w/2seats -- $18.00");
		CheckBox b3 = new CheckBox("Table w/6seats -- $40.00");
		CheckBox b4 = new CheckBox("Table w/12seats -- $70.00");

		t1.setMaxWidth(150);
		t1.setPromptText("Enter Quantity");
		t2.setMaxWidth(150);
		t2.setPromptText("Enter Quantity- Max=10");
		t3.setMaxWidth(150);
		t3.setPromptText("Enter Quantity- Max=8");
		t4.setMaxWidth(150);
		t4.setPromptText("Enter Quantity- Max=6");

		calBtn = new Button("Calculate");
		calBtn.setOnAction(event -> {

			if (b1.isSelected() && t1.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Enter Quantity");
				dialog.setTitle("Beer");
				dialog.setHeaderText("Enter Quantity | (Numeric Only)");
				dialog.setContentText("Please enter the number of beer(s): ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					t1.setText(result.get());
				}
			}

			if (b2.isSelected() && t2.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Enter Quantity");
				dialog.setTitle("2-seats Table");
				dialog.setHeaderText("Enter Quantity | (Numeric Only)");
				dialog.setContentText("Please enter the number of 2-seats Table: \nMax = 10");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					t2.setText(result.get());
				}
			}

			if (b3.isSelected() && t3.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Enter Quantity");
				dialog.setTitle("6-seats Table");
				dialog.setHeaderText("Enter Quantity | (Numeric Only)");
				dialog.setContentText("Please enter the number of 6-seats Table: \nMax = 8");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					t3.setText(result.get());
				}
			}

			if (b4.isSelected() && t4.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Enter Quantity");
				dialog.setTitle("12-seats Table");
				dialog.setHeaderText("Enter Quantity | (Numeric Only)");
				dialog.setContentText("Please enter the number of 12-seats Table: \nMax = 6");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					t4.setText(result.get());
				}
			}

			calculate(b1, b2, b3, b4);

		});

		esc = new Button("Exit");
		esc.setOnAction(event -> {
			login = new LoginView(stage);
		});

		final ImageView selectedImage1 = new ImageView();
		Image image1 = new Image("file:src/ae.png", 40, 40, true, true);
		selectedImage1.setImage(image1);

		final ImageView selectedImage2 = new ImageView();
		Image image2 = new Image("file:src/master.png", 40, 40, true, true);
		selectedImage2.setImage(image2);

		final ImageView selectedImage3 = new ImageView();
		Image image3 = new Image("file:src/visa.png", 40, 40, true, true);
		selectedImage3.setImage(image3);

		final ImageView selectedImage4 = new ImageView();
		Image image4 = new Image("file:src/discover.png", 40, 40, true, true);
		selectedImage4.setImage(image4);

		final ImageView selectedImage5 = new ImageView();
		Image image5 = new Image("file:src/phone.png", 40, 40, true, true);
		selectedImage5.setImage(image5);

		cards = new Label("(All Major Cards Accepted)");
		pane2.setMargin(cards, new Insets(0, 0, 0, 95));

		pane = new VBox(10);
		pane.getChildren().addAll(lb, b1, t1, b2, t2, b3, t3, b4, t4, calBtn, total, esc);
		pane.setPadding(new Insets(50, 50, 50, 100));

		Label nightClub = new Label("Night\nClub");

		pane2.setMargin(nightClub, new Insets(50, 0, 0, 95));
		

		pane2 = new VBox(10);

		Label phoneLabel = new Label("(000)-000-0000 for any questions");
		phonePane.setMargin(phoneLabel, new Insets(20, 0, 0, 0));
		phonePane.setMargin(selectedImage5, new Insets(0, 0, 0, 50));
		
		phonePane = new HBox(5);
		phonePane.getChildren().addAll(selectedImage5, phoneLabel);

		cardPane = new HBox(5);
		cardPane.getChildren().addAll(selectedImage1, selectedImage2, selectedImage3, selectedImage4);
		cardPane.setPadding(new Insets(20, 0, 0, 80));

		pane2.getChildren().addAll(nightClub, phonePane, cardPane, cards);

		nightClub.setStyle("-fx-font-family: Courgette; -fx-font-size: 80;");

		pane2.getStylesheets().add("http://fonts.googleapis.com/css?family=Courgette");

		mainPane = new HBox(10);
		mainPane.getChildren().addAll(pane2, pane);
		stage.setScene(new Scene(mainPane, 800, 600));
		stage.setTitle("Customer's View");
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
		stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
		stage.show();
	}

	private void calculate(CheckBox b1, CheckBox b2, CheckBox b3, CheckBox b4) {
		double n = 0.00;

		if (b1.isSelected())
			try {
				double num = Double.parseDouble(t1.getText());
				n += num * 2.5;
			} catch (Exception ex) {

			}
		;

		if (b2.isSelected())
			try {
				double num = Double.parseDouble(t2.getText());
				n += num * 18;
			} catch (Exception ex) {

			}
		;

		if (b3.isSelected())
			try {
				double num = Double.parseDouble(t3.getText());
				n += num * 40;
			} catch (Exception ex) {

			}
		;

		if (b4.isSelected())
			try {
				double num = Double.parseDouble(t4.getText());
				n += num * 70;
			} catch (Exception ex) {

			}
		;
		double tax = n * .08625;

		double totals = n + tax;
		System.out.println("Your Total is: $" + n + "\nTax=" + tax + "\nTotal=" + totals);
		total.setText("Subtotal: ............" + String.format("$%.2f", n) + "\nTax (8.625%): ...."
				+ String.format("$%.2f", tax) + "\nTotal: .................." + String.format("$%.2f", totals));

	}

}
