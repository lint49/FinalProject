package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.TicketEventListener;
import model.TicketEventObject;

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
	ComboBox<String> tickets;

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
	// private TextField managerStateField;
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

	private TextField outDate;
	private TextField outPrice;

	ComboBox<String> states;

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

	private TicketEventListener ticketBtnListener;

	public OwnerView(Stage stage) {
		this.stage = stage;

		ticketNameLbl = new Label("Ticket Name: ");
		ticketNameLbl.setAlignment(Pos.CENTER_RIGHT);
		dateLbl = new Label("Date: ");
		dateLbl.setAlignment(Pos.CENTER_RIGHT);
		ticketPriceLbl = new Label("Price: ");
		ticketPriceLbl.setAlignment(Pos.CENTER_RIGHT);
		outDate = new TextField();
		outDate.setAlignment(Pos.CENTER_RIGHT);
		outPrice = new TextField();
		outPrice.setAlignment(Pos.CENTER_RIGHT);

		ticketNameField = new TextField();
		ticketDateField = new TextField();
		ticketPriceField = new TextField();

		ticketPriceField.setText("0.0");

		ticketBtn = new Button("Add Ticket");
		esc = new Button("Exit");

		esc.setOnAction(event -> {
			login = new LoginView(stage);
		});

		leftPane = new VBox(7);

		tickets = new ComboBox<>();

		tickets.getItems().addAll("A - 10/20/2016 \n$60", "B - 10/22/2016 \n$65", "C - 10/26/2016 \n$85");

		leftPane.setMargin(ticketNameLbl, new Insets(20, 0, 0, 15));
		leftPane.setMargin(ticketNameField, new Insets(0, 0, 0, 15));
		leftPane.setMargin(outDate, new Insets(20, 0, 0, 15));
		leftPane.setMargin(outPrice, new Insets(0, 0, 0, 15));
		leftPane.setMargin(dateLbl, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketDateField, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketPriceLbl, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketPriceField, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketBtn, new Insets(0, 0, 0, 50));
		leftPane.setMargin(tickets, new Insets(0, 0, 0, 50));

		leftPane.setAlignment(Pos.BASELINE_LEFT);
		leftPane.getChildren().addAll(ticketNameLbl, ticketNameField, dateLbl, ticketDateField, ticketPriceLbl,
				ticketPriceField, ticketBtn, tickets);

		ticketBtn.setOnAction(event -> {
			String name = ticketNameField.getText();
			String date = ticketDateField.getText();
			double price = Double.parseDouble(ticketPriceField.getText());
			TicketEventObject ev = new TicketEventObject(this, name, date, price);
			if (ticketBtnListener != null) {
				ticketBtnListener.ticketBtnClicked(ev);

				if (ticketNameField == null || ticketNameField.getText().trim().isEmpty()) {
					Alert emptyName = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
					emptyName.setContentText("Ticket name is EMPTY");
					emptyName.initModality(Modality.APPLICATION_MODAL);
					emptyName.showAndWait();
					if (emptyName.getResult() == ButtonType.OK) {
						emptyName.close();
						ticketNameField.requestFocus();
					}
				}

				if (ticketDateField == null || ticketDateField.getText().trim().isEmpty()) {
					Alert emptyDate = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
					emptyDate.setContentText("Date Field is EMPTY");
					emptyDate.initModality(Modality.APPLICATION_MODAL);
					emptyDate.showAndWait();
					if (emptyDate.getResult() == ButtonType.OK) {
						emptyDate.close();
						ticketNameField.requestFocus();
					}
				}

				if (ticketPriceField == null || ticketPriceField.getText().trim().isEmpty()) {
					Alert emptyPrice = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
					emptyPrice.setContentText("Price Field is EMPTY");
					emptyPrice.initModality(Modality.APPLICATION_MODAL);
					emptyPrice.showAndWait();
					if (emptyPrice.getResult() == ButtonType.OK) {
						emptyPrice.close();
						ticketNameField.requestFocus();
					}
				}
			}
		});

		////////////////////////////////////// right pane for wine
		////////////////////////////////////// ////////////////////////////////////////////////

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

		/////////////////////////////////////// pane for adding manager
		/////////////////////////////////////// ///////////////////////////////////////////
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
		// managerStateField = new TextField();
		managerZipField = new TextField();
		managerPhoneField = new TextField();
		managerPayField = new TextField();
		managerStartField = new TextField();
		managerEndField = new TextField();

		states = new ComboBox<>();
		states.getItems().addAll("", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
				"Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois",
				"Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
				"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
				"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
				"Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah",
				"Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");

		managerBtn = new Button("Add Manager");

		right2Pane.setMargin(managerFNameLbl, new Insets(20, 0, 0, 0));
		right2Pane.setMargin(managerBtn, new Insets(0, 0, 0, 35));

		right2Pane = new VBox(7);
		right2Pane.setAlignment(Pos.BASELINE_LEFT);
		right2Pane.getChildren().addAll(managerFNameLbl, managerFNameField, managerLNameLbl, managerLNameField,
				managerStNumLbl, managerStNumField, managerStLbl, managerStField, managerCityLbl, managerCityField,
				managerStateLbl, states, managerZipLbl, managerZipField, managerPhoneLbl, managerPhoneField,
				managerPayLbl, managerPayField, managerStartLbl, managerStartField, managerEndLbl, managerEndField,
				managerBtn, esc);

		pane = new HBox(30);

		pane.getChildren().addAll(leftPane, rightPane, right2Pane);
		stage.setScene(new Scene(pane, 600, 700));
		stage.setTitle("Owner's View");
		stage.show();

	}

	public void setTicketBtnListener(TicketEventListener ticketBtnListener) {
		this.ticketBtnListener = ticketBtnListener;
	}

	public void comboTicket(String name) {
		tickets.getItems().add(name);

	}

}
