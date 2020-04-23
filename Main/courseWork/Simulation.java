package courseWork;
//import javafx.application.Application;

public class Simulation {
	
	MenuController MenuVars;


	public Simulation(MenuController m) {
		MenuVars = m;

	}
	

	public void run() {
		System.out.println("Working");
		Building building1 = new Building();
		System.out.println("Building Created");
		int noOfFloors = MenuVars.getFloors();
		System.out.println(noOfFloors);
		//building1.addFloors(MenuVars.getFloors());
		building1.registerElevator(1);
		System.out.println("Building Setup");
	}
}
