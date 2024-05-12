package home;
import java.util.Vector;

enum ShipTypes {

	CORVETTE,
	FRIGATE,
	DESTROYER,
	CRUISER,
	FLAGSHIP
	
}

public class Ship {
	
	private ShipTypes classID;
	private String name;
	private Vector<Sys> systems;

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
				
		systems = new Vector<Sys>(3);
		
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
		switch(getClassID()) {
		case CORVETTE:
			if(systems.size() < 4) systems.add(newSystem);
			return true;
		case FRIGATE:
			if(systems.size() < 5) systems.add(newSystem);
			return true;
		case DESTROYER:
			if(systems.size() < 7) systems.add(newSystem);
			return true;
		case CRUISER:
			if(systems.size() < 9) systems.add(newSystem);
			return true;
		case FLAGSHIP:
			if(systems.size() < 11) systems.add(newSystem);
			return true;
		default:
			return false;
		}
	}
	
	public boolean removeSystem(SysList toRemove) {

		for (int i = 0; i < systems.size(); i++) {
			if(systems.elementAt(i).sysID == toRemove) {
				systems.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public String toString() {
		String o = "Name: " + getName() + "\n";
		
		for(int i = 0; i < systems.size(); i++) {
			o = o + "- " + systems.get(i).sysID + "\n";
		}
		
		return o;
	}

}
