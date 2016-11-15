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

public class OwnerView {
	private LoginView login;
	// for the left -- ticket
	private Label ticketNameLbl;
	private TextField ticketNameField;
	private Label dateLbl;
	private TextField ticketDateField;
	private Label ticketPriceLbl;
	private TextField ticketPriceField;

	private Button ticketBtn;

	// for the right -- wine
	private Label wineNameLbl;
	private TextField wineNameField;
	private Label wineTypeLbl;
	private TextField wineTypeField;
	private Label regionLbl;
	private TextField regionField;
	private Label alcoholPercentageLbl;
	private TextField alcoholPercentageField;
	private Label winePriceLbl;
	private TextField winetPriceField;

	private Button wineBtn;

	// for adding -- manager
	private Label managerFNameLbl;
	private TextField managerFNameField;
	private Label managerLNameLbl;
	private TextField managerLNameField;
	private Label managerStNumLbl;
	private TextField managerStNumField;
	private Label managerStLbl;
	private TextField managerStField;
	private Label managerCityLbl;
	private TextField managerCityField;
	private Label managerStateLbl;
	private TextField managerStateField;
	private Label managerZipLbl;
	private TextField managerZipField;
	private Label managerPhoneLbl;
	private TextField managerPhoneField;
	private Label managerPayLbl;
	private TextField managerPayField;
	private Label managerStartLbl;
	private TextField managerStartField;
	private Label managerEndLbl;
	private TextField managerEndField;

	private Button managerBtn;

	// button to exit to login
	private Button esc;
	
	// pane
	private VBox leftPane;
	private VBox rightPane;
	private VBox right2Pane;

	private HBox pane;

	// stage
	private Stage stage;

	public OwnerView(Stage stage) {
		this.stage = stage;

		ticketNameLbl = new Label("Ticket Name: ");
		ticketNameLbl.setAlignment(Pos.CENTER_RIGHT);
		dateLbl = new Label("Date: ");
		dateLbl.setAlignment(Pos.CENTER_RIGHT);
		ticketPriceLbl = new Label("Price: ");
		ticketPriceLbl.setAlignment(Pos.CENTER_RIGHT);

		ticketNameField = new TextField();
		ticketDateField = new TextField();
		ticketPriceField = new TextField();

		ticketBtn = new Button("Add Ticket");
		esc = new Button("Exit");
		
		esc.setOnAction(event -> {
			login = new LoginView(stage);
		});

		leftPane = new VBox(7);

		leftPane.setMargin(ticketNameLbl, new Insets(20, 0, 0, 15));
		leftPane.setMargin(ticketNameField, new Insets(0, 0, 0, 15));
		leftPane.setMargin(dateLbl, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketDateField, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketPriceLbl, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketPriceField, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketBtn, new Insets(0, 0, 0, 50));
		leftPane.setMargin(esc, new Insets(420, 0, 0, 50));

		leftPane.setAlignment(Pos.BASELINE_LEFT);
		leftPane.getChildren().addAll(ticketNameLbl, ticketNameField, dateLbl, ticketDateField, ticketPriceLbl,
				ticketPriceField, ticketBtn, esc);

		// right pane for wine

		wineNameLbl = new Label("Wine Name: ");
		wineNameLbl.setAlignment(Pos.CENTER_RIGHT);
		wineTypeLbl = new Label("Wine Type: ");
		wineTypeLbl.setAlignment(Pos.CENTER_RIGHT);
		regionLbl = new Label("Region: ");
		regionLbl.setAlignment(Pos.CENTER_RIGHT);
		alcoholPercentageLbl = new Label("Alcohol Percentage: ");
		alcoholPercentageLbl.setAlignment(Pos.CENTER_RIGHT);
		winePriceLbl = new Label("Price: ");
		winePriceLbl.setAlignment(Pos.CENTER_RIGHT);

		wineNameField = new TextField();
		wineTypeField = new TextField();
		regionField = new TextField();
		alcoholPercentageField = new TextField();
		winetPriceField = new TextField();

		wineBtn = new Button("Add Wine");

		rightPane.setMargin(wineNameLbl, new Insets(20, 0, 0, 0));
		rightPane.setMargin(wineBtn, new Insets(0, 0, 0, 35));

		rightPane = new VBox(7);
		rightPane.setAlignment(Pos.BASELINE_LEFT);
		rightPane.getChildren().addAll(wineNameLbl, wineNameField, wineTypeLbl, wineTypeField, regionLbl, regionField,
				alcoholPercentageLbl, alcoholPercentageField, winePriceLbl, winetPriceField, wineBtn);

		// pane for adding manager
		managerFNameLbl = new Label("First Name: ");
		managerFNameLbl.setAlignment(Pos.CENTER_RIGHT);
		managerLNameLbl = new Label("Last Name: ");
		managerLNameLbl.setAlignment(Pos.CENTER_RIGHT);
		managerStNumLbl = new Label("Street Number: ");
		managerStNumLbl.setAlignment(Pos.CENTER_RIGHT);
		managerStLbl = new Label("Street Name: ");
		managerStLbl.setAlignment(Pos.CENTER_RIGHT);
		managerCityLbl = new Label("City: ");
		managerCityLbl.setAlignment(Pos.CENTER_RIGHT);
		managerStateLbl = new Label("State: ");
		managerStateLbl.setAlignment(Pos.CENTER_RIGHT);
		managerZipLbl = new Label("Zip Code: ");
		managerZipLbl.setAlignment(Pos.CENTER_RIGHT);
		managerPhoneLbl = new Label("Phone: ");
		managerPhoneLbl.setAlignment(Pos.CENTER_RIGHT);
		managerPayLbl = new Label("Salary: ");
		managerPayLbl.setAlignment(Pos.CENTER_RIGHT);
		managerStartLbl = new Label("Shift Start: ");
		managerStartLbl.setAlignment(Pos.CENTER_RIGHT);
		managerEndLbl = new Label("Shift End: ");
		managerEndLbl.setAlignment(Pos.CENTER_RIGHT);

		managerFNameField = new TextField();
		managerLNameField = new TextField();
		managerStNumField = new TextField();
		managerStField = new TextField();
		managerCityField = new TextField();
		managerStateField = new TextField();
		managerZipField = new TextField();
		managerPhoneField = new TextField();
		managerPayField = new TextField();
		managerStartField = new TextField();
		managerEndField = new TextField();

		managerBtn = new Button("Add Manager");
		
		right2Pane.setMargin(managerFNameLbl, new Insets(20, 0, 0, 0));
		right2Pane.setMargin(managerBtn, new Insets(0, 0, 0, 35));

		right2Pane = new VBox(7);
		right2Pane.setAlignment(Pos.BASELINE_LEFT);
		right2Pane.getChildren().addAll(managerFNameLbl, managerFNameField, managerLNameLbl, managerLNameField,
				managerStNumLbl, managerStNumField, managerStLbl, managerStField, managerCityLbl, managerCityField,
				managerStateLbl, managerStateField, managerZipLbl, managerZipField, managerPhoneLbl, managerPhoneField,
				managerPayLbl, managerPayField, managerStartLbl, managerStartField, managerEndLbl, managerEndField,
				managerBtn);

		pane = new HBox(30);

		pane.getChildren().addAll(leftPane, rightPane, right2Pane);
		stage.setScene(new Scene(pane, 600, 700));
		stage.setTitle("Owner's View");
		stage.show();

	}

}
