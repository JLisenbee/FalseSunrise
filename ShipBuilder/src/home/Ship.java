package home;
import java.util.ArrayList;

public class Ship {
	
	private ShipTypes classID;
	private String name;
	private ArrayList<Sys> systems;

	Ship(ShipTypes classID, String name) {
		/* 
		 * Ship Classes: 
		 * Corvette: 	0
		 * Frigate: 	1
		 * Destroyer:	2
		 * Cruiser: 	3	
		 * Flagship: 	4
		 * */
		this.classID = classID;
		this.name = name;
				
		systems = new ArrayList<Sys>(3);
		
		// Add Engines, Control Bridge, and Fire Control
		systems.add(new Sys(SysList.ENGINES));
		systems.add(new Sys(SysList.CONTROL_BRIDGE));
		systems.add(new Sys(SysList.FIRE_CONTROL));
	}
	
	public ShipTypes getClassID() {
		return classID;
	}
	
	public boolean setClassID(ShipTypes newID) {
		// TODO Check for valid class change (Correct number of Systems, etc)
		classID = newID;
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean setName(String newName) {
		name = newName;
		return true;
	}
	
	public boolean addSystem(Sys newSystem) {
		// TODO Check to see if there's enough room to add more
		systems.add(newSystem);
		
		return true;
	}
	
	public boolean removeSystem(SysList toRemove) {
		// TODO Add Functionality
		return true;
	}
	
	public String toString() {
		String o = "Name: " + getName() + "\n";
		
		for(int i = 0; i < systems.size(); i++) {
			o = o + "- " + systems.get(i).sysID + "\n";
		}
		
		return o;
	}

}
