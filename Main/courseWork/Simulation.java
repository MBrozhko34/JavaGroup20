package courseWork;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
//package Main;
//import javafx.application.Application;
import javafx.stage.Stage;

public class Simulation {

	private Building building1;
	private Person person;
	
	@FXML
	private Slider Pslider;
	
	@FXML
	private Slider Qslider;
	
	@FXML
	private Spinner<Integer> floors;
	
	@FXML
	private Spinner<Integer> ticks;
	
	@FXML
	private Spinner<Integer> elevatorcap;
	
	@FXML
	private Spinner<Integer> employees;
	
	@FXML
	private Spinner<Integer> mugdevs;
	
	@FXML
	private Spinner<Integer> goggledevs;
	
	
	
	// private Random random;
	private String testingGit;
	private String saharTesting;

	public Simulation() {

	}
	
	public void run() {
		building1 = new Building();
		building1.addFloors(floors.getValue());
		building1.registerElevator(1);
		System.out.println("Building Setup");
	}

	public static void main(String[] args) {
		System.out.println("WorkingFinally");
		Simulation S = new Simulation();
		S.run();
	}
	
}
