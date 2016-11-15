package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagerView {
	private LoginView login;
	// for adding -- worker
	private Label workerFNameLbl;
	private TextField workerFNameField;
	private Label workerLNameLbl;
	private TextField workerLNameField;
	private Label workerStNumLbl;
	private TextField workerStNumField;
	private Label workerStLbl;
	private TextField workerStField;
	private Label workerCityLbl;
	private TextField workerCityField;
	private Label workerStateLbl;
	private TextField workerStateField;
	private Label workerZipLbl;
	private TextField workerZipField;
	private Label workerPhoneLbl;
	private TextField workerPhoneField;
	private Label workerPayLbl;
	private TextField workerPayField;
	private Label workerStartLbl;
	private TextField workerStartField;
	private Label workerEndLbl;
	private TextField workerEndField;
	private Label workerTitleLbl;
	private TextField workerTitleField;

	private Button workerBtn;
	
	// button to exit to login
	private Button esc;
	
	private VBox leftPane;
	private HBox pane;

	private Stage stage;

	public ManagerView(Stage stage) {
		this.stage = stage;

		workerFNameLbl = new Label("First Name: ");
		workerFNameLbl.setAlignment(Pos.CENTER_RIGHT);
		workerLNameLbl = new Label("Last Name: ");
		workerLNameLbl.setAlignment(Pos.CENTER_RIGHT);
		workerStNumLbl = new Label("Street Number: ");
		workerStNumLbl.setAlignment(Pos.CENTER_RIGHT);
		workerStLbl = new Label("Street Name: ");
		workerStLbl.setAlignment(Pos.CENTER_RIGHT);
		workerCityLbl = new Label("City: ");
		workerCityLbl.setAlignment(Pos.CENTER_RIGHT);
		workerStateLbl = new Label("State: ");
		workerStateLbl.setAlignment(Pos.CENTER_RIGHT);
		workerZipLbl = new Label("Zip Code: ");
		workerZipLbl.setAlignment(Pos.CENTER_RIGHT);
		workerPhoneLbl = new Label("Phone: ");
		workerPhoneLbl.setAlignment(Pos.CENTER_RIGHT);
		workerPayLbl = new Label("Salary: ");
		workerPayLbl.setAlignment(Pos.CENTER_RIGHT);
		workerStartLbl = new Label("Shift Start: ");
		workerStartLbl.setAlignment(Pos.CENTER_RIGHT);
		workerEndLbl = new Label("Shift End: ");
		workerEndLbl.setAlignment(Pos.CENTER_RIGHT);
		workerTitleLbl = new Label("Title: ");
		workerTitleLbl.setAlignment(Pos.CENTER_RIGHT);

		workerFNameField = new TextField();
		workerLNameField = new TextField();
		workerStNumField = new TextField();
		workerStField = new TextField();
		workerCityField = new TextField();
		workerStateField = new TextField();
		workerZipField = new TextField();
		workerPhoneField = new TextField();
		workerPayField = new TextField();
		workerStartField = new TextField();
		workerEndField = new TextField();
		workerTitleField = new TextField();

		workerBtn = new Button("Add Worker");
		
		esc = new Button("Exit");
		esc.setOnAction(event -> {
			login = new LoginView(stage);
		});

		leftPane.setMargin(workerFNameLbl, new Insets(20, 0, 0, 0));
		leftPane.setMargin(workerBtn, new Insets(0, 0, 0, 35));
		leftPane.setMargin(esc, new Insets(30, 0, 0, 55));

		leftPane = new VBox(7);

		leftPane.setAlignment(Pos.BASELINE_LEFT);
		leftPane.getChildren().addAll(workerTitleLbl, workerTitleField, workerFNameLbl, workerFNameField,
				workerLNameLbl, workerLNameField, workerStNumLbl, workerStNumField, workerStLbl, workerStField,
				workerCityLbl, workerCityField, workerStateLbl, workerStateField, workerZipLbl, workerZipField,
				workerPhoneLbl, workerPhoneField, workerPayLbl, workerPayField, workerStartLbl, workerStartField,
				workerEndLbl, workerEndField, workerBtn, esc);
		
		pane = new HBox(30);
		
		pane.getChildren().addAll(leftPane);
		stage.setScene(new Scene(pane, 350, 800));
		stage.setTitle("Manager's View");
		stage.show();

	}

}
