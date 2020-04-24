package courseWork;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class MenuController {
	
	@FXML
	private Label P;
	
	@FXML
	private Label Q;
	
	@FXML
	private Slider Pslider;
	
	@FXML
	private Slider Qslider;
	
	@FXML
	private Spinner<Integer> seed;
	
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
	
	@FXML
	private Spinner<Integer> elevators;
	

	public MenuController() {
		
	}
	
	@FXML
	public void initialize() {
		Pslider.valueProperty().addListener((prop, oldValue, newValue) -> {
			P.setText(String.format("P: %.2f", newValue));
		});
		
		Qslider.valueProperty().addListener((prop, oldValue, newValue) -> {
			Q.setText(String.format("Q: %.2f", newValue));
		});
		
		SpinnerValueFactory<Integer> values = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
		seed.setValueFactory(values);
		SpinnerValueFactory<Integer> floorvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
		floors.setValueFactory(floorvalues);
		SpinnerValueFactory<Integer> tickvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000);
		ticks.setValueFactory(tickvalues);
		SpinnerValueFactory<Integer> elevatorvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
		elevatorcap.setValueFactory(elevatorvalues);
		SpinnerValueFactory<Integer> emvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
		employees.setValueFactory(emvalues);
		SpinnerValueFactory<Integer> mugvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
		mugdevs.setValueFactory(mugvalues);
		SpinnerValueFactory<Integer> gogvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
		goggledevs.setValueFactory(gogvalues);
		SpinnerValueFactory<Integer> elvalues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
		elevators.setValueFactory(elvalues);
	}
	
	public int getFloors() {
		return floors.getValue();
	}
	
	public int getElevatorcap() {
		return elevatorcap.getValue();
	}


	public int getElevators() {
		return elevators.getValue();
	}

	public Slider getPslider() {
		return Pslider;
	}

	public Slider getQslider() {
		return Qslider;
	}

	public int getSeed() {
		return seed.getValue();
	}

	public int getTicks() {
		return ticks.getValue();
	}

	public int getEmployees() {
		return employees.getValue();
	}

	public int getMugdevs() {
		return mugdevs.getValue();
	}

	public int getGoggledevs() {
		return goggledevs.getValue();
	}

	@FXML 
	public void runClicked() {
		Simulation s = new Simulation(this);
		s.run();
		
	}

}
