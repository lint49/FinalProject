package view;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.ManagerEventObject;
import model.Wine;
import model.Worker;
import model.WorkerEventListener;
import model.WorkerEventObject;

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
	private Label workerZipLbl;
	private TextField workerZipField;
	private Label workerPhoneLbl;
	private TextField workerPhoneField;
	private Label workerPayLbl;
	private TextField workerPayField;
	private Label workerStartLbl;
	private Label workerTitleLbl;

	ComboBox<String> workerType;
	ComboBox<String> states;

	DatePicker dateStart = new DatePicker();

	private WorkerEventListener workerBtnListener;

	// worker table view
	private final TableView<Worker> workerTable = new TableView<>();

	private final ObservableList<Worker> workerData = FXCollections.observableArrayList(

			new Worker("John", "Smith", "160", "Broadway", "Brendwood", "New York", "11221", "6315551252", "Bartender",
					50000, "2015-12-12")

	);

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
		workerStartLbl = new Label("Date Start: ");
		workerStartLbl.setAlignment(Pos.CENTER_RIGHT);
		workerTitleLbl = new Label("Title: ");
		workerTitleLbl.setAlignment(Pos.CENTER_RIGHT);

		workerFNameField = new TextField();
		workerLNameField = new TextField();
		workerStNumField = new TextField();
		workerStField = new TextField();
		workerCityField = new TextField();
		workerZipField = new TextField();
		workerPhoneField = new TextField();
		workerPayField = new TextField();

		workerBtn = new Button("Add Worker");

		esc = new Button("Exit");
		esc.setOnAction(event -> {
			login = new LoginView(stage);
		});
		
		esc.setStyle("-fx-font: 20 arial; -fx-base: #ff4d4d;");

		leftPane.setMargin(workerTitleLbl, new Insets(20, 0, 0, 20));

		leftPane.setMargin(workerFNameLbl, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerFNameField, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerLNameLbl, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerLNameField, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerStNumLbl, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerStNumField, new Insets(0, 0, 0, 20));

		leftPane.setMargin(workerStLbl, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerCityLbl, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerStateLbl, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerZipLbl, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerPhoneLbl, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerStartLbl, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerStField, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerCityField, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerPhoneField, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerPayField, new Insets(0, 0, 0, 20));
		leftPane.setMargin(dateStart, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerZipField, new Insets(0, 0, 0, 20));
		leftPane.setMargin(workerPayLbl, new Insets(0, 0, 0, 20));

		leftPane.setMargin(workerBtn, new Insets(0, 0, 0, 55));
		leftPane.setMargin(esc, new Insets(30, 0, 0, 70));

		workerType = new ComboBox<>();
		workerType.getItems().addAll("", "Bartender", "Dancer", "DJ", "Security", "Waitress");

		states = new ComboBox<>();
		states.getItems().addAll("", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
				"Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois",
				"Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
				"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
				"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
				"Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah",
				"Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");

		// workerBtn action
		workerBtn.setOnAction(event -> {

			if (workerFNameField == null || workerFNameField.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("First Name");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("First Name field Is Empty");
				dialog.setContentText("Please enter the first name: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					workerFNameField.setText(result.get());
				}
			}

			if (workerLNameField == null || workerLNameField.getText().trim().isEmpty()) {
				TextInputDialog dialog = new TextInputDialog("Last Name");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("Last name field Is Empty");
				dialog.setContentText("Please enter the last name: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					workerLNameField.setText(result.get());
				}
			}

			if (workerZipField == null || workerZipField.getText().trim().isEmpty()
					|| workerZipField.getText().length() != 5) {
				TextInputDialog dialog = new TextInputDialog("Zip");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("Zip field Is Empty or It's not 5 digits");
				dialog.setContentText("Please enter the right zip code: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					workerPhoneField.setText(result.get());
				}
			}

			if (workerPhoneField == null || workerPhoneField.getText().trim().isEmpty()
					|| workerPhoneField.getText().length() != 10) {
				TextInputDialog dialog = new TextInputDialog("Phone");
				dialog.setTitle("Text Input Dialog");
				dialog.setHeaderText("Phone field Is Empty or It's not 10 digits");
				dialog.setContentText("Please enter the phone number: ");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					workerPhoneField.setText(result.get());
				}
			}

			String firstName = workerFNameField.getText();
			String lastName = workerLNameField.getText();
			String stNum = workerStNumField.getText();
			String stName = workerStField.getText();
			String city = workerCityField.getText();
			String state = states.getValue();
			String title = workerType.getValue();
			String zip = workerZipField.getText();
			String phone = workerPhoneField.getText();
			double workerPay = Double.parseDouble(workerPayField.getText());
			String dateStarted = dateStart.getValue().toString();

			WorkerEventObject ev = new WorkerEventObject(this, firstName, lastName, stNum, stName, city, state, zip,
					phone, title, workerPay, dateStarted);

			workerData.add(new Worker(workerFNameField.getText(), workerLNameField.getText(),
					workerStNumField.getText(), workerStField.getText(), workerCityField.getText(), states.getValue(),
					workerZipField.getText(), workerPhoneField.getText(), workerType.getValue(),
					Double.parseDouble(workerPayField.getText()), dateStart.getValue().toString()));

			if (workerBtnListener != null) {
				workerBtnListener.workerBtnClicked(ev);
			}

			workerFNameField.clear();
			workerLNameField.clear();
			workerStNumField.clear();
			workerStField.clear();
			workerCityField.clear();
			workerZipField.clear();
			workerPhoneField.clear();
			workerPayField.clear();
			dateStart.getEditor().clear();

		});

		// -----------------------------------WorkerTable------------------------

		TableColumn workerCol = new TableColumn("Worker");

		TableColumn nameCol = new TableColumn("Name");
		TableColumn addressCol = new TableColumn("Address");

		TableColumn firstNameCol = new TableColumn("First Name");
		firstNameCol.setMinWidth(20);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		TableColumn lastNameCol = new TableColumn("Last Name");
		lastNameCol.setMinWidth(20);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

		TableColumn stNumberCol = new TableColumn("Street Number");
		stNumberCol.setMinWidth(20);
		stNumberCol.setCellValueFactory(new PropertyValueFactory<>("stNum"));

		TableColumn streetNameCol = new TableColumn("Street Name");
		streetNameCol.setMinWidth(50);
		streetNameCol.setCellValueFactory(new PropertyValueFactory<>("stName"));

		TableColumn cityCol = new TableColumn("City");
		cityCol.setMinWidth(50);
		cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));

		TableColumn stateCol = new TableColumn("State");
		stateCol.setMinWidth(90);
		stateCol.setCellValueFactory(new PropertyValueFactory<>("state"));

		TableColumn zipCodeCol = new TableColumn("Zip Code");
		zipCodeCol.setMinWidth(50);
		zipCodeCol.setCellValueFactory(new PropertyValueFactory<>("zip"));

		TableColumn phoneCol = new TableColumn("Phone");
		phoneCol.setMinWidth(50);
		phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

		TableColumn payCol = new TableColumn("Salary");
		payCol.setMinWidth(70);
		payCol.setCellValueFactory(new PropertyValueFactory<>("workerPay"));

		TableColumn titleCol = new TableColumn("Title");
		titleCol.setMinWidth(80);
		titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

		TableColumn dsCol = new TableColumn("Date Start");
		dsCol.setMinWidth(50);
		dsCol.setCellValueFactory(new PropertyValueFactory<>("dateStart"));

		nameCol.getColumns().addAll(firstNameCol, lastNameCol);
		addressCol.getColumns().addAll(stNumberCol, streetNameCol, cityCol, stateCol, zipCodeCol);
		workerCol.getColumns().addAll(nameCol, addressCol, phoneCol, payCol, titleCol, dsCol);

		workerTable.getColumns().addAll(workerCol);

		workerTable.setItems(workerData);

		workerTable.setMaxHeight(800);
		workerTable.setMaxWidth(950);

		// ---------------------------------EndTable------------------------------

		leftPane = new VBox(7);

		VBox rightPane = new VBox();

		rightPane.getChildren().add(workerTable);
		rightPane.setMargin(workerTable, new Insets(50, 0, 0, 0));

		VBox.setMargin(workerType, new Insets(0, 0, 0, 20));
		VBox.setMargin(states, new Insets(0, 0, 0, 20));

		leftPane.setAlignment(Pos.BASELINE_LEFT);
		leftPane.getChildren().addAll(workerTitleLbl, workerType, workerFNameLbl, workerFNameField, workerLNameLbl,
				workerLNameField, workerStNumLbl, workerStNumField, workerStLbl, workerStField, workerCityLbl,
				workerCityField, workerStateLbl, states, workerZipLbl, workerZipField, workerPhoneLbl, workerPhoneField,
				workerPayLbl, workerPayField, workerStartLbl, dateStart, workerBtn, esc);
		
		BackgroundImage myBI = new BackgroundImage(new Image("file:src/background.png", 65, 65, false, true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		pane = new HBox(30);
		pane.setBackground(new Background(myBI));
		pane.getChildren().addAll(leftPane, rightPane);
		stage.setScene(new Scene(pane, 1200, 800));
		stage.setTitle("Manager's View");
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
		stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
		stage.show();

	}

	public void setWorkerBtnListener(WorkerEventListener workerBtnListener) {
		this.workerBtnListener = workerBtnListener;
	}
	
	public TableView<Worker> getTable(){
		return workerTable;
	}

}
