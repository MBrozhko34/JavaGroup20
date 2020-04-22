package courseWork;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;

public class MenuController {
	
	private Building building1;
	
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
	
	public MenuController() {
		
	}
	
	@FXML 
	public void runClicked() {
		run();
		
	}
	
	public void run() {
		building1 = new Building();
		building1.addFloors(floors.getValue());
		building1.registerElevator(1);
		System.out.println("Building Setup");
	}
	
	

}
