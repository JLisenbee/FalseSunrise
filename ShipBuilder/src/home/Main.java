package home;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage mainstage) throws Exception {

		mainstage.setTitle("False Sunrise Ship Builder");
		
		GridPane root = new GridPane();
		
		root.setHgap(10);
		root.setVgap(10);
		
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
	
		root.add(new Label("Title Space"), 0, 0);
		
		root.add(corvButton, 0, 1);
		root.add(frigButton, 1, 1);
		root.add(destButton, 2, 1);
		root.add(cruiButton, 3, 1);
		root.add(flagButton, 4, 1);
		
		
		mainstage.setScene(new Scene(root));
		mainstage.show();
		
	}

	

}
