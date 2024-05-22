package home;

import java.util.Vector;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage mainstage) throws Exception {

		mainstage.setTitle("False Sunrise Ship Builder");
		
		GridPane root = new GridPane();
		
		root.setHgap(10);
		root.setVgap(10);
		
		// Title
		Label title = new Label("Ship Creator");
		title.setFont(new Font("Eurostile", 24));
		title.underlineProperty().set(true);
		
		// Ship Name Box
		TextField shipname = new TextField();
		shipname.setFont(new Font("Eurostile", 16));
		
		// Get Ship Type
		ToggleGroup shipTypes = new ToggleGroup();
		RadioButton corvButton = new RadioButton("Corvette");
		corvButton.setToggleGroup(shipTypes);
		corvButton.setSelected(true);
		RadioButton frigButton = new RadioButton("Frigate");
		frigButton.setToggleGroup(shipTypes);
		RadioButton destButton = new RadioButton("Destroyer");
		destButton.setToggleGroup(shipTypes);
		RadioButton cruiButton = new RadioButton("Cruiser");
		cruiButton.setToggleGroup(shipTypes);
		RadioButton flagButton = new RadioButton("Flagship");
		flagButton.setToggleGroup(shipTypes);
		
		// Ship Dropdown
		ComboBox<Ship> shiplist = new ComboBox<Ship>();
		
		// Labels for Components Categories
		Label weaponlbl = new Label("Weapons");
		weaponlbl.setFont(new Font("Eurostile", 16));
		weaponlbl.underlineProperty().set(true);
		Label upgradelbl = new Label("Upgrades");
		upgradelbl.setFont(new Font("Eurostile", 16));
		upgradelbl.underlineProperty().set(true);
		
		// Ship Upgrades Boxes
		Vector<CheckBox> weapons = new Vector<CheckBox>();
		for (SysList s : SysList.values()) {
			if(s.toString().equals("ADAPTIVE_PLATING")) break;
			weapons.add(new CheckBox(s.toString()));
		}
		Vector<CheckBox> upgrades = new Vector<CheckBox>();
		boolean isUpgradesPart = false;
		for (SysList s : SysList.values()) {
			// Flag to start copying
			if(s.toString().equals("ADAPTIVE_PLATING")) isUpgradesPart = true;
			
			if(isUpgradesPart) upgrades.add(new CheckBox(s.toString()));
		}
		
		// New Ship Button
		Button newship = new Button("Add Ship to Fleet");
		newship.setFont(new Font("Eurostile", 16));
		newship.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
						
				// Create Ship
				Ship added = new Ship(null, shipname.getText().toUpperCase());
						
				// Get Ship Type
				if(corvButton.isSelected()) added.setClassID(ShipTypes.CORVETTE);
				if(frigButton.isSelected()) added.setClassID(ShipTypes.FRIGATE);
				if(destButton.isSelected()) added.setClassID(ShipTypes.DESTROYER);
				if(cruiButton.isSelected()) added.setClassID(ShipTypes.CRUISER);
				if(flagButton.isSelected()) added.setClassID(ShipTypes.FLAGSHIP);
						
				// Get Ship Components
				added.clean();
				System.out.println(upgrades.size());
				for(int i = 0; i < weapons.size(); i++)
				{
					if(weapons.get(i).isSelected()) 
						added.addSystem(new Sys(SysList.valueOf(weapons.get(i).getText())));
				}
				for(int i = 0; i < upgrades.size(); i++)
				{
					if(upgrades.get(i).isSelected()) {
						added.addSystem(new Sys(SysList.valueOf(upgrades.get(i).getText())));
						
						System.out.println(SysList.valueOf(upgrades.get(i).getText()));
					}
						
				}
						
				System.out.println(added.toString());
				shiplist.getItems().add(added);
			}
		});
		
		// TODO change checkboxes to text entries of some form
		
		
		
		// TODO Add way to print/export the ships. maybe to text file?
		
		root.add(title, 0, 0);
		root.add(shipname, 0, 1);
		
		root.add(corvButton, 1, 0);
		root.add(frigButton, 2, 0);
		root.add(destButton, 3, 0);
		root.add(cruiButton, 4, 0);
		root.add(flagButton, 5, 0);
		
		root.add(shiplist, 0, 2);
		
		root.add(weaponlbl, 0, 3);
		root.add(upgradelbl, 1, 3);
		
		for(int i = 0; i < weapons.size(); i++) {
			root.add(weapons.get(i), 0, i+4);
		}
		for(int i = 0; i < upgrades.size(); i++) {
			root.add(upgrades.get(i), 1, i+4);
		}
		
		root.add(newship, 1, 1);
		
		
		mainstage.setScene(new Scene(root));
		mainstage.show();
		
	}

	

}
