package view;

import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ManagerEventListener;
import model.ManagerEventObject;
import model.TicketEventListener;
import model.TicketEventObject;
import model.WineEventListener;
import model.WineEventObject;

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
	ComboBox<String> wineTypes;
	ComboBox<String> wines;

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

	ComboBox<String> states;
	ComboBox<String> names;

	private Button managerBtn;

	// manager output
	private Label outManagerFNameLbl;
	private TextField outManagerFNameField;
	private Label outManagerLNameLbl;
	private TextField outManagerLNameField;
	private Label outManagerStNumLbl;
	private TextField outManagerStNumField;
	private Label outManagerStLbl;
	private TextField outManagerStField;
	private Label outManagerCityLbl;
	private TextField outManagerCityField;
	private Label outManagerStateLbl;
	private TextField outManagerStateField;
	private Label outManagerZipLbl;
	private TextField outManagerZipField;
	private Label outManagerPhoneLbl;
	private TextField outManagerPhoneField;
	private Label outManagerPayLbl;
	private TextField outManagerPayField;
	private Label outManagerStartLbl;
	private TextField outManagerStartField;
	private Label outManagerEndLbl;
	private TextField outManagerEndField;

	private TextField enterName;
	private Button find;

	// button to exit to login
	private Button esc;

	// pane
	private VBox leftPane;
	private VBox rightPane;
	private VBox right2Pane;
	private VBox right3Pane;
	private VBox right4Pane;

	private HBox pane;

	// stage
	private Stage stage;

	private TicketEventListener ticketBtnListener;
	private WineEventListener wineBtnListener;
	private ManagerEventListener managerBtnListener;

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

		ticketPriceField.setText("0.0");

		ticketBtn = new Button("Add Ticket");
		esc = new Button("Exit");

		esc.setOnAction(event -> {
			login = new LoginView(stage);
		});

		leftPane = new VBox(8);

		tickets = new ComboBox<>();

		tickets.getItems().addAll();

		leftPane.setMargin(tickets, new Insets(20, 0, 0, 15));
		leftPane.setMargin(ticketNameField, new Insets(0, 0, 0, 15));
		leftPane.setMargin(dateLbl, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketDateField, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketPriceLbl, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketPriceField, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketBtn, new Insets(0, 0, 0, 50));

		leftPane.setAlignment(Pos.BASELINE_LEFT);
		leftPane.getChildren().addAll(tickets, ticketNameLbl, ticketNameField, dateLbl, ticketDateField, ticketPriceLbl,
				ticketPriceField, ticketBtn);

		ticketBtn.setOnAction(event -> {

			if (ticketNameField == null || ticketNameField.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Name");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("Name Is Empty");
				dialog.setContentText("Please enter the name: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					ticketNameField.setText(result.get());
				}
			}

			if (ticketDateField == null || ticketDateField.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Date");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("Date Is Empty");
				dialog.setContentText("Please enter the Date: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					ticketDateField.setText(result.get());
				}
			}

			String name = ticketNameField.getText();
			String date = ticketDateField.getText();
			double price = Double.parseDouble(ticketPriceField.getText());
			TicketEventObject ev = new TicketEventObject(this, name, date, price);

			if (ticketBtnListener != null) {
				ticketBtnListener.ticketBtnClicked(ev);
			}
		});

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
		// wineTypeField = new TextField();
		regionField = new TextField();
		alcoholPercentageField = new TextField();
		winetPriceField = new TextField();

		wineTypes = new ComboBox<>();
		wineTypes.getItems().addAll("", "RIESLING", "CHARDONNAY", "SYRAH", "MERLOT", "PINOT NOIR");

		wines = new ComboBox<>();

		wineBtn = new Button("Add Wine");

		alcoholPercentageField.setText("0");
		winetPriceField.setText("0.0");

		rightPane.setMargin(wines, new Insets(20, 0, 0, 0));
		rightPane.setMargin(wineBtn, new Insets(0, 0, 0, 35));
		// rightPane.setMargin(wines, new Insets(0, 0, 0, 35));

		rightPane = new VBox(8);

		rightPane.setAlignment(Pos.BASELINE_LEFT);
		rightPane.getChildren().addAll(wines, wineNameLbl, wineNameField, wineTypeLbl, wineTypes, regionLbl,
				regionField, alcoholPercentageLbl, alcoholPercentageField, winePriceLbl, winetPriceField, wineBtn);

		wineBtn.setOnAction(event -> {

			if (wineNameField == null || wineNameField.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Name");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("Wine Name Is Empty");
				dialog.setContentText("Please enter the wine name: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					wineNameField.setText(result.get());
				}
			}

			if (regionField == null || regionField.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Region");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("Region field Is Empty");
				dialog.setContentText("Please enter the region: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					regionField.setText(result.get());
				}
			}

			String wineName = wineNameField.getText();
			String wineType = wineTypes.getValue();
			String region = regionField.getText();
			int alcoholPercentage = Integer.parseInt(alcoholPercentageField.getText());
			double price = Double.parseDouble(winetPriceField.getText());
			WineEventObject ev = new WineEventObject(this, wineName, wineType, region, alcoholPercentage, price);

			if (wineBtnListener != null) {
				wineBtnListener.wineBtnClicked(ev);
			}

		});

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
		// managerStateField = new TextField();
		managerZipField = new TextField();
		managerPhoneField = new TextField();
		managerPayField = new TextField();
		managerStartField = new TextField();
		managerEndField = new TextField();

		names = new ComboBox<>();

		states = new ComboBox<>();
		states.getItems().addAll("", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
				"Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois",
				"Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
				"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
				"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
				"Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah",
				"Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");

		managerBtn = new Button("Add Manager");

		right2Pane.setMargin(names, new Insets(20, 0, 0, 0));
		right2Pane.setMargin(managerBtn, new Insets(0, 0, 0, 35));
		// right2Pane.setMargin(names, new Insets(0, 0, 0, 35));

		right2Pane = new VBox(8);
		right2Pane.setAlignment(Pos.BASELINE_LEFT);
		right2Pane.getChildren().addAll(names, managerFNameLbl, managerFNameField, managerLNameLbl, managerLNameField,
				managerStNumLbl, managerStNumField, managerStLbl, managerStField, managerCityLbl, managerCityField,
				managerStateLbl, states, managerZipLbl, managerZipField, managerPhoneLbl, managerPhoneField,
				managerPayLbl, managerPayField, managerStartLbl, managerStartField, managerEndLbl, managerEndField,
				managerBtn);

		// addManager Button
		managerBtn.setOnAction(event -> {

			if (managerFNameField == null || managerFNameField.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("First Name");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("First Name field Is Empty");
				dialog.setContentText("Please enter the first name: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					managerFNameField.setText(result.get());
				}
			}

			if (managerLNameField == null || managerLNameField.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Last Name");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("Last name field Is Empty");
				dialog.setContentText("Please enter the last name: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					managerLNameField.setText(result.get());
				}
			}

			if (managerPhoneField == null || managerPhoneField.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Phone");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("Phone field Is Empty");
				dialog.setContentText("Please enter the phone number: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					managerPhoneField.setText(result.get());
				}
			}

			if (managerPayField == null || managerPayField.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Salary");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("Salary field Is Empty");
				dialog.setContentText("Please enter the salary: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					managerPayField.setText(result.get());
				}
			}

			String firstName = managerFNameField.getText();
			String lastName = managerLNameField.getText();
			String stNum = managerStNumField.getText();
			String stName = managerStField.getText();
			String city = managerCityField.getText();
			String state = states.getValue();
			String zip = managerZipField.getText();
			String phone = managerPhoneField.getText();
			String salary = managerPayField.getText();
			String shiftStart = managerStartField.getText();
			String shiftEnd = managerEndField.getText();

			ManagerEventObject ev = new ManagerEventObject(this, firstName, lastName, stNum, stName, city, state, zip,
					phone, salary, shiftStart, shiftEnd);

			if (managerBtnListener != null) {
				managerBtnListener.managerBtnClicked(ev);
			}

			managerFNameField.clear();
			managerLNameField.clear();
			managerStNumField.clear();
			managerStField.clear();
			managerCityField.clear();
			managerZipField.clear();
			managerPhoneField.clear();
			managerPayField.clear();
			managerStartField.clear();
			managerEndField.clear();

		});

		// manager output
		outManagerFNameLbl = new Label("First Name: ");
		outManagerFNameLbl.setAlignment(Pos.CENTER_RIGHT);
		outManagerLNameLbl = new Label("Last Name: ");
		outManagerLNameLbl.setAlignment(Pos.CENTER_RIGHT);
		outManagerStNumLbl = new Label("Street Number: ");
		outManagerStNumLbl.setAlignment(Pos.CENTER_RIGHT);
		outManagerStLbl = new Label("Street Name: ");
		outManagerStLbl.setAlignment(Pos.CENTER_RIGHT);
		outManagerCityLbl = new Label("City: ");
		outManagerCityLbl.setAlignment(Pos.CENTER_RIGHT);
		outManagerStateLbl = new Label("State: ");
		outManagerStateLbl.setAlignment(Pos.CENTER_RIGHT);
		outManagerZipLbl = new Label("Zip Code: ");
		outManagerZipLbl.setAlignment(Pos.CENTER_RIGHT);
		outManagerPhoneLbl = new Label("Phone: ");
		outManagerPhoneLbl.setAlignment(Pos.CENTER_RIGHT);
		outManagerPayLbl = new Label("Salary: ");
		outManagerPayLbl.setAlignment(Pos.CENTER_RIGHT);
		outManagerStartLbl = new Label("Shift Start: ");
		outManagerStartLbl.setAlignment(Pos.CENTER_RIGHT);
		outManagerEndLbl = new Label("Shift End: ");
		outManagerEndLbl.setAlignment(Pos.CENTER_RIGHT);

		outManagerFNameField = new TextField();
		outManagerFNameField.setEditable(false);
		outManagerLNameField = new TextField();
		outManagerLNameField.setEditable(false);
		outManagerStNumField = new TextField();
		outManagerStNumField.setEditable(false);
		outManagerStField = new TextField();
		outManagerStField.setEditable(false);
		outManagerCityField = new TextField();
		outManagerCityField.setEditable(false);
		outManagerStateField = new TextField();
		outManagerStateField.setEditable(false);
		outManagerZipField = new TextField();
		outManagerZipField.setEditable(false);
		outManagerPhoneField = new TextField();
		outManagerPhoneField.setEditable(false);
		outManagerPayField = new TextField();
		outManagerPayField.setEditable(false);
		outManagerStartField = new TextField();
		outManagerStartField.setEditable(false);
		outManagerEndField = new TextField();
		outManagerEndField.setEditable(false);
		enterName = new TextField();
		enterName.setPromptText("Enter First Name");

		find = new Button("Find");

		right2Pane.setMargin(enterName, new Insets(20, 0, 0, 0));

		right3Pane = new VBox(8);
		right3Pane.setAlignment(Pos.BASELINE_LEFT);
		right3Pane.getChildren().addAll(enterName, outManagerFNameLbl, outManagerFNameField, outManagerLNameLbl,
				outManagerLNameField, outManagerStNumLbl, outManagerStNumField, outManagerStLbl, outManagerStField,
				outManagerCityLbl, outManagerCityField, outManagerStateLbl, outManagerStateField, outManagerZipLbl,
				outManagerZipField, outManagerPhoneLbl, outManagerPhoneField, outManagerPayLbl, outManagerPayField,
				outManagerStartLbl, outManagerStartField, outManagerEndLbl, outManagerEndField);

		right4Pane = new VBox(8);
		right4Pane.setAlignment(Pos.BASELINE_LEFT);
		right4Pane.setMargin(find, new Insets(20, 0, 0, 0));
		right4Pane.getChildren().addAll(find, esc);

		find.setOnAction(event -> {
			if (enterName == null || enterName.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Enter Name");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("Enter Name field Is Empty");
				dialog.setContentText("Please enter the first name: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					enterName.setText(result.get());
				}
			}

			ManagerEventObject ev = new ManagerEventObject(this);

			if (managerBtnListener != null) {
				managerBtnListener.findBtnClicked(ev);
			}

		});

		pane = new HBox(30);

		pane.getChildren().addAll(leftPane, rightPane, right2Pane, right3Pane, right4Pane);
		stage.setScene(new Scene(pane, 800, 800));
		stage.setTitle("Owner's View");
		stage.show();

	}

	public void setManagerBtnListener(ManagerEventListener managerBtnListener) {
		this.managerBtnListener = managerBtnListener;
	}

	public void setWineBtnListener(WineEventListener wineBtnListener) {
		this.wineBtnListener = wineBtnListener;
	}

	public void setTicketBtnListener(TicketEventListener ticketBtnListener) {
		this.ticketBtnListener = ticketBtnListener;
	}

	public void comboTicket(String name) {
		tickets.getItems().add(name);

	}

	public void comboWine(String name) {
		wines.getItems().add(name);
	}

	public void comboNames(String name) {
		names.getItems().add(name);
	}

	public void setManagerFName(String fName) {
		outManagerFNameField.clear();
		outManagerFNameField.setText(fName);
	}

	public void setManagerLName(String lName) {
		outManagerLNameField.clear();
		outManagerLNameField.setText(lName);
	}

	public void setManagerStNum(String stNum) {
		outManagerStNumField.clear();
		outManagerStNumField.setText(stNum);
	}

	public void setManagerStName(String stName) {
		outManagerStField.clear();
		outManagerStField.setText(stName);
	}

	public void setManagerCity(String city) {
		outManagerCityField.clear();
		outManagerCityField.setText(city);
	}

	public void setManagerState(String state) {
		outManagerStateField.clear();
		outManagerStateField.setText(state);
	}

	public void setManagerZip(String zip) {
		outManagerZipField.clear();
		outManagerZipField.setText(zip);
	}

	public void setManagerPhone(String phone) {
		outManagerPhoneField.clear();
		outManagerPhoneField.setText(phone);
	}

	public void setManagerStart(String start) {
		outManagerStartField.clear();
		outManagerStartField.setText(start);
	}

	public void setManagerPay(String pay) {
		outManagerPayField.clear();
		outManagerPayField.setText(pay);
	}

	public void setManagerEnd(String end) {
		outManagerEndField.clear();
		outManagerEndField.setText(end);
	}

	public String getName() {
		return enterName.getText();

	}
}
