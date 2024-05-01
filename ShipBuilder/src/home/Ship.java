package home;
import java.util.ArrayList;

public class Ship {
	
	private int classID;
	private ArrayList<System> systems;

	Ship(int classID) {
		/* 
		 * Ship Classes: 
		 * Corvette: 	0
		 * Frigate: 	1
		 * Destroyer:	2
		 * Cruiser: 	3	
		 * Flagship: 	4
		 * */
		classID = this.classID;
		
		// Add Engines, 
		systems = new ArrayList<System>(3);
		systems.add(new System);
	}
	
	public int getClassID() {
		return classID;
	}
	
	public boolean setClassID (int newID) {
		// TODO Check for valid class change (Correct number of Systems, etc)
		classID = newID;
		return true;
	}

}
