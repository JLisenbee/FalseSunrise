package home;

public class Main {

	public static void main(String[] args) {


		Ship spotter = new Ship(ShipTypes.FRIGATE, "Queen Anne's Revenge");
		
		spotter.addSystem(new Sys(SysList.THRUSTER_OVERCHARGERS));
		spotter.addSystem(new Sys(SysList.SPITFIRE_CIWS));
		
		System.out.println(spotter.toString());

	}

}
