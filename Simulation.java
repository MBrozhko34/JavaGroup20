package elevatorSimulation;

import javafx.application.Application;
import javafx.stage.Stage;

public class Simulation extends Application {
	
}
	private Building building;
	private Elevator elevator;
	private Person person;
	private int tick;
	private Random random;
	private String testingGit;
	public Simulation() {
	building = new Building();
	elevator = new Elevator();
	tick = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
