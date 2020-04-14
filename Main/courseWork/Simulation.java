package courseWork;

//package Main;
//import javafx.application.Application;
import javafx.stage.Stage;

public class Simulation {

	private Building building1;
	private Person person;
	private int tick;
	// private Random random;
	private String testingGit;
	private String saharTesting;

	public Simulation() {

	}
	
	public void run() {
		building1 = new Building();
		building1.addFloors(7);
		building1.registerElevator();
		System.out.println("Building Setup");
	}

	public static void main(String[] args) {
		System.out.println("WorkingFinally");
		Simulation S = new Simulation();
		S.run();
	}
	
}
