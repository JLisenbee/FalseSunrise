package home;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {

		/*
		JFrame frame = new JFrame("Ship Builder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton test = new JButton("Boop!");
		// TODO Set Button Action
		test.setAction(null);
		
		
		frame.getContentPane().add(test);
		
		frame.pack();
		frame.setVisible(true);
		*/
		
		
		Ship spotter = new Ship(ShipTypes.FRIGATE, "Queen Anne's Revenge");
		
		spotter.addSystem(new Sys(SysList.THRUSTER_OVERCHARGERS));
		spotter.addSystem(new Sys(SysList.SPITFIRE_CIWS));
		spotter.addSystem(new Sys(SysList.ADAPTIVE_PLATING));
		
		Ship battleship = new Ship(ShipTypes.FLAGSHIP, "OWC IOWA");
		
		battleship.addSystem(new Sys(SysList.ARTILLERY));
		battleship.addSystem(new Sys(SysList.TURRET_MOUNT));
		battleship.addSystem(new Sys(SysList.ARTILLERY));
		battleship.addSystem(new Sys(SysList.TURRET_MOUNT));
		battleship.addSystem(new Sys(SysList.ARTILLERY));
		battleship.addSystem(new Sys(SysList.TURRET_MOUNT));
		battleship.addSystem(new Sys(SysList.SPITFIRE_CIWS));
		battleship.addSystem(new Sys(SysList.ADAPTIVE_PLATING));
		
		System.out.println(spotter.toString());
		System.out.println(battleship.toString());

	}

}
