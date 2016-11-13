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

	// pane
	private VBox leftPane;
	private VBox rightPane;

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

		leftPane = new VBox(10);

		leftPane.setMargin(ticketNameLbl, new Insets(20, 0, 0, 15));
		leftPane.setMargin(ticketNameField, new Insets(0, 0, 0, 15));
		leftPane.setMargin(dateLbl, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketDateField, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketPriceLbl, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketPriceField, new Insets(0, 0, 0, 15));
		leftPane.setMargin(ticketBtn, new Insets(0, 0, 0, 50));

		leftPane.setAlignment(Pos.BASELINE_LEFT);
		leftPane.getChildren().addAll(ticketNameLbl, ticketNameField, dateLbl, ticketDateField, ticketPriceLbl,
				ticketPriceField, ticketBtn);

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

		rightPane = new VBox(10);
		rightPane.setAlignment(Pos.BASELINE_LEFT);
		rightPane.getChildren().addAll(wineNameLbl, wineNameField, wineTypeLbl, wineTypeField, regionLbl, regionField,
				alcoholPercentageLbl, alcoholPercentageField, winePriceLbl, winetPriceField, wineBtn);

		pane = new HBox(30);

		pane.getChildren().addAll(leftPane, rightPane);
		stage.setScene(new Scene(pane, 355, 450));
		stage.setTitle("Owner's View");
		stage.show();

	}

}
